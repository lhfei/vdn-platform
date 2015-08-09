Ext.define('ifeng.view.DailyGrid', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.dailyGrid',
    itemId: 'dailyGridCmp',
    requires: [
        'Ext.grid.column.Column',
        'Ext.grid.plugin.BufferedRenderer',
        'Ext.ux.grid.FiltersFeature'
    ],

    title: '可用性统计数据',
    header: true,
    store: 'AvlbMinutelyGridStore',
    collapsible: true,
    
    loadMask: true,
    bodyBorder: true,
    emptyText: 'No Matching Records',

    height: 500,
    initComponent: function() {
        var me = this;
        
        Ext.QuickTips.init();
        
        var filters = {
	        ftype: 'filters',
	        // encode and local configuration options defined previously for easier reuse
	        encode: true, // json encode the filter query
	        local: false,   // defaults to false (remote filtering)
	
	        // Filters are most naturally placed in the column definition, but can also be
	        // added here.
	        filters: [{
	            type: 'numeric',
	            dataIndex: 'ka'
	        }]
	    };

        Ext.applyIf(me, {
            tbar: [
                '-',
                
                {
                	xtype: 'datefield',
                	fieldLabel: '查询日期'
                },
                {
                	xtype: 'datefield'
                },
                
                '-',
                {
                    text: '查询',
                    action: 'filteData',
                    iconCls: 'icon-search'
                },
                
                '->',
                
                {
                	text: '导出',
                    action: 'exportData',
                    iconCls: 'icon-excel'
                },
                
                '-'
            ],
            
            features: [filters],
            
            columns: [
				{
				    xtype: 'rownumberer',
				    width: 50,
				    align: 'center',
				    locked: true,
				    text: '序号'
				},
				{
				    xtype: 'gridcolumn',
				    align: 'center',
				    dataIndex: 'ct',
				    text: '时间',
				    flex: 1
				},{
				    xtype: 'gridcolumn',
				    align: 'center',
				    dataIndex: 'tr',
				    text: '时段',
				    flex: 1
				},
				{
				    xtype: 'numbercolumn',
				    align: 'center',
				    dataIndex: 'a',
				    text: 'VDN 请求样本数',
				    format:'0',
				    flex: 1
				  },
				{
				    xtype: 'numbercolumn',
				    align: 'center',
				    dataIndex: 'ka',
				    text: 'VDN可用性',
				    format:'0.0000',
				    filter: {type: 'numeric'},
				    flex: 1
				  },
				{
				    xtype: 'numbercolumn',
				    dataIndex: 'kb',
				    text: '流畅度',
				    format:'0.0000',
				    filter: {type: 'numeric'},
				    flex: 1
				},
				{
				    xtype: 'numbercolumn',
				    align: 'center',
				    dataIndex: 'kc',
				    text: 'Ka-1',
				    format:'0.0000',
				    filter: {type: 'numeric'},
				    flex: 1
				},
				{
				    xtype: 'numbercolumn',
				    align: 'center',
				    dataIndex: 'kc2',
				    text: 'Ka-2',
				    format:'0.0000',
				    flex: 1
				},
				{
				    xtype: 'numbercolumn',
				    align: 'center',
				    dataIndex: 'kc3',
				    text: 'Ka-3',
				    format:'0.0000',
				    flex: 1
				},
				{
				    xtype: 'numbercolumn',
				    align: 'center',
				    dataIndex: 'kc4',
				    text: 'Ka-3+',
				    format:'0.0000',
				    flex: 1
				},
				{
				    xtype: 'numbercolumn',
				    align: 'center',
				    dataIndex: 'kd',
				    text: 'Seek缺陷',
				    format:'0.0000',
				    flex: 1
				},
				{
				    xtype: 'numbercolumn',
				    align: 'center',
				    dataIndex: 'kd2',
				    text: '流故障-0',
				    format:'0.0000',
				    flex: 1
				},
				{
				    xtype: 'numbercolumn',
				    align: 'center',
				    dataIndex: 'ke',
				    text: '播放不完整',
				    format:'0.0000',
				    flex: 1
				},
				
				{
				    xtype: 'numbercolumn',
				    align: 'center',
				    dataIndex: 'f',
				    text: '用户播放样本',
				    flex: 1
				},
				{
				    xtype: 'numbercolumn',
				    align: 'center',
				    dataIndex: 'kf',
				    text: '播放总流失',
				    format:'0.0000',
				    flex: 1
				},
				
				{
				    xtype: 'numbercolumn',
				    align: 'center',
				    dataIndex: 'kf2',
				    text: 'EPG 失败',
				    format:'0.0000',
				    flex: 1
				},
				
				{
				    xtype: 'numbercolumn',
				    align: 'center',
				    dataIndex: 'kd3',
				    text: '流故障-1',
				    format:'0.0000',
				    flex: 1
				},
				{
				    xtype: 'numbercolumn',
				    align: 'center',
				    dataIndex: 'kf3',
				    text: '其它流失',
				    format:'0.0000',
				    flex: 1
				},
				{
				    xtype: 'numbercolumn',
				    align: 'center',
				    dataIndex: 'g',
				    text: 'IPS 843端口超时',
				    flex: 1
				},
				{
				    xtype: 'numbercolumn',
				    align: 'center',
				    dataIndex: 'g2',
				    text: 'IPS 843端口失败'
				}
            ],
            
            dockedItems: [{
                xtype: 'pagingtoolbar',
                dock:'bottom',
                store: 'AvlbMinutelyGridStore',
                displayInfo: true,
                displayMsg: 'Displaying records {0} - {1} of {2}',
                emptyMsg: "No records to display"
            }]
            
            
        });

        me.callParent(arguments);
    }

});