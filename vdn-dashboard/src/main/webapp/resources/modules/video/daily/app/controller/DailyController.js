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
				
				j$('#chartContainer').highcharts({
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
    	
    	win.show();
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

