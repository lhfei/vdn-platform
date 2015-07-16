/**
 * 
 */
Ext.require([
    'Ext.form.field.File',
    'Ext.form.field.Number',
    'Ext.form.Panel',
    'Ext.window.MessageBox'
]);

Ext.define('hwork.controller.FileStatusController', {
	extend: 'Ext.app.Controller',
	stores: ['FileStatusStore'],
	models: ['FileStatus'],
	views: ['FileStatusGrid'],
	refs: [
        {ref: 'fileStatusGrid', selector: 'fileStatusGrid'},
        {ref: 'fileStatusStore', selector: 'fileStatusStore'},
        {ref: 'pagingtoolbar', selector: 'pagingtoolbar'}
	],
	
	depth: 1,
	historyURL: [],
	
	init: function() {
		var me = this;
		
		// attach 'beforeload' event into HWStore 
		Ext.getStore('FileStatusStore').addListener('load', this.afterLoad, this);
		
		this.control({
			'viewport > fileStatusGrid': {
				cellclick: this.editTask
			},
			
			'viewport > fileStatusGrid button[action=doHistory]': {
				click: this.beforeHistory
			},
			
			'fileStatusGrid actioncolumn': {
				click: this.completeTask
			},
			
		});
	},
	
	editTask: function(grid, td, cellIndex, record, tr, rowIndex, e, eOpts) {
		var me = this;
		//Ext.MessageBox.show(record.name, record.data.name);
		if(cellIndex == 5){
			var store,
				grid,
				ops,
				url;
			grid = this.getFileStatusGrid();
			store = this.getFileStatusStoreStore();
			ops = '?ops=' +record.raw.pathSuffix;
			
			var toolbar = grid.getDockedItems('toolbar[dock="top"]')[0];
			
			toolbar.add({
				xtype:'button',
	        	id: me.depth +'_',
	        	iconCls: 'icon-folder-open',
	        	action: 'doHistory',
	            text: record.raw.pathSuffix
	        });
			toolbar.add('-');
			toolbar.doLayout();
			
			me.depth ++;
			me.historyURL.push(record.raw.pathSuffix);
			me.doHistory();
			
		}
	},
	
	beforeHistory: function(o, o1) {
		var depth = this.depth;
		var targetId = o.id;
		var targetDepth = targetId.split('_')[0];
		
		targetDepth = parseInt(targetDepth);
		
		var toolbar = this.getFileStatusGrid().getDockedItems('toolbar[dock="top"]')[0];
		
		var items = toolbar.items;
		var startIndex = (targetDepth + 1) * 2 + 1;
		
		if(depth > targetDepth){
			while(startIndex < items.length){
				try{
					toolbar.remove(items.get(items.length - 1));
					toolbar.doLayout();
				}catch(e){toolbar.doLayout();}
			}
			
			this.historyURL.splice(targetDepth, this.depth);
			this.depth = targetDepth + 1;
			this.doHistory();
		}
		
	},
	
	doHistory: function() {
		var store,
			ops = '?ops=',
			url;
		store = this.getFileStatusStoreStore();
		url = store.getProxy().api.read;
		
		ops += this.historyURL.join('/');
		url += ops;
		
		store.resumeEvents();
		
		store.load({url: url})
	},
	
	afterLoad: function(store, records, successful, eOpts){
		var	grid,
			data, 
			pagingToolbar;
		
		grid = this.getFileStatusGrid();
		data = records[0].raw.FileStatuses.FileStatus
		pagingToolbar = this.getPagingtoolbar();
		
		store.loadData(data)
		pagingToolbar.displayMsg = 'Displaying records: ' +data.length; 
		
		store.suspendEvents();
	},
	
	doSearch: function() {
		this.getFileStatusStoreStore().loadPage(1);
	}
	

});