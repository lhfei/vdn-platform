Ext.define('ifeng.view.DailyTabPanel', {
    extend: 'Ext.tab.Panel',
    alias: 'widget.dailyPanel',

    initComponent: function() {
        var me = this;

        Ext.applyIf(me, {
            items: [
                {
                	iconCls: 'icon-chart',
                    xtype: 'allPanel'
                }/*,
                {
                	iconCls: 'icon-video',
                    xtype: 'newsreelPanel'
                },
                {
                	iconCls: 'icon-documentary',
                    xtype: 'documentaryPanel'
                }*/
            ]
        });

        me.callParent(arguments);
    }

});