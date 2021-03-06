Ext.define('ifeng.store.AgentStore', {
    extend: 'Ext.data.Store',

    requires: [
        'ifeng.model.AgentModel',
        'Ext.data.proxy.Ajax',
        'Ext.data.reader.Array'
    ],

    constructor: function(cfg) {
        var me = this;
        cfg = cfg || {};
        me.callParent([Ext.apply({
            model: 'ifeng.model.AgentModel',
            storeId: 'AgentStore',
            proxy: {
                type: 'ajax',
                pageParam: false, //to remove param "page"
                startParam: false, //to remove param "start"
                limitParam: false, //to remove param "limit"
                noCache: true, //to remove param "_dc"
                api: {
                    read: '../../basic/readISP.do'
                },
                reader: {
                    type: 'json',
                    root: 'data'
                }
            }
        }, cfg)]);
    }
});