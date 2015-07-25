Ext.define('ifeng.view.Viewport', {
    extend: 'Ext.container.Viewport',
    alias: 'mergeView',
    layout: 'border',
    items: [{
    	id: 'searchForm',
    	itemId: '_searchForm',
    	region: 'north',
    	xtype: 'searchForm',
    	split: 'true'
    },{
    	id: 'aliIPGrid',
    	itemId: '_aliIPGrid',
        region: 'center',
        xtype: 'ipAreaGrid',
        split: false
    },{
    	id: 'infoPanel',
    	itemId: '_infoPanel',
    	xtype: 'infoPanel',
    	region: 'east',
    	width: 200,
    	collapsible: true,
    	collapsed: true,
    	split: true
    }]
});
