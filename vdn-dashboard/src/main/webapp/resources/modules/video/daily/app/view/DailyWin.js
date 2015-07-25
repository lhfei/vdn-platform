Ext.define('ifeng.view.DailyWin', {
    extend: 'Ext.window.Window',
    alias: 'widget.dailyWin',

    height: '',
    minHeight: 250,
    minWidth: 400,
    title: '日统计报表',
    maximizable: true,
    maximized: true,
    
    layout: 'fit',
    closeAction: 'hide',
    
    initComponent: function() {
        var me = this;
        Ext.apply(me, {
        	items: [{
        		contentEl: 'chartContainer'
        	}]
        });
        me.callParent(arguments);
    }

});