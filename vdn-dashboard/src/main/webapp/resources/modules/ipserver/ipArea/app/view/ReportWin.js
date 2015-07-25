Ext.define('ifeng.view.ReportWin', {
    extend: 'Ext.window.Window',
    alias: 'widget.reporttWin',
    title: 'Chart',
    maximizable: true,
    maximized: true,
    modal: true,
    minimizable: true,
    minWidth: 480,
    minHeight: 320,
    
    layout: 'fit',
    closeAction: 'hide',
    items: [{
    	xtype: 'infoPanel'
    }],
    
    initComponent: function() {
        var me = this;
        
        me.callParent(arguments);
    }

});