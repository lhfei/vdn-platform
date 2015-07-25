/**
 * 
 */
Ext.define('ifeng.view.InfoPanel', {
    extend: 'Ext.panel.Panel',
    alias : 'widget.infoPanel',
    id: 'img-detail-panel',
    header: false,
    title: '检测结果报告',
    
    tpl: [
        '<div class="details" style="padding-top: 20px">',
		    '<p>检测时间: </p>',
		    '<p>&nbsp;&nbsp;{create_time}</p>',
		    '<p>上次同步时间: ',
		    '<p>&nbsp;&nbsp;{latest_time}</p>',
		    '<p>上次MD 码: {lastChecksum}',
		    '<p>当前MD 码: {digest}',
		    '<tpl>',
		        '<tpl if="hasChanged">',
		            '<p>检测结果: 有变化</p>',
		        '<tpl else>',
		            '<p>检测结果: 无变化</p>',
		        '</tpl>',
		    '</tpl></p>',
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
    loadRecord: function(record) {
        this.body.hide();
        this.tpl.overwrite(this.body, record);
        this.body.slideIn('l', {
            duration: 250
        });
    },
    
    clear: function(){
        this.body.update('');
    }
});