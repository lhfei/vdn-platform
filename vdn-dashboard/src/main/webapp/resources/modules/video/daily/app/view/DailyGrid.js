Ext.define('ifeng.view.DailyGrid', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.dailyGrid',

    requires: [
        'Ext.grid.column.Column'
    ],

    height: 300,
    title: '可用性统计数据',
    header: true,
    store: 'AvlbMinutelyStore',
    collapsible: true,

    initComponent: function() {
        var me = this;

        Ext.applyIf(me, {
            columns: [
                {header: '序号', xtype: 'rownumberer', align: 'center', width: 40, sortable: false, locked: true }, 
                {
                    xtype: 'gridcolumn',
                    align: 'center',
                    dataIndex: 'ct',
                    text: '日期',
                    flex: 1
                },
                {
                    xtype: 'gridcolumn',
                    align: 'center',
                    dataIndex: 'numerator',
                    text: '计算分子',
                    flex: 1
                },
                {
                    xtype: 'gridcolumn',
                    align: 'center',
                    dataIndex: 'denominator',
                    text: '计算分母',
                    flex: 1
                },
                {
                    xtype: 'gridcolumn',
                    align: 'center',
                    dataIndex: 'tr',
                    text: '时段',
                    flex: 1
                },
                {
                    xtype: 'gridcolumn',
                    align: 'center',
                    dataIndex: 'avlb',
                    text: 'Available',
                    flex: 1
                }
            ]
        });

        me.callParent(arguments);
    }

});