/**
 * 
 */
Ext.define('ifeng.view.InfoPanel', {
    extend: 'Ext.panel.Panel',
    alias : 'widget.infoPanel',
    id: 'img-detail-panel',
    header: false,
    
    tpl: [
        '<div class="details">',
            '<tpl for=".">',
                    (!Ext.isIE6? '<img src="../../resources/images/bigdata/sortable.png" />' : 
                    '<div style="width:74px;height:74px;filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(src=\'icons/sortable.png\')"></div>'),
                '<div class="details-info">',
                    '<b>外网IP:</b>',
                    '<span>{ip}</span>',
                    '<b>内网IP:</b>',
                    '<span>{inner_ip}</span>',
                    '<b>所属机房:</b>',
                    '<span>{room_name}</span>',
                    '<b>创建时间:</b>',
                    '<span>{create_time}</span>',
                '</div>',
            '</tpl>',
        '</div>'
    ],
    
    afterRender: function(){
        this.callParent();
        if (!Ext.isWebKit) {
            this.el.on('click', function(){
                alert('The Sencha Touch examples are intended to work on WebKit browsers. They may not display correctly in other browsers.');
            }, this, {delegate: 'a'});
        }    
    },

    /**
     * Loads a given image record into the panel. Animates the newly-updated panel in from the left over 250ms.
     */
    loadRecord: function(image) {
        this.body.hide();
        this.tpl.overwrite(this.body, image.data);
        this.body.slideIn('l', {
            duration: 250
        });
    },
    
    clear: function(){
        this.body.update('');
    }
});