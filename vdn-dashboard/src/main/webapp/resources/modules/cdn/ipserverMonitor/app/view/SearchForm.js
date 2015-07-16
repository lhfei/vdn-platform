/**
 * 
 */

    
Ext.define('ifeng.view.SearchForm', {
	extend: 'Ext.form.Panel',
	alias: 'widget.searchForm',
	requires: ['Ext.ux.DataTip', 'Ext.ux.DateTimeField'],
	header: false,
	
	frame: true,
    collapsible: true,
    
    defaults: {
    	anchor: '100%'
    },
    
    items: [{
    	xtype: 'fieldset',
    	title: '机房',
        margin: '5 5 5 5',
        defaults: {
            labelAlign: 'right',
            anchor: '100%'
        },
    	items: [{
    		xtype: 'textfield',
    		fieldLabel: 'IP',
    		emptyText: '服务器IP地址',
    		name: 'ip'
    	},{
        	xtype: 'combobox',
            anchor: '100%',
            fieldLabel: '所属机房',
            name: 'room_id',
            selectOnFocus: true,
            displayField: 'room_name',
            store: 'ServerRoomStore',
            valueField: 'id'
        }]
    }],
   
    
    buttons: [{
        text: '查询',
        iconCls: 'icon-search',
        action: 'doSearch'
    },{
        text: '重置',
        iconCls: 'icon-cancel',
        action: 'doReset'
    }]
})