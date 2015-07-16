/**
 * 
 */
Ext.require([
    'Ext.form.field.File',
    'Ext.form.field.Number',
    'Ext.form.Panel',
    'Ext.window.MessageBox'
]);

Ext.define('ifeng.controller.IPMergeController', {
	extend: 'Ext.app.Controller',
	stores: ['AliIPStore'],
	models: ['AliIPModel'],
	views: ['AliIPGrid', 'SearchForm', 'MergeWin'],
	refs: [
        {ref: 'aliIPGrid', selector: 'aliIPGrid'},
        {ref: 'aliIPStore', selector: 'aliIPStore'},
        {ref: 'pagingtoolbar', selector: 'pagingtoolbar'},
        {ref: 'searchForm', selector: 'searchForm'},
        {ref: 'mergeWin', selector: 'mergeWin'}
	],
	
	depth: 1,
	historyURL: [],
	
	init: function() {
		var me = this;
	
		// attach 'beforeload' event into HWStore 
		Ext.getStore('AliIPStore').addListener('load', this.afterLoad, this);
		
		this.control({
			'viewport > aliIPGrid': {
				cellclick: this.editTask
			},
			
			'viewport > aliIPGrid button[action=doExport]': {
				click: this.doExport
			},
			
			'viewport > aliIPGrid button[action=doProofread]': {
				click: this.doProofread
			},
			
			'viewport > searchForm button[action=doCheck]': {
				click: this.doCheck
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
	
	doCheck: function() {
		var store,
			searchForm,
			searchModel;
		searchForm = this.getSearchForm();
		searchModel = searchForm.getValues();
		store = this.getAliIPStoreStore();
		
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
		store = this.getAliIPStoreStore();
		
		baseGrid = me.getAliIPGrid();
		ifengGrid = win.down('gridpanel#ifengGrid');
		aliGrid = win.down('gridpanel#aliGrid');
		
		
		
		win.show();
	}

});