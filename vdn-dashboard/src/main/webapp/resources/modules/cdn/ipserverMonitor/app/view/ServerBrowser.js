/**
 * 
 */
Ext.define('ifeng.view.ServerBrowser', {
    extend: 'Ext.view.View',
    alias: 'widget.serverBrowser',
    
    uses: 'Ext.data.Store',
    
	singleSelect: true,
    overItemCls: 'x-view-over',
    itemSelector: 'div.thumb-wrap',
    tpl: [
        // '<div class="details">',
            '<tpl for=".">',
                '<div class="thumb-wrap">',
                    '<div class="thumb">',
                    (!Ext.isIE6? '<img src="../../resources/images/bigdata/picker.png" />' : 
                    '<div style="width:74px;height:74px;filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(src=\'../../resources/images/bigdata/picker.png\')"></div>'),
                    '</div>',
                    '<span>{ip}</span>',
                '</div>',
            '</tpl>'
        // '</div>'
    ],
    
    store: 'ServerStore',
    
    initComponent: function() {
        /*this.store = Ext.create('Ext.data.Store', {
            autoLoad: true,
            fields: ['name', 'thumb', 'url', 'type'],
            proxy: {
                type: 'ajax',
                url : '../../resources/annex/icons.json',
                reader: {
                    type: 'json',
                    root: ''
                }
            }
        });*/
    	
    	//this.store = Ext.create('ifeng.store.ServerStore');
        
        this.callParent(arguments);
        this.store.sort();
    }
});