Ext.define('ifeng.view.MainView', {
    extend: 'Ext.container.Viewport',

    itemId: 'mainView',
    layout: 'fit',

    autoScroll: false,
    initComponent: function() {
        var me = this;

        Ext.applyIf(me, {
            items: [{
            	xtype: 'tabpanel',
            	items: [{
            		xtype: 'panel',
            		title: '视频概况',
            		layout: 'border',
            		items: [{
            			xtype: 'summaryForm',
            			region: 'north',
            			split: true
            		},{
            			xtype: 'summaryPanel',
            			region: 'center',
            			split: true
            		}]
            	},{
            		xtype: 'panel',
            		title: '分类查看',
            		layout: 'border',
            		 items: [{
	                    xtype: 'searchForm',
	                    region: 'north',
	                    split: true
	                },{
	                    xtype: 'allFilter',
	                    region: 'center',
	                    split: true
	                }]
		        }]
            }]
        });

        me.callParent(arguments);
    }

});