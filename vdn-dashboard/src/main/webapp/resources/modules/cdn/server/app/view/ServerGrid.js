/**
 * 
 */
Ext.define('ifeng.view.ServerGrid', {
	extend: 'Ext.grid.Panel',
	alias: 'widget.serverGrid',
	frame: false,
	autoWidth: true,
	autoHeight: true,
	
	fixed: true,
	border: 1,
	style: {
	    //borderColor: 'red',
	    borderStyle: 'solid'
	},
	
	title: 'IP 信息列表',
	store: 'ServerStore',
	
	selType: 'checkboxmodel',
    columns: [
        {header: '序号', xtype: 'rownumberer', width: 40, sortable: false, locked: true }, 
        {header: 'ID',  dataIndex: 'id',  flex: 1, align: 'center', hidden: true},
        {header: '外网IP',  dataIndex: 'ip',  flex: 1, align: 'center'},
        {header: '内网IP',  dataIndex: 'inner_ip',  flex: 1, align: 'center', hidden: false},
        {header: '所属机房',  dataIndex: 'room_name',  flex: 1, align: 'center', hidden: false},
        {header: '服务器状态',  dataIndex: 'server_status',  flex: 1, align: 'center', hidden: true},
        {header: '创建时间', dataIndex: 'create_time', flex: 2, align: 'center'},
        {header: '修改时间', dataIndex: 'latest_time', flex: 1, align: 'center', hidden: true},
        {header: '数据状态', dataIndex: 'data_status', flex: 1, align: 'center', hidden: true}

    ],
    
    initComponent: function() {
    	var me = this;
    	me.selModel = Ext.create('Ext.selection.CheckboxModel', {
	        listeners: {
	            selectionchange: function(sm, selections) {
	                me.down('#removeBtn').setDisabled(selections.length === 0);
	            }
	        }
	    });
    	 
		this.dockedItems = [{
            xtype: 'pagingtoolbar',
            dock:'bottom',
            store: 'ServerStore',
            displayInfo: true,
            displayMsg: 'Displaying records {0} - {1} of {2}',
            emptyMsg: "No records to display"
        }];
		
		this.tbar = [{
        	itemId: 'createBtn',
        	xtype: 'button',
        	text: '创建服务器',
        	action: 'doCreate',
            iconCls: 'icon-add'
        },'-', {
        	itemId: 'removeBtn',
        	xtype: 'button',
        	text: '删除服务器',
        	disabled: true,
        	action: 'doRemove',
            iconCls: 'icon-delete'
        }]
		
		this.callParent(arguments);
	}
    
});