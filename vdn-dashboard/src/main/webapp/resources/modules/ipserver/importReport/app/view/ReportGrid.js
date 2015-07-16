/**
 * 
 */
Ext.define('ifeng.view.ReportGrid', {
	extend: 'Ext.grid.Panel',
	alias: 'widget.reportGrid',
	
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
	store: 'ReportStore',
	
	selType: 'checkboxmodel',
    columns: [
        {header: '序号', xtype: 'rownumberer', width: 40, sortable: false, locked: true }, 
        {header: 'ID',  dataIndex: 'id',  flex: 1, align: 'center', hidden: false},
        {header: '总数',  dataIndex: 'total',  flex: 2, align: 'center'},
        {header: '有效', dataIndex: 'valid', flex: 1, align: 'center'},
        {header: '无效', dataIndex: 'skip', flex: 1, align: 'center'},
        {header: '导入时间', dataIndex: 'create_time', flex: 2, align: 'center'},
        
        {header: '修改时间', dataIndex: 'latest_time', flex: 1, align: 'center', hidden: true},
        {header: '数据状态', dataIndex: 'data_status', flex: 1, align: 'center', hidden: true}

    ],
    
    initComponent: function() {
    	var me = this;
    	me.selModel = Ext.create('Ext.selection.CheckboxModel', {
	        listeners: {
	            selectionchange: function(sm, selections) {
	                me.down('#removeButton').setDisabled(selections.length === 0);
	                me.down('#proofreadButton').setDisabled(selections.length === 0);
	            }
	        }
	    });
    	 
		this.dockedItems = [{
            xtype: 'pagingtoolbar',
            dock:'bottom',
            store: 'ReportStore',
            displayInfo: true,
            displayMsg: 'Displaying records {0} - {1} of {2}',
            emptyMsg: "No records to display"
        }];
		
		/*this.tbar = ['-',{
			itemId: 'removeButton',
            xtype:'button',
            text: '导出',
            disabled: true,
            action: 'doExport',
            iconCls: 'icon-excel'
        }, '-', {
        	itemId: 'proofreadButton',
        	xtype: 'button',
        	text: '校对',
        	disabled: true,
        	action: 'doProofread',
            iconCls: 'icon-proofread'
        }]*/
		
		this.callParent(arguments);
	}
    
});