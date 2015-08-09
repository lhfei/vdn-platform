Ext.define('ifeng.store.DataRangeStore', {
    extend: 'Ext.data.Store',
    alias: 'store.dataRangeStore',

    requires: [
        'ifeng.model.DataRangeModel',
        'Ext.data.proxy.Ajax',
        'Ext.data.reader.Array'
    ],

    constructor: function(cfg) {
        var me = this;
        cfg = cfg || {};
        me.callParent([Ext.apply({
            model: 'ifeng.model.DataRangeModel',
            storeId: 'DataRangeStore',
            data: [
                {
                    name: '今日数据',
                    value: 0
                },
                {
                    name: '3日内数据',
                    value: 2
                },
                {
                    name: '7日内数据',
                    value: 6
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