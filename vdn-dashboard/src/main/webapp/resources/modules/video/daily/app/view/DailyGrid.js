Ext.define('ifeng.view.DailyGrid', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.dailyGrid',

    requires: [
        'Ext.grid.column.Column'
    ],

    height: 250,
    title: 'My Grid Panel',
    store: 'AvlbDailyStore',

    initComponent: function() {
        var me = this;

        Ext.applyIf(me, {
            columns: [
                {
                    xtype: 'gridcolumn',
                    dataIndex: 'ct',
                    text: 'Date',
                    flex: 1
                },
                {
                    xtype: 'gridcolumn',
                    dataIndex: 'denominator',
                    text: 'Denominator',
                    flex: 1
                },
                {
                    xtype: 'gridcolumn',
                    dataIndex: 'numerator',
                    text: 'Numerator',
                    flex: 1
                },
                {
                    xtype: 'gridcolumn',
                    dataIndex: 'avlb',
                    text: 'Available',
                    flex: 1
                }
            ]
        });

        me.callParent(arguments);
    }

});