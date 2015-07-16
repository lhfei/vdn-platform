/**
 * 
 */
Ext.define('ifeng.view.SearchForm', {
	extend: 'Ext.form.Panel',
	alias: 'widget.searchForm',
	layout: 'form',
	bodyPadding: '5 5 0',
	frame: true,
    title: 'IP 查询',
    collapsible: true,
	autoWidth: true,
	autoHeight: true,

    items: [{
    	xtype: 'fieldset',
    	title: 'IP 查询',
    	autoHeight: true,
    	collapsible: true,
    	defaults: {
            anchor: '100% 50%'
        },
    	items: [{
            xtype: 'textareafield',
            name: 'ips',
            emptyText: '支持批量IP查询，多个IP以, 分割',
            allowBlank: false
        }]
    }/*, {
        xtype:'fieldset',
        title: '高级查询',
        autoHeight: true,
        collapsible: true,
        collapsed: true,
        checkboxToggle: true,
        layout: 'anchor',
        defaults: {
            anchor: '100% 50%'
        },
        items :[{
        	xtype: 'filefield',
        	labelWidth: 75,
        	fieldLabel: '附件',
            name: 'ipFile',
            emptyText: 'IP 文件, 支持文本格式',
            buttonText: '',
            buttonConfig: {
                iconCls: 'upload-icon'
            }
        }]
    }*/],
    
    buttons: [{
        text: '查询',
        iconCls: 'icon-search',
        action: 'doCheck'
    },{
        text: '重置',
        iconCls: 'icon-cancel',
        action: 'doReset'
    }]
})