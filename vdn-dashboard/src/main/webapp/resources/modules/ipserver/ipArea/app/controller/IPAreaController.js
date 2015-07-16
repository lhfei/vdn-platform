/**
 * 
 */
Ext.require([
    'Ext.form.field.File',
    'Ext.form.field.Number',
    'Ext.form.Panel',
    'Ext.window.MessageBox'
]);

Ext.define('ifeng.controller.IPAreaController', {
	extend: 'Ext.app.Controller',
	stores: ['IPAreaStore'],
	models: ['IPAreaModel'],
	views: ['IPAreaGrid', 'SearchForm'],
	refs: [
        {ref: 'ipAreaGrid', selector: 'ipAreaGrid'},
        {ref: 'ipAreaStore', selector: 'ipAreaStore'},
        {ref: 'pagingtoolbar', selector: 'pagingtoolbar'},
        {ref: 'searchForm', selector: 'searchForm'}
	],
	
	depth: 1,
	historyURL: [],
	
	init: function() {
		var me = this;
	
		// attach 'beforeload' event into HWStore 
		Ext.getStore('IPAreaStore').addListener('beforeload', this.beforeLoad, this);
		
		this.control({
			'viewport > ipAreaGrid': {
				cellclick: this.editTask
			},
			
			'viewport > ipAreaGrid button[action=doImport]': {
				click: this.doImport
			},
			
			'viewport > ipAreaGrid button[action=doProofread]': {
				click: this.doProofread
			},
			
			'viewport > searchForm button[action=doSearch]': {
				click: this.doSearch
			},
			
			'viewport > searchForm button[action=doReset]': {
				click: function() {me.getSearchForm().getForm().reset()}
			}
			
		});
	},
	
	editTask: function(grid, td, cellIndex, record, tr, rowIndex, e, eOpts) {
		
	},
	
	beforeLoad: function(store, operation, eOpts){
		var searchForm,
			searchModel;
		searchForm = this.getSearchForm();
		searchModel = searchForm.getValues();
		
		//searchForm.collapse(Ext.Component.DIRECTION_TOP, true);
	},
	
	doSearch: function() {
		var searchForm,
			searchModel;
		searchForm = this.getSearchForm();
		searchModel = searchForm.getValues();
		
		searchForm.collapse(Ext.Component.DIRECTION_TOP, true);
	},
	
	doProofread: function() {
		var me,
			win,
			store,
			baseGrid,
			ifengGrid,
			aliGrid;
		
		me = this;
		win = me.getMergeWin();
		store = this.getIPAreaStoreStore();
		
		baseGrid = me.getIPAreaGrid();
		ifengGrid = win.down('gridpanel#ifengGrid');
		aliGrid = win.down('gridpanel#aliGrid');
		win.show();
	},
	
	doImport: function doImport() {
		Ext.Ajax.request({
			url: 'importIPFromIPAreaFile.do',
			waitMsg: 'Loading ...',
			method: 'get',
			success: function (response, opts){
				var result = Ext.decode(response.responseText); 
				if(result.success){
					Ext.MessageBox.alert({
						title: 'System Message',
						msg: result.message
					});
					
					downloadWin.hide();
				}
			},
			failure: function(response, opts){
				var result = Ext.decode(response.responseText); 
				Ext.MessageBox.alert({
					title: 'System Message',
					msg: result.message
				});
				
				downloadWin.hide();
			}
		});
	}

});