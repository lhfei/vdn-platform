Ext.define('ifeng.store.AvlbMinutelyStore', {
    extend: 'Ext.data.Store',
    requires: [
        'ifeng.model.AvlbDaily',
        'Ext.data.proxy.Ajax',
        'Ext.data.reader.Json'
    ],

    constructor: function(cfg) {
        var me = this;
        cfg = cfg || {};
        me.callParent([Ext.apply({
            autoLoad: false,
            model: 'ifeng.model.AvlbMinutely',
            storeId: 'AvlbMinutelyStore',
            proxy: {
                type: 'ajax',
                pageParam: false, //to remove param "page"
                startParam: false, //to remove param "start"
                limitParam: false, //to remove param "limit"
                noCache: true, //to remove param "_dc"
                api: {
                    read: '../getAvlbMinutely.do'
                },
                reader: {
                    type: 'json',
                    root: 'data'
                }
            }
        }, cfg)]);
    }
});