Ext.define('ifeng.store.IPServerStore', {
    extend: 'Ext.data.Store',
    alias: 'widget.ipServerStore',
    model: 'ifeng.model.IPServerModel',
    autoLoad: false,
    proxy: {
        type: 'rest',
        api: {
        	read: '../ipserver/read.do'
        },
        reader: {
            type: 'json',
            root: 'data',
            successProperty: 'success'
        },
        listeners: {
            exception: function(proxy, response, operation){
                Ext.MessageBox.show({
                    title: 'Remote Exception',
                    msg: operation.getError(),
                    icon: Ext.MessageBox.ERROR,
                    buttons: Ext.Msg.OK
                });
            }
        }
    }
});