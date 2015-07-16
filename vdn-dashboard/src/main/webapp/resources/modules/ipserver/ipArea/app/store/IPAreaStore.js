Ext.define('ifeng.store.IPAreaStore', {
    extend: 'Ext.data.Store',
    alias: 'widget.ipAreaStore',
    model: 'ifeng.model.IPAreaModel',
    autoLoad: true,
    proxy: {
        type: 'rest',
        api: {
        	read: '../ipController/getIPJournal.do'
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