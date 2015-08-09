Ext.define('ifeng.store.ShortVideoStore', {
    extend: 'Ext.data.Store',
    alias: 'store.shortVideoStore',

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
            storeId: 'ShortVideoStore',
            data: [
                {
                    name: '全部视频',
                    value: 'ST'
                },
                {
                    name: '牛市',
                    value: 'ST01'
                },
                {
                	name: '外站播放',
                	value: 'ST02'
                },
                {
                    name: '其他短视频',
                    value: 'ST99'
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