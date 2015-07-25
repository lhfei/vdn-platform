/**
 * 
 */
Ext.define('ifeng.view.IPAreaGrid', {
	extend: 'Ext.grid.Panel',
	alias: 'widget.ipAreaGrid',
	
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
	store: 'IPAreaStore',
	
	selType: 'checkboxmodel',
    columns: [
        {header: '序号', xtype: 'rownumberer', width: 40, sortable: false, locked: true }, 
        {header: 'ID',  dataIndex: 'id',  flex: 1, align: 'center', hidden: false},
        {header: 'MD5 码',  dataIndex: 'digest',  flex: 2, align: 'center'},
        {header: '生成时间', dataIndex: 'create_time', flex: 2, align: 'center'},
        {header: '修改时间', dataIndex: 'latest_time', flex: 1, align: 'center', hidden: true},
        {header: '数据状态', dataIndex: 'data_status', flex: 1, align: 'center', hidden: true}

    ],
    
    initComponent: function() {
    	var me = this;
    	me.selModel = Ext.create('Ext.selection.CheckboxModel', {
	        listeners: {
	            selectionchange: function(sm, selections) {
	                me.down('#proofreadButton').setDisabled(selections.length === 0);
	            }
	        }
	    });
    	 
		this.dockedItems = [{
            xtype: 'pagingtoolbar',
            dock:'bottom',
            store: 'IPAreaStore',
            displayInfo: true,
            displayMsg: 'Displaying records {0} - {1} of {2}',
            emptyMsg: "No records to display"
        }];
		
		this.tbar = [/*{
        	itemId: 'doImportButton',
        	xtype: 'button',
        	text: '导入IP',
        	tpl: '从IPServer IPArea.txt 文件导入IP.',
        	action: 'doImport',
            iconCls: 'icon-proofread'
        },*/'-',{
        	itemId: 'doCheckBtn',
        	xtype: 'button',
        	text: '检测',
        	disabled: false,
        	action: 'doCheck',
        	tpl: '检测最新IPArea文件',
            iconCls: 'icon-diff'
        }, {
        	itemId: 'proofreadButton',
        	xtype: 'button',
        	text: '校对',
        	disabled: true,
        	action: 'doProofread',
        	tpl: '',
            iconCls: 'icon-proofread'
        }]
		
		this.callParent(arguments);
	}
    
});