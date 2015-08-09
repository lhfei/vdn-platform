Ext.define('ifeng.view.AllPanel', {
    extend: 'Ext.form.Panel',
    alias: 'widget.allPanel',

    layout: 'border',
    bodyPadding: 5,
    title: '全部',

    initComponent: function() {
        var me = this;

        Ext.applyIf(me, {
            items: [
                {
                    xtype: 'allFilter',
                    region: 'center'
                }
            ]
        });

        me.callParent(arguments);
    }

});