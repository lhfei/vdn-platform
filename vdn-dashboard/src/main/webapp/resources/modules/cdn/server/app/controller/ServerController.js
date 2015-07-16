/**
 * 
 */
Ext.require([
    'Ext.form.field.File',
    'Ext.form.field.Number',
    'Ext.form.Panel',
    'Ext.window.MessageBox'
]);

Ext.define('ifeng.controller.ServerController', {
	extend: 'Ext.app.Controller',
	
	stores: ['ServerRoomStore', 'ServerStore'],
	models: ['ServerModel', 'ServerRoomModel'],
	views: ['ServerRoomPanel','SearchForm', 'ServerRoomWin', 'ServerGrid', 'ServerWin'],
	refs: [
        {ref: 'searchForm', selector: 'searchForm'},
        {ref: 'serverRoom', selector: 'serverRoom'},
        {ref: 'serverRoomWin', selector: 'serverRoomWin'},
        {ref: 'serverGrid', selector: 'serverGrid'},
        {ref: 'serverWin', selector: 'serverWin'}
        
	],
	
	init: function() {
		var me = this;
		// attach 'beforeload' event into HWStore 
		Ext.getStore('ServerRoomStore').addListener('beforeload', this.doBefore, this);
		this.control({
			'viewport > searchForm button[action=doSearch]': {
				click: this.doSearch
			},
			
			'viewport > searchForm button[action=doReset]': {
				click: function() {me.getSearchForm().getForm().reset()}
			},
			
			'viewport > serverGrid button[action=doCreate]': {
				click: this.createServer
			},
			
			'viewport > serverGrid button[action=doRemove]': {
				click: this.removeServer
			},
			
			'#doSaveServerBtn': {
				click: this.doSaveServer
			},
			
			'#doResetServerBtn': {
				click: this.doResetServer
			}
		});
	},
	
	doBefore: function(store, operation, eOpts) {
		
	},
	
	doSearch: function() {
	},
	
	createServer: function (){
		var win = this.win;
		if(!win){
			win = Ext.create('ifeng.view.ServerWin');
		}
		win.show();
	},
	
	removeServer: function() {
		var me = this;
		Ext.MessageBox.confirm('Confirm', '您确认要删除该吗?', function(btn){
			if(btn === 'yes'){
				var url,
					store,
					grid,
					records;
				
				store = me.getServerStoreStore();
				url = store.getProxy().api.destroy;
				grid = me.getServerGrid();
				records = grid.getSelectionModel().getSelection();
				
				var items = [];
				for(var i=0, length = records.length; i<length; i++){
					items[i] = records[i].data.id;
				}
				
				Ext.Ajax.request({
					url: url,
					method: 'POST',
					jsonData: Ext.encode(items),
					success: function(response){
				        Ext.MessageBox.alert('操作提示', '删除成功!');
				        store.loadPage(1);
				    },
				    failure: function(response){
				    	Ext.MessageBox.alert('操作提示', '删除失败!');
				    }
				});
				
				/*store.sync({
					scope: this,
					success: function() {
						Ext.MessageBox.alert('操作提示', '删除成功!');
						win.close();
						store.loadPage(1);
					},
					failure : function() {
						Ext.MessageBox.alert('操作提示', '删除失败!');
						win.close();
					}
				});*/
			}
		});
	},
	
	doSaveServer: function() {
		var win = this.getServerWin(),
			store = this.getServerStoreStore();
			form = win.down('form'),
	        record = form.getRecord(),
	        values = form.getValues();
		
		record = Ext.create('ifeng.model.ServerModel');
		record.set(values);
		
		store.add(record);
		
		store.sync({
			scope: this,
			success: function() {
				Ext.MessageBox.alert('操作提示', '创建成功!');
				win.close();
				store.loadPage(1);
			},
			failure : function() {
				Ext.MessageBox.alert('操作提示', '创建失败!');
				win.close();
			}
		});
	},
	
	doResetServer: function() {
		var win = this.getServerWin();
		
		win.close();
	}
    
    
});