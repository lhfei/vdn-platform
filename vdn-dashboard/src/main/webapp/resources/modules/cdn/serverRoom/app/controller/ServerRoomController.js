/**
 * 
 */
Ext.require([
    'Ext.form.field.File',
    'Ext.form.field.Number',
    'Ext.form.Panel',
    'Ext.window.MessageBox'
]);

Ext.define('ifeng.controller.ServerRoomController', {
	extend: 'Ext.app.Controller',
	
	stores: ['ServerRoomStore'],
	models: ['ServerModel', 'ServerRoomModel'],
	views: ['ServerRoomPanel','SearchForm', 'ServerRoomWin'],
	refs: [
        {ref: 'searchForm', selector: 'searchForm'},
        {ref: 'serverRoom', selector: 'serverRoom'},
        {ref: 'serverRoomWin', selector: 'serverRoomWin'}
        
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
			
			'viewport > serverRoom button[action=doCreate]': {
				click: this.createServerRoom
			},
			
			'viewport > serverRoom button[action=doRemove]': {
				click: this.removeServerRoom
			},
			
			'#doSaveRoomBtn': {
				click: this.doSaveRoom
			},
			
			'#doResetRoomBtn': {
				click: this.doResetRoom
			}
		});
	},
	
	doBefore: function(store, operation, eOpts) {
		
	},
	
	doSearch: function() {
	},
	
	createServerRoom: function (){
		var win = this.win;
		if(!win){
			win = Ext.create('ifeng.view.ServerRoomWin');
		}
		win.show();
	},
	
	removeServerRoom: function() {
		var me = this;
		Ext.MessageBox.confirm('Confirm', '您确认要删除该吗?', function(btn){
			if(btn === 'yes'){
				var url,
					store,
					grid,
					records;
				
				store = me.getServerRoomStoreStore();
				url = store.getProxy().api.destroy;
				grid = me.getServerRoom();
				records = grid.getSelectionModel().getSelection();
				
				var items = [];
				
				for(var i=0, length = records.length; i<length; i++){
					items[i] = records[i].data.id;
					//store.remove(item);
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
				
				/*store.remove(items);
				
				store.sync({
					scope: this,
					params: items,
					success: function() {
						Ext.MessageBox.alert('操作提示', '删除成功!');
						store.loadPage(1);
					},
					failure : function() {
						Ext.MessageBox.alert('操作提示', '删除失败!');
					}
				});*/
			}
		});
	},
	
	doSaveRoom: function() {
		var win = this.getServerRoomWin(),
			store = this.getServerRoomStoreStore();
			form = win.down('form'),
	        record = form.getRecord(),
	        values = form.getValues();
		
		record = Ext.create('ifeng.model.ServerRoomModel');
		record.set(values);
		
		store.add(record);
		
		win.close();
		
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
	
	doResetRoom: function() {
		var win = this.getServerRoomWin();
		
		win.close();
	}
    
    
});