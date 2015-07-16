Ext.define('ifeng.view.ChartWin', {
    extend: 'Ext.window.Window',
    alias: 'widget.chartWin',
    title: 'Chart',
    maximizable: true,
    maximized: true,
    modal: true,
    minimizable: true,
    minWidth: 480,
    minHeight: 320,
    /*tbar: [{
    	xtype: 'button',
    	text: '保存图片'
    }],*/
    
    layout: 'border',
    closeAction: 'hide',
    items: [{
    	xtype: 'chartSearchForm',
    	region: 'north',
    	split: true
    },{
    	xtype: 'form',
    	header: false,
    	region: 'center',
    	items: [{
    		contentEl: 'container'
    	}]
    }],
    
    
    initComponent: function() {
        var me = this;
        
        me.callParent(arguments);
    }

});