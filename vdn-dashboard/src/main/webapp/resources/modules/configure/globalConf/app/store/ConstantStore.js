Ext.define('ifeng.store.ConstantStore', {
    extend: 'Ext.data.Store',
    alias: 'widget.constantStore',
    model: 'ifeng.model.GlobalConstant',
    autoLoad: false,
    proxy: {
        type: 'rest',
        api: {
        	read: 'loadGlobal.do'
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