Ext.define('ifeng.store.AliIPStore', {
    extend: 'Ext.data.Store',
    alias: 'widget.aliIPStore',
    model: 'ifeng.model.AliIPModel',
    autoLoad: false,
    proxy: {
        type: 'rest',
        
        pageParam: false, //to remove param "page"
        startParam: false, //to remove param "start"
        limitParam: false, //to remove param "limit"
        noCache: true, //to remove param "_dc"
        api: {
        	read: '../ipController/getIpInfo.do'
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