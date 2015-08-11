Ext.define('ifeng.view.AllPanel', {
    extend: 'Ext.form.Panel',
    alias: 'widget.allPanel',

    layout: 'border',
    bodyPadding: 5,
    title: '分类查看',
    header: false,

    initComponent: function() {
        var me = this;

        Ext.applyIf(me, {
            items: [
                {
                    xtype: 'searchForm',
                    region: 'north',
                    split: true
                },
                {
                    xtype: 'allFilter',
                    region: 'center',
                    split: true
                }
            ]
        });

        me.callParent(arguments);
    }

});