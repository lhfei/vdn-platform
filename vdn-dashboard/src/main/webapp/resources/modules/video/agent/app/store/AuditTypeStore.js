Ext.define('ifeng.store.AuditTypeStore', {
    extend: 'Ext.data.Store',
    alias: 'store.auditTypeStore',

    requires: [
        'ifeng.model.AuditType',
        'Ext.data.proxy.Ajax',
        'Ext.data.reader.Array'
    ],

    constructor: function(cfg) {
        var me = this;
        cfg = cfg || {};
        me.callParent([Ext.apply({
            model: 'ifeng.model.AuditType',
            storeId: 'AuditTypeStore',
            data: [
                {
                    name: '播放次数',
                    value: 0
                },
                {
                    name: '用户访问数',
                    value: 1
                }
            ],
            proxy: {
                type: 'ajax',
                reader: {
                    type: 'array'
                }
            }
        }, cfg)]);
    }
});