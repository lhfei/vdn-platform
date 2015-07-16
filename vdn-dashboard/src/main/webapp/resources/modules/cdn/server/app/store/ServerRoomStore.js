Ext.define('ifeng.store.ServerRoomStore', {
    extend: 'Ext.data.Store',
    alias: 'widget.serverRoomStore',
    model: 'ifeng.model.ServerRoomModel',
    autoLoad: true,
    pageSize: 10,
    proxy: {
        type: 'ajax',
        api: {
        	read: '../getServerRoom.do',
        	create: '../createServerRoom.do',
            destroy: '../removeServerRoom.do'
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