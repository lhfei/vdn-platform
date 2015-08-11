Ext.define('ifeng.view.SummaryPanel', {
    extend: 'Ext.form.Panel',
    alias: 'widget.summaryPanel',
    
    itemId: '_dailyWin',
    title: '视频概况',
    header: false,
    maximizable: true,
    maximized: false,
    autoScroll: true,
    bodyPadding: '5 5 5 5',
    closeAction: 'hide',
    layout: 'column',
    
    initComponent: function() {
        var me = this;
        Ext.apply(me, {
        	
        	items: [{
        		columnWidth: 1,
        		defaults: {
        			xtype: 'fieldset',
        			layout: 'fit',
        			padding: '5 5 5 5',
        			collapsible: true,
        			autoScroll: true,
        			height: 320
        		},
        		
        		items: [{
        			title: '图1- VDN 可用性分时统计概况',
        			items: [{contentEl: 'avlbSumChart'}]
        		},{
        			title: '图2- 流畅度分时概况',
        			items: [{contentEl: 'fluentChart'}]
        		},{
        			title: '图3- VDN 请求样本数概况',
        			items: [{contentEl: 'vdnSummaryChart'}]
        		},{
        			title: '图4- 播放不完整率概况',
        			items: [{contentEl: 'incompleteChart'}]
        		}]
        	}]
        });
        me.callParent(arguments);
    }

});