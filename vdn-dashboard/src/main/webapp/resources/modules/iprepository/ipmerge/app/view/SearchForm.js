/**
 * 
 */
// Add the additional 'advanced' VTypes
Ext.apply(Ext.form.field.VTypes, {
    daterange: function(val, field) {
        var date = field.parseDate(val);

        if (!date) {
            return false;
        }
        if (field.startDateField && (!this.dateRangeMax || (date.getTime() != this.dateRangeMax.getTime()))) {
            var start = field.up('form').down('#' + field.startDateField);
            start.setMaxValue(date);
            start.validate();
            this.dateRangeMax = date;
        }
        else if (field.endDateField && (!this.dateRangeMin || (date.getTime() != this.dateRangeMin.getTime()))) {
            var end = field.up('form').down('#' + field.endDateField);
            end.setMinValue(date);
            end.validate();
            this.dateRangeMin = date;
        }
        /*
         * Always return true since we're only using this vtype to set the
         * min/max allowed values (these are tested for after the vtype test)
         */
        return true;
    },

    daterangeText: 'Start date must be less than end date',

    password: function(val, field) {
        if (field.initialPassField) {
            var pwd = field.up('form').down('#' + field.initialPassField);
            return (val == pwd.getValue());
        }
        return true;
    },

    passwordText: 'Passwords do not match'
});
    
Ext.define('ifeng.view.SearchForm', {
	extend: 'Ext.form.Panel',
	alias: 'widget.searchForm',
	requires: ['Ext.ux.DataTip'],
	layout: 'form',
	bodyPadding: '5 5 5 5',
	frame: true,
    title: 'IP 查询',
    collapsible: true,

    items: [{
        xtype: 'fieldset',
        columnWidth: 1,
        layout: 'column',
        collapsible: true,
        title: '基本信息查询',
        fieldDefaults: {
            labelAlign: 'right',
            msgTarget: 'side',
            labelWidth: 65
        },
        items: [{
        	columnWidth: 0.333,
        	items: [{
        		xtype: 'datefield',
        		fieldLabel: '开始日期',
        		name: 'startdt',
                itemId: 'startdt',
                vtype: 'daterange',
                endDateField: 'enddt' // id of the end date field
        	}]
        },{
        	columnWidth: 0.333,
        	items: [{
        		xtype: 'datefield',
        		fieldLabel: '结束日期',
        		name: 'enddt',
                itemId: 'enddt',
                vtype: 'daterange',
                startDateField: 'startdt' // id of the start date field
        	}]
        },{
        	columnWidth: 0.333,
        	items: [{
        		xtype: 'combobox',
        		fieldLabel: '运营商'
        	}]
        }]
    },{
        xtype: 'fieldset',
        columnWidth: 1,
        layout: 'column',
        collapsible: true,
        collapsed: true,
        title: '高级查询',
        fieldDefaults: {
            labelAlign: 'right',
            msgTarget: 'side',
            labelWidth: 65
        },
        items: [{
        	columnWidth: 0.333,
        	items: [{
        		xtype: 'combobox',
        		fieldLabel: '节点名称'
        	}]
        },{
        	columnWidth: 0.333,
        	items: [{
        		xtype: 'combobox',
        		fieldLabel: '商业CDN'
        	}]
        },{
        	columnWidth: 0.333,
        	items: [{
        		xtype: 'combobox',
        		fieldLabel: '视频类型'
        	}]
        }]
    }],
    
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