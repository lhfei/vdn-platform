Ext.define('ifeng.store.ServerStore', {
    extend: 'Ext.data.Store',
    alias: 'widget.serverStore',
    model: 'ifeng.model.ServerModel',
    autoLoad: true,
    pageSize: 10,
    proxy: {
        type: 'ajax',
        api: {
        	read: '../getServer.do',
        	create: '../createServer.do',
            destroy: '../removeServer.do'
        },
        reader: {
            type: 'json',
            root: 'data',
            successProperty: 'success'
        },
        writer: {
            type: 'json',
            writeAllFields: true,
            encode: false,
            root: ''
        }/*,
        listeners: {
            exception: function(proxy, response, operation){
                Ext.MessageBox.show({
                    title: 'Remote Exception',
                    msg: operation.getError(),
                    icon: Ext.MessageBox.ERROR,
                    buttons: Ext.Msg.OK
                });
            }
        }*/
    }
});