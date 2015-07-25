Ext.define('ifeng.view.DailyTabPanel', {
    extend: 'Ext.tab.Panel',
    alias: 'widget.dailyPanel',

    initComponent: function() {
        var me = this;

        Ext.applyIf(me, {
            items: [
                {
                    xtype: 'allPanel'
                },
                {
                    xtype: 'documentaryPanel'
                },
                {
                    xtype: 'newsreelPanel'
                }
            ]
        });

        me.callParent(arguments);
    }

});