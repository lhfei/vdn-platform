var j$ = jQuery;

var myMask = new Ext.LoadMask(Ext.getBody(), {msg:"Please wait..."});

Ext.define('ifeng.controller.AgentController', {
    extend: 'Ext.app.Controller',

    type: -1,
    range: 1,
    country: '',
    city: '',
    
    initSeries: ['移动', '联通', '电信'],
    
    models: [
        'AvlbDaily',
        'DataRangeModel',
        'AvlbMinutely',
        'AuditType',
        'AgentModel',
        'VideoCategoryModel',
        'AvlbMinutelyGrid'
    ],
    stores: [
        'AvlbDailyStore',
        'DataRangeStore',
        'AvlbMinutelyStore',
        'AuditTypeStore',
        'AgentStore',
        'CountryStore',
        'RegionStore',
        'CityStore',
        'LongVideoStore',
        'ShortVideoStore',
        'AvlbMinutelyGridStore'
    ],
    views: [
        'SearchForm',
        'DailyTabPanel',
        'MainView',
        'DailyWin',
        'DailyGrid',
        'AllPanel',
        'AllFilter',
        'SummaryPanel',
        'SummaryForm'
    ],
    
    refs: [
        {ref: 'allPanel', selector: 'allPanel'},
        {ref: 'dailyGrid', selector: 'dailyGrid'},
        {ref: 'dailyPanel', selector: 'dailyPanel'},
        {ref: 'dailyWin', selector: 'dailyWin'},
        {ref: 'searchForm', selector: 'searchForm'},
        {ref: 'allFilter', selector: 'allFilter' },
        {ref: 'summaryForm', selector: 'summaryForm' },
        {ref: 'summaryPanel', selector: 'summaryPanel' }
	],
    
    init: function(application) {
    	Ext.QuickTips.init();
    	
    	Ext.getStore('AvlbDailyStore').addListener('load', this.doAfter, this);
    	
    	Ext.getStore('AvlbMinutelyStore').addListener('beforeload', this.beforeLoadAvlbMinutely, this);
    	
    	Ext.getStore('AvlbMinutelyGridStore').addListener('beforeload', this.beforeLoadAvlbMinutelyGrid, this);
    	
    	this.control({
    		'#summarySearchBtn': {
    			click: this.searchSummary
    		},
    		
    		'#reDrawBtn' : {
    			click: this.reloadChart
    		},
    		
    		'#countryCombo': {
    			change: this.getRegion
    		},
    		
    		'#regionCombo': {
    			change: this.getCity
    		},
    		
    		'#cityCombo': {
    			change: this.setCity
    		},
    		
    		'#rangeCombo' : {
    			change: this.setRange
    		},
    		
    		'#typeCombo': {
    			change: function(){
    				var type = Ext.getCmp('_typeCombo');
    		    	this.type = type.getValue();   
    			}
    		},
    		
    		'#dailyGridCmp button[action=filteData]': {
    			click: this.filteData
    		},
    		
    		'#dailyGridCmp button[action=exportData]': {
    			click: this.exportData
    		}
    		
    	});
    },
    
    onLaunch: function() {
    	var me = this;
    	
    	me.fetchView();
    	
    	for(var i = 0; i< me.initSeries.length; i++) {
    		me.addSeriesByName(me.initSeries[i]);
    	}
    },
    
    searchSummary: function() {
    	this.fetchView();
    },
    
    reloadChart: function(){
    	var me = this;
    	var chart,
    		series,
    		ispCombo;
    	
    	var newSeries = [];
    	var isExist = false;
    	
    	chart = j$('#avlbChart').highcharts();
    	ispCombo = Ext.getCmp('ispCombo');
    	
    	var isp = ispCombo.getSubmitValue();
    	if(typeof(isp) == 'undefined' || isp.length == 0){
    		isp = me.initSeries;
    	}
    	
    	//remove all series
    	series = chart.series;
    	while(series.length > 0){
    		chart.series[0].remove();
    	}
    	
    	for(i = 0; i < isp.length; i++){
			var ispName = isp[i];
			me.addSeriesByName(ispName);
    	}
    },
    
    addSeriesByName: function(name) {
    	if(!name) return false;
    	
    	try{
    		var me,
	    		chart,
	    		url,
	    		category,
	    		country,
	    		city,
	    		type,
	    		range,
	    		searchForm;
    		
    		me = this;
    		type = me.type,
    		country = me.country,
    		city = me.city;
    		range = me.range;
    		
    		searchForm = me.getSearchForm();
    		category = searchForm.category || '';
    		
    		
    		
    		url = '../getAvlb.do?category='+category+'&range=' +range+ '&isp=' +name+ '&country=' +country+ '&city=' +city;
    		
    		myMask.msg = '正在加载  [' +name+ '] 运营商数据, 请稍后 ... ...';
    		myMask.show();
    		
    		j$.ajax({
    			url: url,
    			success: function(response) {
    				var tr = [],
    				avlb = [];
    				
    				j$.map(response.data, function(val, i){
    					tr[i] = val.tr
    					avlb[i] = new Number(val.avlb) * 100;
    				});
    				
    				chart = j$('#avlbChart').highcharts();
    				
    				if(!chart){
    					j$('#avlbChart').highcharts({
    						title: {
    							text: '可用性分时统计'
    						},
    						chart: {
    							height: 300,
    							type: 'line'
    						},
    						tooltip: {
    							valueDecimals: 2,
    							pointFormat: '{series.name}: <b>{point.y}  </b><br/>',
    							valueSuffix: ' %',
    							shared: true
    						},
    						xAxis: {
    							categories: tr
    						},
    						series: [{
    							lineWidth: 1,
    							name: name,
    							data: avlb
    						}],
    						navigation: {
    							buttonOptions: {
    								enabled: true
    							}
    						}
    					});
    				}else {
    					Highcharts.setOptions({
    						xAxis: {
    							categories: tr
    						}
    					});
    					chart.addSeries({
    						lineWidth: 1,
    						name: name,
    						data: avlb
    					});
    				}
    				
    				myMask.hide();
    			},
    			error: function (xhr, ajaxOptions, thrownError) {
    				myMask.hide();
    			}
    		});
    		
    	}catch(e){myMask.hide();}
    	
    },
    
    removeSeriesByName: function(name) {
    	var chart,
    		series;
    	
    	chart = j$('#avlbChart').highcharts();
    	series = chart.series;
    	
    	for(var i = 0; i < series.length; i++){
    		if(name && name == series[i].name){
    			chart.series[i].remove();
    		}
    	}
    },
    
    setCity: function(){
    	var me = this;
    	var city = Ext.getCmp('_cityCombo');
    	me.city = city.getRawValue();    	
    },
    
    setRange: function() {
    	var me = this;
    	var range = Ext.getCmp('_rangeCombo');
    	me.range = range.getValue();
    },
    
    getRegion: function() {
    	var me = this;
    	var country = Ext.getCmp('_countryCombo');
    	if(country){
    		var pId = country.getValue();
    		var store = me.getRegionStoreStore();
    		store.load({url: '../../basic/' +pId+ '/getRegion.do'})
    	}
    },
    
    getCity: function() {
    	var me = this;
    	var region = Ext.getCmp('_regionCombo');
    	if(region){
    		var pId = region.getValue();
    		me.country = region.getRawValue(); 
    			
    		var store = me.getCityStoreStore();
    		store.load({url: '../../basic/' +pId+ '/getRegion.do'})
    	}
    },
    
    beforeLoadAvlbMinutely: function(store, operation, eOpts) {
    	var me = this;
    	store.getProxy().setExtraParam('range', me.range);
    },
    
    beforeLoadAvlbMinutelyGrid: function(store, operation, eOpts) {
    	var me = this;
    	store.getProxy().setExtraParam('range', me.range);
    },
    
    filteData: function() {
    	var me = this;
    	
    	var gridStart,
    		gridEnd;
    	
    	store = me.getAvlbMinutelyGridStoreStore();
    	
    	gridStart = Ext.getCmp('gridStart');
    	gridEnd = Ext.getCmp('gridEnd');
    	
    	if(gridStart && gridEnd){
    		store.getProxy().setExtraParam('startDt', gridStart.getValue());
    		store.getProxy().setExtraParam('endDt', gridEnd.getValue());
    	}
    	
    	store.getProxy().setExtraParam('range', me.range);
    	
    	store.load();
    },
    
    exportData: function() {
    	var me,
    		grid,
    		selModel,
    		data;
    	
    	me = this;
    	grid = me.getDailyGrid();
    	selModel = grid.getSelectionModel();
    	data = selModel.getSelection();
    	
    	if(data && data.length == 1){
    		var item = data[0].data;
    		var tr = item.tr;
    		tr = tr.replace(':', '')
    		
    		document.location.href =' http://114.80.177.136:50070/webhdfs/v1/user/cloudland/vdnlogs/input/' +item.ct+ '/'+tr+ '.sta.gz?op=OPEN';
    	}
    },
    
    // *****************************************************************
    // **
    // *****************************************************************
    fetchView: function() {
    	try{
    		var me,
    			range,
	    		form;
    		
    		me = this;
    		form = me.getSummaryForm();
    		var values = form.getValues();
    		
    		range = values['dataRange'] || 1;
    		category = values['summaryRadio'] || '';
    		url = '../getAvlbSummary.do?range=' +range+ '&category=' +category;
    		
    		myMask.msg = '正在加载 视频概况汇总数据, 请稍后 ... ...';
    		myMask.show();
    		
    		j$.ajax({
    			url: url,
    			success: function(response) {
    				var tr = [],
    					sumChart = [],
	    				summary = [],
    					fluent = [],
    					incomplete = [];
    				
    				j$.map(response.data, function(val, i){
    					tr[i] = val.tr;	//时间段
    					sumChart[i] = new Number(val.ka) * 100;
    					summary[i] = val.a
    					fluent[i] = new Number(val.kb) * 100;
    					incomplete[i] = new Number(val.ke) * 100
    				});
    				
    				j$('#avlbSumChart').highcharts({
						title: {
							text: 'VDN 请求样本数统计概况'
						},
						chart: {
							height: 300,
							type: 'line'
						},
						tooltip: {
							valueDecimals: 2,
							pointFormat: '{series.name}: <b>{point.y}  </b><br/>',
							valueSuffix: '%',
							shared: true
						},
						xAxis: {
							categories: tr
						},
						series: [{
							lineWidth: 1,
							name: '可用性',
							data: sumChart
						}],
						navigation: {
							buttonOptions: {
								enabled: true
							}
						}
					});   				
    				j$('#vdnSummaryChart').highcharts({
						title: {
							text: 'VDN 请求样本数统计概况'
						},
						chart: {
							height: 300,
							type: 'line'
						},
						tooltip: {
							valueDecimals: 0,
							pointFormat: '{series.name}: <b>{point.y}  </b><br/>',
							valueSuffix: '',
							shared: true
						},
						xAxis: {
							categories: tr
						},
						series: [{
							lineWidth: 1,
							name: '样本数',
							data: summary
						}],
						navigation: {
							buttonOptions: {
								enabled: true
							}
						}
					});
    				
    				j$('#fluentChart').highcharts({
						title: {
							text: 'VDN 流畅度统计概况'
						},
						chart: {
							height: 300,
							type: 'line'
						},
						tooltip: {
							valueDecimals: 2,
							pointFormat: '{series.name}: <b>{point.y}  </b><br/>',
							valueSuffix: ' %',
							shared: true
						},
						xAxis: {
							categories: tr
						},
						series: [{
							lineWidth: 1,
							name: '流畅度',
							data: fluent
						}],
						navigation: {
							buttonOptions: {
								enabled: true
							}
						}
					});
    				
    				j$('#incompleteChart').highcharts({
						title: {
							text: '播放不完整率统计概况'
						},
						chart: {
							height: 300,
							type: 'line'
						},
						tooltip: {
							valueDecimals: 2,
							pointFormat: '{series.name}: <b>{point.y}  </b><br/>',
							valueSuffix: ' %',
							shared: true
						},
						xAxis: {
							categories: tr
						},
						series: [{
							lineWidth: 1,
							name: '播放不完整率',
							data: incomplete
						}],
						navigation: {
							buttonOptions: {
								enabled: true
							}
						}
					});
    				
    				myMask.hide();
    			},
    			error: function (xhr, ajaxOptions, thrownError) {
    				myMask.hide();
    			}
    		});
    		
    	}catch(e){myMask.hide();}
    	
    },    
});

