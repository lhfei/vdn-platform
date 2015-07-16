/**
 * 
 */
Ext.require([
    'Ext.form.field.File',
    'Ext.form.field.Number',
    'Ext.form.Panel',
    'Ext.window.MessageBox'
]);

Ext.define('ifeng.controller.ReportController', {
	extend: 'Ext.app.Controller',
	stores: ['ReportStore'],
	models: ['ReportModel'],
	views: ['ReportGrid', 'SearchForm'],
	refs: [
        {ref: 'reportGrid', selector: 'reportGrid'},
        {ref: 'reportStore', selector: 'reportStore'},
        {ref: 'pagingtoolbar', selector: 'pagingtoolbar'},
        {ref: 'searchForm', selector: 'searchForm'}
	],
	
	depth: 1,
	historyURL: [],
	
	init: function() {
		var me = this;
	
		// attach 'beforeload' event into HWStore 
		Ext.getStore('ReportStore').addListener('load', this.afterLoad, this);
		
		this.control({
			'viewport > reportGrid': {
				cellclick: this.editTask
			},
			
			'viewport > reportGrid button[action=doExport]': {
				click: this.doExport
			},
			
			'viewport > reportGrid button[action=doProofread]': {
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
	
	doExport: function(o, o1) {
		
	},
	
	afterLoad: function(store, records, successful, eOpts){

	},
	
	doSearch: function() {
		var store,
			searchForm,
			searchModel;
		searchForm = this.getSearchForm();
		searchModel = searchForm.getValues();
		store = this.getReportStoreStore();
		
		store.getProxy().setExtraParam('ips', searchModel.ips);
		store.load();
		
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
		store = this.getReportStoreStore();
		
		baseGrid = me.getReportGrid();
		ifengGrid = win.down('gridpanel#ifengGrid');
		aliGrid = win.down('gridpanel#aliGrid');
		
		
		
		win.show();
	}

});