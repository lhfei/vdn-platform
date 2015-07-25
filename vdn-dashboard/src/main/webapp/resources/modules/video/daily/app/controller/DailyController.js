var j$ = jQuery;

Ext.define('ifeng.controller.DailyController', {
    extend: 'Ext.app.Controller',

    models: [
        'AvlbDaily',
        'DataRangeModel',
        'AuditType'
    ],
    stores: [
        'AvlbDailyStore',
        'DataRangeStore',
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
    
    doCheck: function(type, range) {
    	var me,
    		win;
    	
    	me = this;
    	
    	if(!win) {
    		win = Ext.create('ifeng.view.DailyWin');
    	}
    	
      	j$.ajax({
    		url: '../getAvlbMinutely.do?type='+type+'&range='+range,
    		method: 'get',
    		success: function(response) {
    			var tr = [],
					avlb = [];
			
				j$.map(response.data, function(val, i){
					tr[i] = val.tr
					avlb[i] = new Number(val.avlb) * 100;
				});
				
				j$('#chartContainer').highcharts({
			    	title: {
		                text: 'Daily Report'
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
			        	name: 'Available',
			        	data: avlb
			        }]
			        
			    });
    		}
    		
    	});
    	
    	
    	win.show();
    },
    
    doSearch: function() {
    	j$.ajax({
    		url: '../getAvlbDaily.do',
    		method: 'get',
    		success: function(response) {
    			var ct = [],
					avlb = [];
			
				j$.map(response.data, function(val, i){
					ct[i] = val.ct
					avlb[i] = val.avlb;
				});
				
				j$('#chartContainer').highcharts({
			    	title: {
		                text: 'Daily Report'
		            },
			        chart: {
			            type: 'line'
			        },

			        xAxis: {
			            categories: ct
			        },
			        series: [{
			        	name: 'Total',
			        	color: '#00FF00',
			        	data: avlb
			        }]
			        
			    });
    		}
    		
    	});
    },
    
});

