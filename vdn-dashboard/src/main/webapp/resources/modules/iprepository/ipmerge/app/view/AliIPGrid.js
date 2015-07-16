/**
 * 
 */
Ext.define('ifeng.view.AliIPGrid', {
	extend: 'Ext.grid.Panel',
	alias: 'widget.aliIPGrid',
	
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
	store: 'AliIPStore',
	
	selType: 'checkboxmodel',
    columns: [
        {header: '序号', xtype: 'rownumberer', width: 40, sortable: false, locked: true }, 
        {header: 'ID',  dataIndex: 'id',  flex: 2, align: 'center', hidden: false},
        {header: 'IP',  dataIndex: 'ip',  flex: 2, align: 'center'},
        {header: '国家/地区', dataIndex: 'country', flex: 1, align: 'center'},
        {header: '省份', dataIndex: 'region', flex: 1, align: 'center'},
        {header: '城市', dataIndex: 'city', flex: 2, align: 'center'},
        {header: '区县', dataIndex: 'county', flex: 1, align: 'center'},
        {header: '运营商', dataIndex: 'isp', flex: 1, align: 'center'},
        
        {header: 'Country', dataIndex: 'country_id', flex: 1, align: 'center', hidden: true},
        {header: 'Region', dataIndex: 'region_id', flex: 1, align: 'center', hidden: true},
        {header: 'City', dataIndex: 'city_id', flex: 1, align: 'center', hidden: true},
        {header: 'County', dataIndex: 'county_id', flex: 1, align: 'center', hidden: true},
        {header: 'ISP', dataIndex: 'isp_id', flex: 1, align: 'center', hidden: true}

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
            store: 'AliIPStore',
            displayInfo: true,
            displayMsg: 'Displaying records {0} - {1} of {2}',
            emptyMsg: "No records to display"
        }];
		
		this.tbar = ['-',{
			itemId: 'removeButton',
            xtype:'button',
            text: '导出',
            //id: '0_',
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
        }]
		
		this.callParent(arguments);
	}
    
});