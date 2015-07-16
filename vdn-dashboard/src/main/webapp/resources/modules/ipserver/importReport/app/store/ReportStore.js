Ext.define('ifeng.store.ReportStore', {
    extend: 'Ext.data.Store',
    alias: 'widget.reportStore',
    model: 'ifeng.model.ReportModel',
    autoLoad: true,
    proxy: {
        type: 'rest',
        api: {
        	read: '../ipController/getIPImportReport.do'
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