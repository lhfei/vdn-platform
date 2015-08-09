var j$ = jQuery;

Ext.define('ifeng.controller.DailyController', {
    extend: 'Ext.app.Controller',

    type: -1,
    range: -1,
    
    models: [
        'AvlbDaily',
        'DataRangeModel',
        'AvlbMinutely',
        'AuditType'
    ],
    stores: [
        'AvlbDailyStore',
        'DataRangeStore',
        'AvlbMinutelyStore',
        'AuditTypeStore'
    ],
    views: [
        'SearchForm',
        'DailyTabPanel',
        'MainView',
        'DailyWin',
        'DailyGrid',
        'NewsreelPanel',
        'AllPanel',
        'DocumentaryPanel',
        'AllFilter',
        'DocumentaryFilter',
        'NewsreelFilter'
    ],
    
    refs: [
        {ref: 'allPanel', selector: 'allPanel'},
        {ref: 'dailyGrid', selector: 'dailyGrid'},
        {ref: 'dailyPanel', selector: 'dailyPanel'},
        {ref: 'dailyWin', selector: 'dailyWin'},
        {ref: 'documentaryPanel', selector: 'documentaryPanel'},
        {ref: 'newsreelPanel', selector: 'newsreelPanel'},
        
        {ref: 'allFilter', selector: 'allFilter' },
        {ref: 'documentaryFilter', selector: 'documentaryFilter' },
        {ref: 'newsreelFilter', selector: 'newsreelFilter' }
        
	],
    
    init: function(application) {
    	
    	Ext.getStore('AvlbDailyStore').addListener('load', this.doAfter, this);
    	
    	this.control({
    		'mainView > searchForm button[action=doSearch]': {
    			click: this.doSearch
    		},
    		
    		'mainView > allPanel > allFilter > button[action=doCheck]': {
    			click: this.doCheck
    		},
    		
    		'#_dailyWin button[action=showAvlbGrid]': {
    			click: this.showAvlbGrid
    		}
    		
    	});
    },
    
    
    onLaunch: function() {
    	//this.doSearch();
    	var items = Ext.ComponentQuery.query('combobox');
    	for(var i = 0, length = items.length; i < length; i++){
    		var item = items[i];
    		var store = item.getStore();
    		item.setValue(store.getAt(0).get('value'));
    	}
    },
    
    avlbCheck: function(type, range) {
    	var me,
    		win;
    	
    	me = this;
    	me.type = type;
    	me.range = range;
    	
    	if(!win) {
    		win = Ext.create('ifeng.view.DailyWin');
    	}
    	
    	win.show();
    	
      	j$.ajax({
    		url: '../getAvlbMinutely.do?type='+type+'&range='+range,
    		method: 'get',
    		success: function(response) {
    			var 
    				tr_fully = [],
    				tr = [],
					avlb = [];
			
				j$.map(response.data, function(val, i){
					tr_fully[i] = val.ct +' '+ val.tr
					tr[i] = val.tr
					avlb[i] = new Number(val.avlb) * 100;
				});
				
				j$('#avlbChart').highcharts({
			    	title: {
		                text: '可用性分时统计'
		            },
			        chart: {
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
			        	name: '可用性',
			        	data: avlb
			        }],
			        navigation: {
			            buttonOptions: {
			                enabled: false
			            }
			        }
			    });
    		}
    	});
      	
      	j$.ajax({
    		url: '../getFluentMinutely.do?type='+type+'&range='+range,
    		method: 'get',
    		success: function(response) {
    			var tr = [],
    				k1 = [],
    				k2 = [],
					k3 = [],
					k4 = [];
			
				j$.map(response.data, function(val, i){
					tr[i] = val.tr
					k1[i] = new Number(val.k1) * 100;
					k2[i] = new Number(val.k2) * 100;
					k3[i] = new Number(val.k3) * 100;
					k4[i] = new Number(val.k4) * 100;
				});
				
				j$('#fluentChart').highcharts({
			    	title: {
		                text: '流畅度分时统计'
		            },
			        chart: {
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
			        	name: 'K1',
			        	data: k1
			        },{
			        	lineWidth: 1,
			        	name: 'K2',
			        	data: k2
			        },{
			        	lineWidth: 1,
			        	name: 'K3',
			        	data: k3
			        },{
			        	lineWidth: 1,
			        	name: 'K4',
			        	data: k4
			        }],
			        navigation: {
			            buttonOptions: {
			                enabled: false
			            }
			        }
			    });
    		}
    	});
    },
    
    doCheck: function(type, range) {
    	var me,
    		win;
    	
    	me = this;
    	me.type = type;
    	me.range = range;
    	
    },
    
    doSearch: function() {

    },
    
    showAvlbGrid: function() {
    	var me,
    		store,
    		dailyGrid;
    	
    	me = this;
    	store = this.getAvlbMinutelyStoreStore();
    	dailyGrid = this.getDailyGrid();
    	
    	store.getProxy().setExtraParam('type', me.type);
    	store.getProxy().setExtraParam('range', me.range);
    	
    	store.load();
    	
    	dailyGrid.expand(true);
    }
});

