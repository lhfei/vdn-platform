/**
 * 
 */
Ext.define('ifeng.view.ServerRoomWin', {
    extend: 'Ext.window.Window',
    requires: [
        'Ext.form.Panel',
        'Ext.form.FieldSet',
        'Ext.form.field.Text',
        'Ext.button.Button'
    ],
	alias: 'widget.serverRoomWin',
	title: '',
	
	autoShow: false,
	layout: 'fit',
	
	items: [{
        xtype: 'form',
        bodyPadding: 10,
        header: false,
        title: 'My Form',
        items: [{
            xtype: 'fieldset',
            defaults: {
                anchor: '100%',
                xtype: 'textfield',
                labelAlign: 'right'
            },
            title: '机房信息',
            items: [{
                xtype: 'textfield',
                anchor: '100%',
                name: 'room_name',
                fieldLabel: '机房名称'
            },{
                xtype: 'textfield',
                anchor: '100%',
                name: 'room_code',
                fieldLabel: '机房编号'
            }]
        }]
    }],
    
    buttons: [{
        text: '提交',
        itemId: 'doSaveRoomBtn',
        iconCls: 'icon-search',
        action: 'doSaveRoom'
    },{
        text: '重置',
        itemId: 'doResetRoomBtn',
        iconCls: 'icon-cancel',
        action: 'doResetRoom'
    }],
	
	
    initComponent: function() {
    	var me = this;
		
		this.callParent(arguments);
	}
    
});