Ext.define('ifeng.view.NewsreelPanel', {
    extend: 'Ext.form.Panel',
    alias: 'widget.newsreelPanel',

    bodyPadding: 10,
    layout: 'border',
    title: '其他视频',

    initComponent: function() {
        var me = this;
        Ext.applyIf(me, {
            items: [
                {
                    xtype: 'newsreelFilter',
                    region: 'center'
                }
            ]
        });
        me.callParent(arguments);
    }

});