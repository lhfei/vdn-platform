Ext.define('ifeng.store.LongVideoStore', {
    extend: 'Ext.data.Store',
    alias: 'store.longVideoStore',

    requires: [
        'ifeng.model.VideoCategoryModel',
        'Ext.data.proxy.Ajax',
        'Ext.data.reader.Array'
    ],

    constructor: function(cfg) {
        var me = this;
        cfg = cfg || {};
        me.callParent([Ext.apply({
            model: 'ifeng.model.VideoCategoryModel',
            storeId: 'LongVideoStore',
            data: [
                {
                    name: '全部视频',
                    value: 'LG'
                },
                {
                    name: '纪录片',
                    value: 'LG01'
                },
                {
                    name: '其他长视频',
                    value: 'LG99'
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