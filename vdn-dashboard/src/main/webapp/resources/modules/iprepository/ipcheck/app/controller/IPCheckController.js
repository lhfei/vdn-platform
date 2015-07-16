/**
 * 
 */
Ext.require([
    'Ext.form.field.File',
    'Ext.form.field.Number',
    'Ext.form.Panel',
    'Ext.window.MessageBox'
]);

Ext.define('ifeng.controller.IPCheckController', {
	extend: 'Ext.app.Controller',
	stores: ['AliIPStore'],
	models: ['AliIPModel'],
	views: ['AliIPGrid', 'SearchForm'],
	refs: [
        {ref: 'aliIPGrid', selector: 'aliIPGrid'},
        {ref: 'aliIPStore', selector: 'aliIPStore'},
        {ref: 'pagingtoolbar', selector: 'pagingtoolbar'},
        {ref: 'searchForm', selector: 'searchForm'}
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
			
			'viewport > aliIPGrid button[action=doHistory]': {
				click: this.beforeHistory
			},
			
			'aliIPGrid actioncolumn': {
				click: this.completeTask
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
	
	beforeHistory: function(o, o1) {
		
	},
	
	doHistory: function() {
	},
	
	afterLoad: function(store, records, successful, eOpts){

	},
	
	doCheck: function() {
		var ips,
			store,
			searchForm,
			searchModel;
		searchForm = this.getSearchForm();
		searchModel = searchForm.getValues();
		
		ips = searchModel.ips;
		ips = Ext.String.trim(ips);
		
		if(ips && ips.length > 0){
			store = this.getAliIPStoreStore();
			store.getProxy().setExtraParam('ips', searchModel.ips);
			store.load();
			
			searchForm.collapse(Ext.Component.DIRECTION_TOP, true);
		}else{
			Ext.MessageBox.show({
		           title: 'Systen Info',
		           msg: '请输入您要查询的IP !',
		           buttons: Ext.MessageBox.OK,
		           icon: 'warning'
		       });
		}
	}

});