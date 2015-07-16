/**
 * 
 */
Ext.require([
    'Ext.form.field.File',
    'Ext.form.field.Number',
    'Ext.form.Panel',
    'Ext.ux.DataView.Animated',
    'Ext.window.MessageBox'
]);

var j$ = jQuery;
Ext.define('ifeng.controller.MonitorController', {
	extend: 'Ext.app.Controller',
	
	stores: ['IPServerStore', 'ServerStore', 'ServerRoomStore'],
	models: ['IPServerModel', 'ServerModel', 'ServerRoomModel'],
	views: ['MainPanel','SearchForm', 'ServerBrowser', 'InfoPanel', 'ChartPanel', 'ChartWin', 'ChartSearchForm'], //
	refs: [
	    {ref: 'mainPanel', selector: 'mainPanel'},
        {ref: 'searchForm', selector: 'searchForm'},
        {ref: 'serverBrowser', selector: 'serverBrowser'},
        {ref: 'infoPanel', selector: 'infoPanel'},
        {ref: 'chartPanel', selector: 'chartPanel'},
        {ref: 'chartWin', selector: 'chartWin'},
        {ref: 'chartSearchForm', selector: 'chartSearchForm'}        
        
	],
	
	init: function() {
		var me = this;
		// attach 'beforeload' event into HWStore 
		Ext.getStore('IPServerStore').addListener('beforeload', this.doBefore, this);
		
		this.control({
			'mainPanel > searchForm button[action=doSearch]': {
				click: this.doSearch
			},
			
			'mainPanel > searchForm button[action=doReset]': {
				click: function() {me.getSearchForm().getForm().reset()}
			},
			
			'chartWin > chartSearchForm button[action=doFilter]': {
				click: this.fireServerSelected
			},
			
			'#serverBrowser': {
				scope: this,
				selectionchange: this.onServerSelect,
				itemdblclick: this.fireServerSelected
			},
			
			'#hideSearchBtn': {
				click: this.hidenSearch
			},
			'#showSearchBtn': {
				click: this.showSearch
			}
			
		});
	},
	
	doBefore: function(store, operation, eOpts) {
		
	},
	
	doSearch: function() {
    	var me = this;
    	var serverBrowser,
    		searchForm,
	    	searchModel,	//search form items.
	    	store;
    	
    	serverBrowser = me.getServerBrowser();
    	searchForm = me.getSearchForm();
    	searchModel = searchForm.getValues();
    	
    	store = me.getServerStoreStore();
    	store.getProxy().setExtraParam('ip', searchModel.ip);
		store.getProxy().setExtraParam('room_id', searchModel.room_id);
		
		store.load({
			callback: function(records, operation, success) {
				if(success){}
				
				serverBrowser.refresh();
			}
		});
	},
	
	 /**
     * Called whenever the user clicks on an item in the DataView. This tells the info panel in the east region to
     * display the details of the server that was clicked on
     */
	onServerSelect: function(dataview, selections) {
		var me = this;
        var selected = selections[0];
        var mainPanel,
        	infoPanel,
        	chartPanel;
        
        mainPanel = me.getMainPanel();
        infoPanel = me.getInfoPanel();
        chartPanel = me.getChartPanel();
        
        if (selected) {
        	mainPanel.expand(true);
        	infoPanel.updateLayout();
        	
            me.getInfoPanel().loadRecord(selected);
        }
    },
    
    /**
     * Fires the 'selected' event, informing other components that a server has been selected
     */
    fireServerSelected: function() {
    	var me = this;
    	
    	var searchForm,
	    	searchModel,	//search form items.
	    	mainPanel,
	    	infoPanel,
	    	chartPanel,
	    	serverIp,
	    	params,
	    	selectedServer;
    	
    	
    	searchForm = me.getChartSearchForm();
    	
    	if(searchForm){
    		params = new Object();
    		searchModel = searchForm.getValues();
    		params.startdt = searchModel.startdt;
    		params.enddt = searchModel.enddt;
    	}else {
    		params = null;
    	}
    	
    	selectedServer = me.getServerBrowser().selModel.getSelection()[0];
    	serverIp = selectedServer.data.ip;
    	
        mainPanel = me.getMainPanel();
        infoPanel = me.getInfoPanel();
        chartPanel = me.getChartPanel();
		
		j$.ajax({
			url: '../../ipserver/' +serverIp+'/read.do',
			data: params,
			success: function(response) {
				
				var ts = [],
					total = [],
					request = [],
					live = [];
				
				j$.map(response.data, function(val, i){
					ts[i] = val.create_time
					total[i] = val.total;
					request[i] = val.request_total;
					live[i] = val.live_total;
				})
				
			    j$('#container').highcharts({
			    	title: {
		                text: serverIp
		            },
			        chart: {
			            type: 'line'
			        },

			        xAxis: {
			            categories: ts
			        },

			        series: [{
			        	name: 'Total',
			        	color: '#00FF00',
			        	data: total
			        },{
			        	name: '点播',
			        	color: '#FF00CC',
			        	data: request
			        }, {
			        	name: '直播',
			        	color: '#AA00FF',
			        	data: live
			        }]
			        
			    });
				
				var win = me.getChartWin();
				
				if(!win){
					win = Ext.create('ifeng.view.ChartWin');
				}
				if(win.isHidden()){
					win.show();
				}
			}
		});
    },
    
    hidenSearch: function() {
    	var searchForm = this.getSearchForm();
    	searchForm.collapse(Ext.Component.DIRECTION_TOP, true);
    },
    
    showSearch: function() {
    	var searchForm = this.getSearchForm();
    	searchForm.expand(true);
    }
    
    
    
});