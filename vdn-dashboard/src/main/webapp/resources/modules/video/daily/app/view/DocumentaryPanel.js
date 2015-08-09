Ext.define('ifeng.view.DocumentaryPanel', {
    extend: 'Ext.form.Panel',
    alias: 'widget.documentaryPanel',

    bodyPadding: 5,
    layout: 'border',
    title: '纪录片',

    initComponent: function() {
        var me = this;

        Ext.applyIf(me, {
            items: [
                {
                    xtype: 'documentaryFilter',
                    region: 'center'
                }
            ]
        });
        
        me.callParent(arguments);
    }

});