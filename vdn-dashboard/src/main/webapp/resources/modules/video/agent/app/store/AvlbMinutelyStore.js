Ext.define('ifeng.store.AvlbMinutelyStore', {
    extend: 'Ext.data.Store',
    requires: [
        'ifeng.model.AvlbMinutely',
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
            
            pageSize: 100,
            
            // allow the grid to interact with the paging scroller by buffering
            buffered: true,
            
            // This web service seems slow, so keep lots of data in the pipeline ahead!
            leadingBufferZone: 1000,
            
            proxy: {
                type: 'ajax',
//                pageParam: true, //to remove param "page"
//                startParam: true, //to remove param "start"
//                limitParam: true, //to remove param "limit"
//                noCache: false, //to remove param "_dc"
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