--
-- PostgreSQL database dump
--

-- Dumped from database version 12.1
-- Dumped by pg_dump version 12.1

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: aerodemo; Type: SCHEMA; Schema: -; Owner: jjs
--

CREATE SCHEMA aerodemo;


ALTER SCHEMA aerodemo OWNER TO jjs;

--
-- Name: update_fcst_grp(character varying, character varying); Type: FUNCTION; Schema: aerodemo; Owner: jjs
--

CREATE FUNCTION aerodemo.update_fcst_grp(oldname character varying, newname character varying) RETURNS character varying
    LANGUAGE plpgsql
    AS $$
begin
   insert into fcst_grp  (fcst_grp, fcst_grp_descr, ut_user_nbr, last_mod_dt, oo_prty, wo_prty, ss_prty, fc_prty)
   select newname,fcst_grp_descr, ut_user_nbr, last_mod_dt, oo_prty, wo_prty, ss_prty, fc_prty
   from fcst_grp where fcst_grp = oldname;
   return 'success';
end; 
$$;


ALTER FUNCTION aerodemo.update_fcst_grp(oldname character varying, newname character varying) OWNER TO jjs;

--
-- Name: addr_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.addr_nbr_seq
    START WITH 118385
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.addr_nbr_seq OWNER TO jjs;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: ail_back; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.ail_back (
    item_nbr integer,
    aps_log_file_name character varying(255),
    last_plan_dt timestamp without time zone
);


ALTER TABLE aerodemo.ail_back OWNER TO jjs;

--
-- Name: alloc_stats; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.alloc_stats (
    nbr_oo_old integer,
    nbr_oo_new integer,
    nbr_wo_old integer,
    nbr_wo_new integer,
    nbr_ss_old integer,
    nbr_ss_new integer,
    nbr_fc_old integer,
    nbr_fc_new integer,
    nbr_oo_alloc_full_old integer,
    nbr_oo_alloc_full_new integer,
    nbr_wo_alloc_full_old integer,
    nbr_wo_alloc_full_new integer,
    nbr_ss_alloc_full_old integer,
    nbr_ss_alloc_full_new integer,
    nbr_fc_alloc_full_old integer,
    nbr_fc_alloc_full_new integer,
    nbr_oo_unalloc_old integer,
    nbr_oo_unalloc_new integer,
    nbr_wo_unalloc_old integer,
    nbr_wo_unalloc_new integer,
    nbr_ss_unalloc_old integer,
    nbr_ss_unalloc_new integer,
    nbr_fc_unalloc_old integer,
    nbr_fc_unalloc_new integer,
    nbr_oo_alloc_full_ontime_old integer,
    nbr_oo_alloc_full_ontime_new integer,
    nbr_wo_alloc_full_ontime_old integer,
    nbr_wo_alloc_full_ontime_new integer,
    nbr_ss_alloc_full_ontime_old integer,
    nbr_ss_alloc_full_ontime_new integer,
    nbr_fc_alloc_full_ontime_old integer,
    nbr_fc_alloc_full_ontime_new integer
);


ALTER TABLE aerodemo.alloc_stats OWNER TO jjs;

--
-- Name: ap_inv_batch_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.ap_inv_batch_nbr_seq
    START WITH 19176
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.ap_inv_batch_nbr_seq OWNER TO jjs;

--
-- Name: ap_inv_dtl_charge_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.ap_inv_dtl_charge_nbr_seq
    START WITH 6918
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.ap_inv_dtl_charge_nbr_seq OWNER TO jjs;

--
-- Name: ap_inv_dtl_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.ap_inv_dtl_nbr_seq
    START WITH 173259
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.ap_inv_dtl_nbr_seq OWNER TO jjs;

--
-- Name: ap_inv_hdr_charge_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.ap_inv_hdr_charge_nbr_seq
    START WITH 5656
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.ap_inv_hdr_charge_nbr_seq OWNER TO jjs;

--
-- Name: ap_inv_hdr_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.ap_inv_hdr_nbr_seq
    START WITH 81348
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE aerodemo.ap_inv_hdr_nbr_seq OWNER TO jjs;

--
-- Name: app_ctl; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.app_ctl (
    property_nm character varying(255) NOT NULL,
    property_val character varying(255) NOT NULL
);


ALTER TABLE aerodemo.app_ctl OWNER TO jjs;

--
-- Name: app_ctl2; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.app_ctl2 (
    property_nm character varying(255),
    property_val character varying(255)
);


ALTER TABLE aerodemo.app_ctl2 OWNER TO jjs;

--
-- Name: aps_alloc_delete_log; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.aps_alloc_delete_log (
    delete_dt timestamp without time zone NOT NULL,
    aps_alloc_onhand_nbr integer NOT NULL,
    dmd_key integer NOT NULL,
    lot_nbr integer NOT NULL,
    alloc_qty numeric(13,5) NOT NULL,
    aps_sply_sub_pool_nbr integer NOT NULL,
    subst_id character varying(1),
    facility_rqst character varying(16) NOT NULL,
    facility_act character varying(16) NOT NULL,
    item_nbr_rqst integer NOT NULL,
    unit_price_sell_um numeric(17,6),
    unit_price_denom_sell_um numeric(17,6),
    unit_price_stk_um numeric(17,6),
    unit_price_denom_stk_um numeric(17,6),
    alloc_type_id character varying(1) NOT NULL,
    wh_facility_trans_onhand_nbr integer,
    avail_dt timestamp without time zone NOT NULL,
    avail_dt_type_id character varying(1) NOT NULL,
    dmd_type character varying(2) NOT NULL,
    log_comm character varying(1000),
    notify_dt timestamp without time zone
);


ALTER TABLE aerodemo.aps_alloc_delete_log OWNER TO jjs;

--
-- Name: COLUMN aps_alloc_delete_log.lot_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_alloc_delete_log.lot_nbr IS 'The lot which was shipped, a foreign key back to the primary surrogate key in ic_lot_mast.';


--
-- Name: COLUMN aps_alloc_delete_log.aps_sply_sub_pool_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_alloc_delete_log.aps_sply_sub_pool_nbr IS 'a foreign key back to the primary key for the supply sub pool';


--
-- Name: aps_alloc_nbr; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.aps_alloc_nbr (
    nextval integer
);


ALTER TABLE aerodemo.aps_alloc_nbr OWNER TO jjs;

--
-- Name: aps_alloc_oh_fc; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.aps_alloc_oh_fc (
    aps_alloc_oh_fc_nbr integer NOT NULL,
    item_nbr integer NOT NULL,
    fc_fcst_nbr integer NOT NULL,
    facility_act character varying(16) NOT NULL,
    lot_nbr integer NOT NULL,
    aps_sply_sub_pool_nbr integer NOT NULL,
    alloc_qty numeric(13,5) NOT NULL,
    alloc_type_id character varying(1) DEFAULT 'U'::character varying NOT NULL,
    CONSTRAINT sys_c0017494 CHECK ((lot_nbr IS NOT NULL)),
    CONSTRAINT sys_c0017495 CHECK ((aps_sply_sub_pool_nbr IS NOT NULL)),
    CONSTRAINT sys_c0017496 CHECK ((facility_act IS NOT NULL)),
    CONSTRAINT sys_c0017497 CHECK ((alloc_qty IS NOT NULL)),
    CONSTRAINT sys_c0017498 CHECK ((alloc_type_id IS NOT NULL))
);


ALTER TABLE aerodemo.aps_alloc_oh_fc OWNER TO jjs;

--
-- Name: COLUMN aps_alloc_oh_fc.alloc_type_id; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_alloc_oh_fc.alloc_type_id IS 'R-Reuested for Bind,
		B_Bound Allocation, U-Unbound Allocation';


--
-- Name: aps_alloc_oh_oo; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.aps_alloc_oh_oo (
    aps_alloc_oh_oo_nbr integer NOT NULL,
    item_nbr integer NOT NULL,
    oe_ord_dtl_nbr integer NOT NULL,
    facility_act character varying(16) NOT NULL,
    lot_nbr integer NOT NULL,
    aps_sply_sub_pool_nbr integer NOT NULL,
    alloc_qty numeric(13,5) NOT NULL,
    alloc_type_id character varying(1) DEFAULT 'U'::character varying NOT NULL,
    item_nbr_rqst integer NOT NULL,
    wh_facility_trans_onhand_nbr integer,
    CONSTRAINT sys_c0017506 CHECK ((oe_ord_dtl_nbr IS NOT NULL)),
    CONSTRAINT sys_c0017507 CHECK ((lot_nbr IS NOT NULL)),
    CONSTRAINT sys_c0017508 CHECK ((aps_sply_sub_pool_nbr IS NOT NULL)),
    CONSTRAINT sys_c0017509 CHECK ((facility_act IS NOT NULL)),
    CONSTRAINT sys_c0017510 CHECK ((alloc_qty IS NOT NULL)),
    CONSTRAINT sys_c0017511 CHECK ((alloc_type_id IS NOT NULL))
);


ALTER TABLE aerodemo.aps_alloc_oh_oo OWNER TO jjs;

--
-- Name: COLUMN aps_alloc_oh_oo.facility_act; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_alloc_oh_oo.facility_act IS 'The actual facility that had the inventory that was allocated to this demand.';


--
-- Name: COLUMN aps_alloc_oh_oo.aps_sply_sub_pool_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_alloc_oh_oo.aps_sply_sub_pool_nbr IS 'A foreign key to the subset of inventory, within this lot that was allocated to this demand.';


--
-- Name: COLUMN aps_alloc_oh_oo.alloc_type_id; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_alloc_oh_oo.alloc_type_id IS 'R-Reuested for Bind,
		B_Bound Allocation, U-Unbound Allocation';


--
-- Name: aps_alloc_onhand_fc; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.aps_alloc_onhand_fc (
    aps_alloc_onhand_fc_nbr integer NOT NULL,
    item_nbr_rqst integer NOT NULL,
    fc_fcst_nbr integer,
    lot_nbr integer,
    aps_sply_sub_pool_nbr integer,
    facility_rqst character varying(16),
    facility_act character varying(16),
    alloc_qty numeric(13,5),
    subst_id character varying(1),
    alloc_type_id character varying(1),
    wh_facility_trans_onhand_nbr integer,
    avail_dt timestamp without time zone,
    avail_dt_type_id character varying(1),
    fc_item_mast_nbr integer,
    fcst_dt timestamp without time zone
);


ALTER TABLE aerodemo.aps_alloc_onhand_fc OWNER TO jjs;

--
-- Name: COLUMN aps_alloc_onhand_fc.lot_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_alloc_onhand_fc.lot_nbr IS 'The lot which was shipped, a foreign key back to the primary surrogate key in ic_lot_mast.';


--
-- Name: COLUMN aps_alloc_onhand_fc.aps_sply_sub_pool_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_alloc_onhand_fc.aps_sply_sub_pool_nbr IS 'a foreign key back to the primary key for the supply sub pool';


--
-- Name: COLUMN aps_alloc_onhand_fc.fc_item_mast_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_alloc_onhand_fc.fc_item_mast_nbr IS 'Surrogate primary key for FC_ITEM_MAST.';


--
-- Name: aps_alloc_onhand_oo; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.aps_alloc_onhand_oo (
    aps_alloc_onhand_oo_nbr integer NOT NULL,
    item_nbr_rqst integer NOT NULL,
    oe_ord_dtl_nbr integer,
    lot_nbr integer,
    aps_sply_sub_pool_nbr integer,
    facility_rqst character varying(16),
    facility_act character varying(16),
    subst_id character varying(1),
    alloc_qty numeric(13,5),
    unit_price_sell_um numeric(17,6),
    unit_price_denom_sell_um numeric(17,6),
    unit_price_stk_um numeric(17,6),
    unit_price_denom_stk_um numeric(17,6),
    alloc_type_id character varying(1),
    wh_facility_trans_onhand_nbr integer,
    avail_dt timestamp without time zone,
    avail_dt_type_id character varying(1),
    alloc_rqst_qty numeric(13,5)
);


ALTER TABLE aerodemo.aps_alloc_onhand_oo OWNER TO jjs;

--
-- Name: COLUMN aps_alloc_onhand_oo.oe_ord_dtl_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_alloc_onhand_oo.oe_ord_dtl_nbr IS 'A foreign key back to the order detail.';


--
-- Name: COLUMN aps_alloc_onhand_oo.lot_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_alloc_onhand_oo.lot_nbr IS 'The lot which was shipped, a foreign key back to the primary surrogate key in ic_lot_mast.';


--
-- Name: COLUMN aps_alloc_onhand_oo.aps_sply_sub_pool_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_alloc_onhand_oo.aps_sply_sub_pool_nbr IS 'a foreign key back to the primary key for the supply sub pool';


--
-- Name: aps_alloc_onhand_oo_sum; Type: VIEW; Schema: aerodemo; Owner: jjs
--

CREATE VIEW aerodemo.aps_alloc_onhand_oo_sum AS
 SELECT aps_alloc_onhand_oo.oe_ord_dtl_nbr,
    sum(aps_alloc_onhand_oo.alloc_qty) AS sum_alloc_qty_oh,
    max(aps_alloc_onhand_oo.avail_dt) AS max_avail_dt_oh,
    min((aps_alloc_onhand_oo.facility_rqst)::text) AS facility_rqst
   FROM aerodemo.aps_alloc_onhand_oo
  GROUP BY aps_alloc_onhand_oo.oe_ord_dtl_nbr;


ALTER TABLE aerodemo.aps_alloc_onhand_oo_sum OWNER TO jjs;

--
-- Name: aps_alloc_onhand_ss; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.aps_alloc_onhand_ss (
    aps_alloc_onhand_ss_nbr integer NOT NULL,
    item_nbr_rqst integer NOT NULL,
    fc_item_mast_nbr integer,
    lot_nbr integer,
    aps_sply_sub_pool_nbr integer,
    facility_rqst character varying(16),
    facility_act character varying(16),
    alloc_qty numeric(13,5),
    subst_id character varying(1),
    alloc_type_id character varying(1),
    wh_facility_trans_onhand_nbr integer,
    avail_dt timestamp without time zone,
    avail_dt_type_id character varying(1)
);


ALTER TABLE aerodemo.aps_alloc_onhand_ss OWNER TO jjs;

--
-- Name: COLUMN aps_alloc_onhand_ss.fc_item_mast_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_alloc_onhand_ss.fc_item_mast_nbr IS 'Surrogate primary key for FC_ITEM_MAST.';


--
-- Name: COLUMN aps_alloc_onhand_ss.lot_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_alloc_onhand_ss.lot_nbr IS 'The lot which was shipped, a foreign key back to the primary surrogate key in ic_lot_mast.';


--
-- Name: COLUMN aps_alloc_onhand_ss.aps_sply_sub_pool_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_alloc_onhand_ss.aps_sply_sub_pool_nbr IS 'a foreign key back to the primary key for the supply sub pool';


--
-- Name: aps_alloc_onhand_wo; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.aps_alloc_onhand_wo (
    aps_alloc_onhand_wo_nbr integer NOT NULL,
    item_nbr_rqst integer NOT NULL,
    wo_dtl_nbr integer,
    lot_nbr integer,
    aps_sply_sub_pool_nbr integer,
    facility_rqst character varying(16),
    facility_act character varying(16),
    alloc_qty numeric(13,5),
    alloc_type_id character varying(1),
    wh_facility_trans_onhand_nbr integer,
    avail_dt timestamp without time zone,
    avail_dt_type_id character varying(1)
);


ALTER TABLE aerodemo.aps_alloc_onhand_wo OWNER TO jjs;

--
-- Name: COLUMN aps_alloc_onhand_wo.lot_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_alloc_onhand_wo.lot_nbr IS 'The lot which was shipped, a foreign key back to the primary surrogate key in ic_lot_mast.';


--
-- Name: COLUMN aps_alloc_onhand_wo.aps_sply_sub_pool_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_alloc_onhand_wo.aps_sply_sub_pool_nbr IS 'a foreign key back to the primary key for the supply sub pool';


--
-- Name: aps_alloc_replen_oo; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.aps_alloc_replen_oo (
    aps_alloc_replen_oo_nbr integer NOT NULL,
    item_nbr_rqst integer NOT NULL,
    oe_ord_dtl_nbr integer,
    po_line_dtl_nbr integer,
    facility_rqst character varying(16),
    facility_act character varying(16),
    subst_id character varying(1),
    alloc_qty numeric(13,5),
    unit_price_sell_um numeric(17,6),
    unit_price_denom_sell_um numeric(17,6),
    unit_price_stk_um numeric(17,6),
    unit_price_denom_stk_um numeric(17,6),
    alloc_type_id character varying(1),
    wh_facility_trans_replen_nbr integer,
    aps_sply_sub_pool_nbr integer
);


ALTER TABLE aerodemo.aps_alloc_replen_oo OWNER TO jjs;

--
-- Name: COLUMN aps_alloc_replen_oo.oe_ord_dtl_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_alloc_replen_oo.oe_ord_dtl_nbr IS 'A foreign key back to the order detail.';


--
-- Name: po_line_dtl; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.po_line_dtl (
    po_line_dtl_nbr integer NOT NULL,
    po_line_hdr_nbr integer NOT NULL,
    sched_qty numeric(13,5) NOT NULL,
    recv_qty numeric(13,5),
    replen_rqst_ship_dt timestamp without time zone NOT NULL,
    replen_est_ship_dt timestamp without time zone NOT NULL,
    replen_curr_est_dt timestamp without time zone NOT NULL,
    ship_to_addr_nbr integer NOT NULL,
    ship_via_cd character varying(8) NOT NULL,
    ut_user_nbr integer NOT NULL,
    last_mod_dt timestamp without time zone NOT NULL,
    aps_sply_sub_pool_nbr integer NOT NULL,
    facility character varying(16) NOT NULL,
    cancel_cd character varying(8),
    cancel_dt timestamp without time zone,
    ut_user_nbr_cancel integer,
    sched_qty_stk_um numeric(13,5) NOT NULL,
    recv_qty_stk_um numeric(13,5),
    aps_avail_dt timestamp without time zone,
    cannot_resched_flg character varying(1) NOT NULL,
    buy_reason_cd character varying(8),
    CONSTRAINT sys_c0015625 CHECK (((cannot_resched_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0016105 CHECK (((cannot_resched_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0016106 CHECK (((cannot_resched_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text])))
);


ALTER TABLE aerodemo.po_line_dtl OWNER TO jjs;

--
-- Name: COLUMN po_line_dtl.replen_curr_est_dt; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.po_line_dtl.replen_curr_est_dt IS 'Current estimated availability date of the schedule.';


--
-- Name: COLUMN po_line_dtl.ship_via_cd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.po_line_dtl.ship_via_cd IS 'The shipment method, identifies the carrier and priority.';


--
-- Name: COLUMN po_line_dtl.ut_user_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.po_line_dtl.ut_user_nbr IS 'Surrogate primary key for UT_USER';


--
-- Name: COLUMN po_line_dtl.aps_sply_sub_pool_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.po_line_dtl.aps_sply_sub_pool_nbr IS 'a foreign key back to the primary key for the supply sub pool';


--
-- Name: COLUMN po_line_dtl.facility; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.po_line_dtl.facility IS 'The facility (e.g. warehouse) to which this inventory is to be shipped';


--
-- Name: aps_alloc_po_oo_sum; Type: VIEW; Schema: aerodemo; Owner: jjs
--

CREATE VIEW aerodemo.aps_alloc_po_oo_sum AS
 SELECT aaro.oe_ord_dtl_nbr,
    sum(aaro.alloc_qty) AS sum_alloc_qty_po,
    max(pod.replen_curr_est_dt) AS max_avail_dt_po,
    min((aaro.facility_rqst)::text) AS facility_rqst
   FROM aerodemo.aps_alloc_replen_oo aaro,
    aerodemo.po_line_dtl pod
  WHERE (pod.po_line_dtl_nbr = aaro.po_line_dtl_nbr)
  GROUP BY aaro.oe_ord_dtl_nbr;


ALTER TABLE aerodemo.aps_alloc_po_oo_sum OWNER TO jjs;

--
-- Name: aps_alloc_wo_oo; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.aps_alloc_wo_oo (
    aps_alloc_wo_oo_nbr integer NOT NULL,
    item_nbr_rqst integer NOT NULL,
    wo_hdr_nbr integer,
    oe_ord_dtl_nbr integer,
    facility_rqst character varying(16),
    facility_act character varying(16),
    alloc_qty numeric(13,5),
    alloc_type_id character varying(1),
    wh_facility_trans_wo_nbr integer,
    aps_sply_sub_pool_nbr integer
);


ALTER TABLE aerodemo.aps_alloc_wo_oo OWNER TO jjs;

--
-- Name: COLUMN aps_alloc_wo_oo.wo_hdr_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_alloc_wo_oo.wo_hdr_nbr IS 'The surrogate primary key for WO_HDR.';


--
-- Name: COLUMN aps_alloc_wo_oo.oe_ord_dtl_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_alloc_wo_oo.oe_ord_dtl_nbr IS 'A foreign key back to the order detail.';


--
-- Name: wo_hdr; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.wo_hdr (
    wo_hdr_nbr integer NOT NULL,
    wo_descr character varying(100),
    item_nbr_rqst integer NOT NULL,
    rqst_qty integer NOT NULL,
    wo_um character varying(3) NOT NULL,
    release_qty integer,
    fill_qty integer,
    need_by_dt timestamp without time zone NOT NULL,
    aps_sply_sub_pool_nbr integer NOT NULL,
    facility character varying(16) NOT NULL,
    aps_src_rule_set_nbr integer NOT NULL,
    org_nbr_cust integer NOT NULL,
    ut_user_nbr_rqst integer NOT NULL,
    oe_ord_dtl_nbr integer,
    ut_user_nbr integer NOT NULL,
    last_mod_dt timestamp without time zone NOT NULL,
    wo_stat_id character varying(1) NOT NULL,
    CONSTRAINT woh_check_wo_stat_id CHECK (((wo_stat_id)::text = ANY (ARRAY[('O'::character varying)::text, ('C'::character varying)::text, ('X'::character varying)::text])))
);


ALTER TABLE aerodemo.wo_hdr OWNER TO jjs;

--
-- Name: COLUMN wo_hdr.wo_hdr_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.wo_hdr.wo_hdr_nbr IS 'The surrogate primary key for WO_HDR.';


--
-- Name: COLUMN wo_hdr.aps_sply_sub_pool_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.wo_hdr.aps_sply_sub_pool_nbr IS 'a foreign key back to the primary key for the supply sub pool';


--
-- Name: COLUMN wo_hdr.facility; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.wo_hdr.facility IS 'The facility associated with this record.  ';


--
-- Name: COLUMN wo_hdr.org_nbr_cust; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.wo_hdr.org_nbr_cust IS 'Reference to the customer (OE_CUST_MAST.ORG_NBR_CUST)';


--
-- Name: COLUMN wo_hdr.oe_ord_dtl_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.wo_hdr.oe_ord_dtl_nbr IS 'A foreign key back to the order detail.';


--
-- Name: COLUMN wo_hdr.ut_user_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.wo_hdr.ut_user_nbr IS 'Surrogate primary key for UT_USER';


--
-- Name: aps_alloc_wo_oo_sum; Type: VIEW; Schema: aerodemo; Owner: jjs
--

CREATE VIEW aerodemo.aps_alloc_wo_oo_sum AS
 SELECT aawo.oe_ord_dtl_nbr,
    sum(aawo.alloc_qty) AS sum_alloc_qty_wo,
    max(wh.need_by_dt) AS max_avail_dt_wo,
    min((aawo.facility_rqst)::text) AS facility_rqst
   FROM aerodemo.aps_alloc_wo_oo aawo,
    aerodemo.wo_hdr wh
  WHERE (wh.wo_hdr_nbr = aawo.wo_hdr_nbr)
  GROUP BY aawo.oe_ord_dtl_nbr;


ALTER TABLE aerodemo.aps_alloc_wo_oo_sum OWNER TO jjs;

--
-- Name: oe_ord_dtl; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.oe_ord_dtl (
    oe_ord_dtl_nbr integer NOT NULL,
    oe_ord_hdr_nbr integer NOT NULL,
    org_nbr_cust integer NOT NULL,
    line_nbr smallint NOT NULL,
    item_nbr_rqst integer NOT NULL,
    qty_ord numeric(15,5) NOT NULL,
    sell_um character varying(3) NOT NULL,
    rqst_dt timestamp without time zone NOT NULL,
    ship_to_addr_nbr integer NOT NULL,
    prom_dt_orig timestamp without time zone NOT NULL,
    tie_cd character varying(1),
    line_stat_id character varying(1) NOT NULL,
    item_cd_cust character varying(50),
    pkg_qty integer,
    pick_prty_cust smallint,
    pick_prty_rqst smallint,
    pick_prty_past_due_mult smallint,
    ut_user_nbr integer NOT NULL,
    last_mod_dt timestamp without time zone NOT NULL,
    ship_via_cd character varying(8) NOT NULL,
    cust_bin_cd character varying(40),
    cust_line_cd character varying(5),
    org_nbr_mfr_rqst integer,
    contract_cd character varying(8),
    qty_ship numeric(15,5),
    item_nbr_ord integer NOT NULL,
    aps_src_rule_set_nbr integer NOT NULL,
    cancel_cd character varying(8),
    cancel_dt timestamp without time zone,
    ut_user_nbr_cancel integer,
    lot_not_expire_before_dt timestamp without time zone,
    lot_manufacture_after_dt timestamp without time zone,
    cntry_cd_origin character varying(3),
    qty_ord_stk_um numeric(15,5) NOT NULL,
    rev_lvl character varying(5),
    unit_price_stk_um numeric(17,6),
    unit_price_denom_stk_um numeric(17,6),
    qty_ship_stk_um numeric(15,5),
    part_mismatch_reason_cd character varying(8),
    unit_price_sell_um numeric(17,6),
    unit_price_denom_sell_um numeric(17,6),
    cust_ref character varying(40),
    qty_alloc numeric(13,5),
    qty_alloc_stk_um numeric(13,5),
    prom_dt_curr timestamp without time zone NOT NULL,
    ship_from_facility character varying(16) NOT NULL,
    ship_cmplt_flg character varying(1) NOT NULL,
    hot_flg character varying(1) NOT NULL,
    ship_line_pct smallint,
    oe_close_reason_cd character varying(8),
    close_tm timestamp without time zone,
    ut_user_nbr_close integer,
    auto_close_line_pct smallint,
    max_shipments_per_line smallint,
    wh_ship_prty_nbr integer,
    payment_method_cd character varying(3),
    CONSTRAINT check_ood_line_stat_id CHECK (((line_stat_id)::text = ANY (ARRAY[('O'::character varying)::text, ('C'::character varying)::text, ('H'::character varying)::text, ('X'::character varying)::text]))),
    CONSTRAINT sys_c0015523 CHECK (((ship_cmplt_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0015524 CHECK (((hot_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text])))
);


ALTER TABLE aerodemo.oe_ord_dtl OWNER TO jjs;

--
-- Name: COLUMN oe_ord_dtl.oe_ord_dtl_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.oe_ord_dtl.oe_ord_dtl_nbr IS 'A foreign key back to the customer order line detail. (OE_ORD_DTL.OE_ORD_DTL_NBR)';


--
-- Name: COLUMN oe_ord_dtl.org_nbr_cust; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.oe_ord_dtl.org_nbr_cust IS 'Reference to the customer (OE_CUST_MAST.ORG_NBR_CUST)';


--
-- Name: COLUMN oe_ord_dtl.line_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.oe_ord_dtl.line_nbr IS 'The line number on the sales order.';


--
-- Name: COLUMN oe_ord_dtl.qty_ord; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.oe_ord_dtl.qty_ord IS 'The quantity ordered in SELL_UM';


--
-- Name: COLUMN oe_ord_dtl.sell_um; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.oe_ord_dtl.sell_um IS 'ANSI X.12 unit of measure associated with the quantity ordered.';


--
-- Name: COLUMN oe_ord_dtl.rqst_dt; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.oe_ord_dtl.rqst_dt IS 'The date the customer requests the item to be shipped.';


--
-- Name: COLUMN oe_ord_dtl.tie_cd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.oe_ord_dtl.tie_cd IS 'The tie code from the order line.';


--
-- Name: COLUMN oe_ord_dtl.line_stat_id; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.oe_ord_dtl.line_stat_id IS 'O-Open, C-Closed, X-Cancelled';


--
-- Name: COLUMN oe_ord_dtl.item_cd_cust; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.oe_ord_dtl.item_cd_cust IS 'The part number the customer uses to identify this part.';


--
-- Name: COLUMN oe_ord_dtl.ut_user_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.oe_ord_dtl.ut_user_nbr IS 'Surrogate primary key for UT_USER';


--
-- Name: COLUMN oe_ord_dtl.ship_via_cd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.oe_ord_dtl.ship_via_cd IS 'The shipment method, identifies the carrier and priority.';


--
-- Name: COLUMN oe_ord_dtl.cust_bin_cd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.oe_ord_dtl.cust_bin_cd IS 'The customer bin for which the inventory was destined.';


--
-- Name: COLUMN oe_ord_dtl.cust_line_cd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.oe_ord_dtl.cust_line_cd IS 'The line number from the customer purchase order.';


--
-- Name: COLUMN oe_ord_dtl.contract_cd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.oe_ord_dtl.contract_cd IS 'The contract code, from the order detail line under which the goods were purchased.';


--
-- Name: COLUMN oe_ord_dtl.qty_ship; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.oe_ord_dtl.qty_ship IS 'the quantity shipped for this invoice line in the stock keeping unit of measure.';


--
-- Name: COLUMN oe_ord_dtl.rev_lvl; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.oe_ord_dtl.rev_lvl IS 'The revision level of a SKU required to satisfy sourcing in advanced planning.';


--
-- Name: COLUMN oe_ord_dtl.ship_from_facility; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.oe_ord_dtl.ship_from_facility IS 'The facility from which this order line should preferably be shipped.';


--
-- Name: aps_alloc_oo_sum; Type: VIEW; Schema: aerodemo; Owner: jjs
--

CREATE VIEW aerodemo.aps_alloc_oo_sum AS
 SELECT od.oe_ord_dtl_nbr,
    oh.sum_alloc_qty_oh,
    oh.max_avail_dt_oh,
    po.sum_alloc_qty_po,
    po.max_avail_dt_po,
    wo.sum_alloc_qty_wo,
    wo.max_avail_dt_wo,
    GREATEST(oh.max_avail_dt_oh, po.max_avail_dt_po, wo.max_avail_dt_wo) AS max_avail_dt,
    ((COALESCE(oh.sum_alloc_qty_oh, (0)::numeric) + COALESCE(po.sum_alloc_qty_po, (0)::numeric)) + COALESCE(wo.sum_alloc_qty_wo, (0)::numeric)) AS alloc_qty,
    LEAST(oh.facility_rqst, po.facility_rqst, wo.facility_rqst) AS facility_rqst,
    od.prom_dt_curr,
    od.org_nbr_mfr_rqst,
    od.org_nbr_cust,
    od.aps_src_rule_set_nbr,
    (od.qty_ord - COALESCE(od.qty_ship, (0)::numeric)) AS alloc_rqst_qty,
    od.item_nbr_rqst
   FROM (((aerodemo.oe_ord_dtl od
     LEFT JOIN aerodemo.aps_alloc_onhand_oo_sum oh ON ((od.oe_ord_dtl_nbr = oh.oe_ord_dtl_nbr)))
     LEFT JOIN aerodemo.aps_alloc_po_oo_sum po ON ((od.oe_ord_dtl_nbr = po.oe_ord_dtl_nbr)))
     LEFT JOIN aerodemo.aps_alloc_wo_oo_sum wo ON ((od.oe_ord_dtl_nbr = wo.oe_ord_dtl_nbr)))
  WHERE ((od.line_stat_id)::text = 'O'::text);


ALTER TABLE aerodemo.aps_alloc_oo_sum OWNER TO jjs;

--
-- Name: aps_alloc_po_ss; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.aps_alloc_po_ss (
    aps_alloc_po_ss_nbr integer NOT NULL,
    item_nbr integer NOT NULL,
    fc_item_mast_nbr integer NOT NULL,
    po_line_dtl_nbr integer NOT NULL,
    facility_act character varying(16) NOT NULL,
    aps_sply_sub_pool_nbr integer,
    alloc_qty numeric(13,5) NOT NULL,
    alloc_type_id character varying(1) DEFAULT 'U'::character varying NOT NULL,
    item_nbr_rqst integer NOT NULL,
    wh_facility_trans_replen_nbr integer,
    CONSTRAINT sys_c0017519 CHECK ((facility_act IS NOT NULL)),
    CONSTRAINT sys_c0017520 CHECK ((alloc_qty IS NOT NULL)),
    CONSTRAINT sys_c0017521 CHECK ((alloc_type_id IS NOT NULL)),
    CONSTRAINT sys_c0017522 CHECK ((fc_item_mast_nbr IS NOT NULL)),
    CONSTRAINT sys_c0017523 CHECK ((po_line_dtl_nbr IS NOT NULL))
);


ALTER TABLE aerodemo.aps_alloc_po_ss OWNER TO jjs;

--
-- Name: COLUMN aps_alloc_po_ss.alloc_type_id; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_alloc_po_ss.alloc_type_id IS 'R-Reuested for Bind,
		B_Bound Allocation, U-Unbound Allocation';


--
-- Name: aps_alloc_replen_fc; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.aps_alloc_replen_fc (
    aps_alloc_replen_fc_nbr integer NOT NULL,
    item_nbr_rqst integer NOT NULL,
    fc_fcst_nbr integer,
    po_line_dtl_nbr integer,
    facility_rqst character varying(16),
    facility_act character varying(16),
    subst_id character varying(1),
    alloc_qty numeric(13,5),
    alloc_type_id character varying(1),
    wh_facility_trans_replen_nbr integer,
    fc_item_mast_nbr integer,
    fcst_dt timestamp without time zone,
    aps_sply_sub_pool_nbr integer
);


ALTER TABLE aerodemo.aps_alloc_replen_fc OWNER TO jjs;

--
-- Name: COLUMN aps_alloc_replen_fc.fc_item_mast_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_alloc_replen_fc.fc_item_mast_nbr IS 'Surrogate primary key for FC_ITEM_MAST.';


--
-- Name: aps_alloc_replen_ss; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.aps_alloc_replen_ss (
    aps_alloc_replen_ss_nbr integer NOT NULL,
    item_nbr_rqst integer NOT NULL,
    fc_item_mast_nbr integer,
    po_line_dtl_nbr integer,
    facility_rqst character varying(16),
    facility_act character varying(16),
    subst_id character varying(1),
    alloc_qty numeric(13,5),
    alloc_type_id character varying(1),
    wh_facility_trans_replen_nbr integer,
    aps_sply_sub_pool_nbr integer
);


ALTER TABLE aerodemo.aps_alloc_replen_ss OWNER TO jjs;

--
-- Name: COLUMN aps_alloc_replen_ss.fc_item_mast_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_alloc_replen_ss.fc_item_mast_nbr IS 'Surrogate primary key for FC_ITEM_MAST.';


--
-- Name: aps_alloc_replen_wo; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.aps_alloc_replen_wo (
    aps_alloc_replen_wo_nbr integer NOT NULL,
    item_nbr_rqst integer NOT NULL,
    wo_dtl_nbr integer,
    po_line_dtl_nbr integer,
    facility_rqst character varying(16),
    facility_act character varying(16),
    alloc_qty numeric(13,5),
    alloc_type_id character varying(1),
    wh_facility_trans_replen_nbr integer,
    aps_sply_sub_pool_nbr integer
);


ALTER TABLE aerodemo.aps_alloc_replen_wo OWNER TO jjs;

--
-- Name: aps_alloc_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.aps_alloc_seq
    START WITH 237918883
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.aps_alloc_seq OWNER TO jjs;

--
-- Name: aps_alloc_wo_fc; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.aps_alloc_wo_fc (
    aps_alloc_wo_fc_nbr integer NOT NULL,
    item_nbr_rqst integer NOT NULL,
    wo_hdr_nbr integer,
    fc_fcst_nbr integer,
    facility_rqst character varying(16),
    facility_act character varying(16),
    alloc_qty numeric(13,5),
    alloc_type_id character varying(1),
    wh_facility_trans_wo_nbr integer,
    fc_item_mast_nbr integer,
    fcst_dt timestamp without time zone,
    aps_sply_sub_pool_nbr integer
);


ALTER TABLE aerodemo.aps_alloc_wo_fc OWNER TO jjs;

--
-- Name: COLUMN aps_alloc_wo_fc.wo_hdr_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_alloc_wo_fc.wo_hdr_nbr IS 'The surrogate primary key for WO_HDR.';


--
-- Name: COLUMN aps_alloc_wo_fc.fc_item_mast_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_alloc_wo_fc.fc_item_mast_nbr IS 'Surrogate primary key for FC_ITEM_MAST.';


--
-- Name: aps_alloc_wo_ss; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.aps_alloc_wo_ss (
    aps_alloc_wo_ss_nbr integer NOT NULL,
    item_nbr_rqst integer NOT NULL,
    wo_hdr_nbr integer,
    fc_item_mast_nbr integer,
    facility_rqst character varying(16),
    facility_act character varying(16),
    alloc_qty numeric(13,5),
    alloc_type_id character varying(1),
    wh_facility_trans_wo_nbr integer,
    aps_sply_sub_pool_nbr integer
);


ALTER TABLE aerodemo.aps_alloc_wo_ss OWNER TO jjs;

--
-- Name: COLUMN aps_alloc_wo_ss.wo_hdr_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_alloc_wo_ss.wo_hdr_nbr IS 'The surrogate primary key for WO_HDR.';


--
-- Name: COLUMN aps_alloc_wo_ss.fc_item_mast_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_alloc_wo_ss.fc_item_mast_nbr IS 'Surrogate primary key for FC_ITEM_MAST.';


--
-- Name: aps_alloc_wo_wo; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.aps_alloc_wo_wo (
    aps_alloc_wo_wo_nbr integer NOT NULL,
    item_nbr_rqst integer NOT NULL,
    wo_hdr_nbr integer,
    wo_dtl_nbr integer,
    facility_rqst character varying(16),
    facility_act character varying(16),
    alloc_qty numeric(13,5),
    alloc_type_id character varying(1),
    wh_facility_trans_wo_nbr integer,
    aps_sply_sub_pool_nbr integer
);


ALTER TABLE aerodemo.aps_alloc_wo_wo OWNER TO jjs;

--
-- Name: ic_bin; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.ic_bin (
    bin_nbr integer NOT NULL,
    facility character varying(16) NOT NULL,
    bin_cd character varying(16) NOT NULL,
    pick_flg character varying(1) NOT NULL,
    pack_station_flg character varying(1) NOT NULL,
    inspect_flg character varying(1) NOT NULL,
    bin_stat_cd character varying(1),
    walk_seq integer,
    ut_user_nbr integer NOT NULL,
    last_mod_dt timestamp without time zone NOT NULL,
    pick_ease smallint,
    delete_when_empty_flg character varying(1) NOT NULL,
    put_away_flg character varying(1) NOT NULL,
    mrb_flg character varying(1) NOT NULL,
    wh_whse_zone_nbr integer,
    work_station_flg character varying(1) NOT NULL,
    transit_bin_flg character varying(1) NOT NULL,
    bin_consume_seq integer,
    CONSTRAINT sys_c0015156 CHECK (((pick_ease >= 1) AND (pick_ease <= 9))),
    CONSTRAINT sys_c0015157 CHECK (((delete_when_empty_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0015158 CHECK (((put_away_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0015159 CHECK (((mrb_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0015160 CHECK (((work_station_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0015161 CHECK (((transit_bin_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0015162 CHECK (((pick_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0015163 CHECK (((pack_station_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0015164 CHECK (((inspect_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0016615 CHECK (((pick_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0016616 CHECK (((pack_station_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0016617 CHECK (((inspect_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0016618 CHECK (((pick_ease >= 1) AND (pick_ease <= 9))),
    CONSTRAINT sys_c0016619 CHECK (((delete_when_empty_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0016620 CHECK (((put_away_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0016621 CHECK (((mrb_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0016622 CHECK (((work_station_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0016623 CHECK (((transit_bin_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text])))
);


ALTER TABLE aerodemo.ic_bin OWNER TO jjs;

--
-- Name: COLUMN ic_bin.facility; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_bin.facility IS 'The facility (e.g. warehouse) in which this inventory is located.';


--
-- Name: COLUMN ic_bin.bin_cd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_bin.bin_cd IS 'The identifier for the location within the facility for this inventory.';


--
-- Name: COLUMN ic_bin.ut_user_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_bin.ut_user_nbr IS 'Surrogate primary key for UT_USER';


--
-- Name: ic_item_loc; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.ic_item_loc (
    ic_item_loc_nbr integer NOT NULL,
    lot_nbr integer NOT NULL,
    bin_nbr integer NOT NULL,
    avail_dt timestamp without time zone,
    ut_user_nbr integer NOT NULL,
    last_mod_dt timestamp without time zone NOT NULL,
    aps_sply_sub_pool_nbr integer NOT NULL,
    box_fix_flg character varying(1) NOT NULL,
    CONSTRAINT sys_c0015224 CHECK (((box_fix_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0015915 CHECK (((box_fix_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0015916 CHECK (((box_fix_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text])))
);


ALTER TABLE aerodemo.ic_item_loc OWNER TO jjs;

--
-- Name: COLUMN ic_item_loc.lot_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_item_loc.lot_nbr IS 'The lot which was shipped, a foreign key back to the primary surrogate key in ic_lot_mast.';


--
-- Name: COLUMN ic_item_loc.ut_user_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_item_loc.ut_user_nbr IS 'Surrogate primary key for UT_USER';


--
-- Name: COLUMN ic_item_loc.aps_sply_sub_pool_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_item_loc.aps_sply_sub_pool_nbr IS 'a foreign key back to the primary key for the supply sub pool';


--
-- Name: ic_item_loc_box; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.ic_item_loc_box (
    ic_item_loc_nbr integer NOT NULL,
    box_cd character varying(20) NOT NULL,
    box_qty numeric(12,5),
    box_stat_id character varying(3) NOT NULL,
    mfr_serial_cd character varying(20),
    serial_cd character varying(20),
    loc_confirm_rqst_dt timestamp without time zone,
    loc_confirm_act_dt timestamp without time zone,
    ut_user_nbr_loc_confirm integer,
    qty_confirm_rqst_dt timestamp without time zone,
    qty_confirm_act_dt timestamp without time zone,
    ut_user_nbr_qty_confirm integer,
    qty_confirm_rqst_prty smallint
);


ALTER TABLE aerodemo.ic_item_loc_box OWNER TO jjs;

--
-- Name: ic_lot_mast; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.ic_lot_mast (
    item_nbr integer NOT NULL,
    lot_nbr integer NOT NULL,
    rev_lvl character varying(5),
    mfr_lot_cd character varying(20),
    po_ord_hdr_nbr integer,
    po_line_hdr_nbr integer,
    org_nbr_vnd integer NOT NULL,
    org_nbr_mfr integer,
    rcpt_dt timestamp without time zone,
    lot_cost_um character varying(3) NOT NULL,
    lot_cost numeric(13,6) NOT NULL,
    lot_cost_curr_cd character varying(3),
    lot_cost_denom numeric(13,6),
    lot_cost_curr_cd_denom character varying(3),
    lot_stat_id character varying(1) NOT NULL,
    mfr_date timestamp without time zone,
    lot_cre_comm character varying(200),
    recv_qty bigint NOT NULL,
    inspect_qty numeric(10,2),
    ut_user_nbr_inspect integer,
    accept_qty bigint,
    inspect_dt timestamp without time zone,
    rej_qty numeric(10,2),
    trd_flg character varying(1) NOT NULL,
    ut_user_nbr integer NOT NULL,
    last_mod_dt timestamp without time zone NOT NULL,
    item_cd_vnd character varying(50),
    cntry_cd_origin character varying(3),
    lot_nbr_orig integer NOT NULL,
    expire_dt timestamp without time zone,
    box_qty numeric(12,5),
    qty_on_hand_flg character varying(1) NOT NULL,
    reject_cd character varying(8),
    lot_cost_landed_orig numeric(17,6),
    lot_cost_landed_denom_orig numeric(17,6),
    lot_cost_landed_curr numeric(17,6),
    lot_cost_landed_denom_curr numeric(17,6),
    processed_for_ap_flg character varying(1) NOT NULL,
    lot_cd character varying(20),
    wo_hdr_nbr integer,
    wo_release_nbr integer,
    ut_user_nbr_recv integer,
    CONSTRAINT check_lot_stat_id CHECK (((lot_stat_id)::text = ANY (ARRAY[('G'::character varying)::text, ('X'::character varying)::text, ('I'::character varying)::text, ('C'::character varying)::text]))),
    CONSTRAINT sys_c0015377 CHECK (((trd_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0015380 CHECK (((qty_on_hand_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0015382 CHECK (((processed_for_ap_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0016512 CHECK (((trd_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0016513 CHECK (((qty_on_hand_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0016514 CHECK (((processed_for_ap_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0016515 CHECK (((trd_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0016516 CHECK (((qty_on_hand_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0016517 CHECK (((processed_for_ap_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text])))
);


ALTER TABLE aerodemo.ic_lot_mast OWNER TO jjs;

--
-- Name: COLUMN ic_lot_mast.item_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_lot_mast.item_nbr IS 'Product identifier, reference to item master (IC_ITEM_MAST.ITEM_NBR)';


--
-- Name: COLUMN ic_lot_mast.lot_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_lot_mast.lot_nbr IS 'The lot which was shipped, a foreign key back to the primary surrogate key in ic_lot_mast.';


--
-- Name: COLUMN ic_lot_mast.rev_lvl; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_lot_mast.rev_lvl IS 'The revision level of the part from the lot master or ic_multiple_cert_rev_lvl.';


--
-- Name: COLUMN ic_lot_mast.mfr_lot_cd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_lot_mast.mfr_lot_cd IS 'The manufacturer lot code from the lot master.';


--
-- Name: COLUMN ic_lot_mast.org_nbr_vnd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_lot_mast.org_nbr_vnd IS 'The organization number of the vendor from whom the inventory was purchased.';


--
-- Name: COLUMN ic_lot_mast.org_nbr_mfr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_lot_mast.org_nbr_mfr IS 'The organization number of the manufacturer, copied from the lot master (ic_lot_mast).';


--
-- Name: COLUMN ic_lot_mast.rcpt_dt; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_lot_mast.rcpt_dt IS 'The date this inventory was received.';


--
-- Name: COLUMN ic_lot_mast.ut_user_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_lot_mast.ut_user_nbr IS 'Surrogate primary key for UT_USER';


--
-- Name: COLUMN ic_lot_mast.wo_hdr_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_lot_mast.wo_hdr_nbr IS 'The surrogate primary key for WO_HDR.';


--
-- Name: COLUMN ic_lot_mast.wo_release_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_lot_mast.wo_release_nbr IS 'Surrogate primary key for WO_RELEASE_NBR';


--
-- Name: aps_avail_onhand_dtl; Type: VIEW; Schema: aerodemo; Owner: jjs
--

CREATE VIEW aerodemo.aps_avail_onhand_dtl AS
 SELECT ib.facility,
    iil.aps_sply_sub_pool_nbr,
    ilm.org_nbr_mfr,
    ilm.org_nbr_vnd,
    iil.lot_nbr,
    ilm.lot_cost_um AS lot_um,
    ilm.item_nbr,
    date_trunc('day'::text, COALESCE(iil.avail_dt, ('now'::text)::timestamp without time zone)) AS avail_dt,
    iilb.box_qty AS onhand_qty,
    ilm.rev_lvl,
    ilm.lot_nbr AS pk_supply,
    ((((((iil.lot_nbr || '-'::text) || iil.aps_sply_sub_pool_nbr) || '-'::text) || (ib.facility)::text) || '-'::text) || to_char(date_trunc('day'::text, COALESCE(iil.avail_dt, '2020-02-01 14:36:46.152325'::timestamp without time zone)), 'YYYYMMDD'::text)) AS sply_identifier,
    ilm.lot_cost,
    ilm.cntry_cd_origin,
    ilm.mfr_date,
    ilm.expire_dt,
    ilm.rcpt_dt,
        CASE
            WHEN (iil.avail_dt IS NULL) THEN 'F'::text
            ELSE 'P'::text
        END AS avail_dt_id
   FROM aerodemo.ic_lot_mast ilm,
    aerodemo.ic_item_loc iil,
    aerodemo.ic_bin ib,
    aerodemo.ic_item_loc_box iilb
  WHERE (((ilm.qty_on_hand_flg)::text = 'Y'::text) AND (iil.ic_item_loc_nbr = iilb.ic_item_loc_nbr) AND (iil.bin_nbr = ib.bin_nbr) AND (ilm.lot_nbr = iil.lot_nbr) AND ((iilb.box_stat_id)::text <> 'LST'::text));


ALTER TABLE aerodemo.aps_avail_onhand_dtl OWNER TO jjs;

--
-- Name: COLUMN aps_avail_onhand_dtl.facility; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_avail_onhand_dtl.facility IS 'The facility (e.g. warehouse) in which this inventory is located.';


--
-- Name: COLUMN aps_avail_onhand_dtl.aps_sply_sub_pool_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_avail_onhand_dtl.aps_sply_sub_pool_nbr IS 'a foreign key back to the primary key for the supply sub pool';


--
-- Name: COLUMN aps_avail_onhand_dtl.org_nbr_mfr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_avail_onhand_dtl.org_nbr_mfr IS 'The organization number of the manufacturer, copied from the lot master (ic_lot_mast).';


--
-- Name: COLUMN aps_avail_onhand_dtl.org_nbr_vnd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_avail_onhand_dtl.org_nbr_vnd IS 'The organization number of the vendor from whom the inventory was purchased.';


--
-- Name: COLUMN aps_avail_onhand_dtl.lot_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_avail_onhand_dtl.lot_nbr IS 'The lot which was shipped, a foreign key back to the primary surrogate key in ic_lot_mast.';


--
-- Name: COLUMN aps_avail_onhand_dtl.item_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_avail_onhand_dtl.item_nbr IS 'Product identifier, reference to item master (IC_ITEM_MAST.ITEM_NBR)';


--
-- Name: COLUMN aps_avail_onhand_dtl.rev_lvl; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_avail_onhand_dtl.rev_lvl IS 'The revision level of the onhand SKU';


--
-- Name: COLUMN aps_avail_onhand_dtl.rcpt_dt; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_avail_onhand_dtl.rcpt_dt IS 'The date this inventory was received.';


--
-- Name: aps_avail_onhand; Type: VIEW; Schema: aerodemo; Owner: jjs
--

CREATE VIEW aerodemo.aps_avail_onhand AS
 SELECT aps_avail_onhand_dtl.facility,
    aps_avail_onhand_dtl.aps_sply_sub_pool_nbr,
    aps_avail_onhand_dtl.org_nbr_mfr,
    aps_avail_onhand_dtl.org_nbr_vnd,
    aps_avail_onhand_dtl.lot_nbr,
    aps_avail_onhand_dtl.lot_um,
    aps_avail_onhand_dtl.item_nbr,
    aps_avail_onhand_dtl.avail_dt,
    sum(aps_avail_onhand_dtl.onhand_qty) AS gross_avail_qty,
    aps_avail_onhand_dtl.rev_lvl,
    aps_avail_onhand_dtl.pk_supply,
    aps_avail_onhand_dtl.sply_identifier,
    aps_avail_onhand_dtl.lot_cost,
    aps_avail_onhand_dtl.cntry_cd_origin,
    aps_avail_onhand_dtl.mfr_date,
    aps_avail_onhand_dtl.expire_dt,
    aps_avail_onhand_dtl.rcpt_dt,
    aps_avail_onhand_dtl.avail_dt_id
   FROM aerodemo.aps_avail_onhand_dtl
  GROUP BY aps_avail_onhand_dtl.facility, aps_avail_onhand_dtl.aps_sply_sub_pool_nbr, aps_avail_onhand_dtl.org_nbr_mfr, aps_avail_onhand_dtl.org_nbr_vnd, aps_avail_onhand_dtl.lot_nbr, aps_avail_onhand_dtl.lot_um, aps_avail_onhand_dtl.item_nbr, aps_avail_onhand_dtl.avail_dt, aps_avail_onhand_dtl.rev_lvl, aps_avail_onhand_dtl.pk_supply, aps_avail_onhand_dtl.sply_identifier, aps_avail_onhand_dtl.lot_cost, aps_avail_onhand_dtl.cntry_cd_origin, aps_avail_onhand_dtl.mfr_date, aps_avail_onhand_dtl.expire_dt, aps_avail_onhand_dtl.rcpt_dt, aps_avail_onhand_dtl.avail_dt_id;


ALTER TABLE aerodemo.aps_avail_onhand OWNER TO jjs;

--
-- Name: COLUMN aps_avail_onhand.facility; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_avail_onhand.facility IS 'The facility (e.g. warehouse) in which this inventory is located.';


--
-- Name: COLUMN aps_avail_onhand.aps_sply_sub_pool_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_avail_onhand.aps_sply_sub_pool_nbr IS 'a foreign key back to the primary key for the supply sub pool';


--
-- Name: COLUMN aps_avail_onhand.org_nbr_mfr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_avail_onhand.org_nbr_mfr IS 'The organization number of the manufacturer, copied from the lot master (ic_lot_mast).';


--
-- Name: COLUMN aps_avail_onhand.org_nbr_vnd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_avail_onhand.org_nbr_vnd IS 'The organization number of the vendor from whom the inventory was purchased.';


--
-- Name: COLUMN aps_avail_onhand.lot_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_avail_onhand.lot_nbr IS 'The lot which was shipped, a foreign key back to the primary surrogate key in ic_lot_mast.';


--
-- Name: COLUMN aps_avail_onhand.item_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_avail_onhand.item_nbr IS 'Product identifier, reference to item master (IC_ITEM_MAST.ITEM_NBR)';


--
-- Name: COLUMN aps_avail_onhand.rev_lvl; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_avail_onhand.rev_lvl IS 'The revision level of a SKU required to satisfy sourcing in advanced planning.';


--
-- Name: COLUMN aps_avail_onhand.rcpt_dt; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_avail_onhand.rcpt_dt IS 'The date this inventory was received.';


--
-- Name: aps_sply_sub_pool; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.aps_sply_sub_pool (
    aps_sply_sub_pool_nbr integer NOT NULL,
    aps_sply_pool_cd character varying(20) NOT NULL,
    aps_sply_sub_pool_cd character varying(20) NOT NULL,
    sply_pool_type_id character varying(1) NOT NULL,
    aps_sply_sub_pool_descr character varying(60),
    org_nbr_vnd integer,
    ut_user_nbr integer NOT NULL,
    last_mod_dt timestamp without time zone NOT NULL,
    aps_sply_sub_pool_stat_id character varying(1) NOT NULL,
    avail_flg character varying(1) NOT NULL,
    CONSTRAINT assp_check_sply_pool_type_id CHECK (((sply_pool_type_id)::text = ANY (ARRAY[('B'::character varying)::text, ('C'::character varying)::text, ('G'::character varying)::text, ('V'::character varying)::text, ('U'::character varying)::text]))),
    CONSTRAINT sys_c0015000 CHECK (((sply_pool_type_id)::text = ANY (ARRAY[('C'::character varying)::text, ('B'::character varying)::text, ('G'::character varying)::text, ('V'::character varying)::text]))),
    CONSTRAINT sys_c0015005 CHECK (((aps_sply_sub_pool_stat_id)::text = ANY (ARRAY[('A'::character varying)::text, ('I'::character varying)::text]))),
    CONSTRAINT sys_c0015007 CHECK (((avail_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0015933 CHECK (((sply_pool_type_id)::text = ANY (ARRAY[('C'::character varying)::text, ('B'::character varying)::text, ('G'::character varying)::text, ('V'::character varying)::text]))),
    CONSTRAINT sys_c0015934 CHECK (((aps_sply_sub_pool_stat_id)::text = ANY (ARRAY[('A'::character varying)::text, ('I'::character varying)::text]))),
    CONSTRAINT sys_c0015935 CHECK (((sply_pool_type_id)::text = ANY (ARRAY[('C'::character varying)::text, ('B'::character varying)::text, ('G'::character varying)::text, ('V'::character varying)::text]))),
    CONSTRAINT sys_c0015936 CHECK (((aps_sply_sub_pool_stat_id)::text = ANY (ARRAY[('A'::character varying)::text, ('I'::character varying)::text])))
);


ALTER TABLE aerodemo.aps_sply_sub_pool OWNER TO jjs;

--
-- Name: COLUMN aps_sply_sub_pool.aps_sply_sub_pool_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_sply_sub_pool.aps_sply_sub_pool_nbr IS 'a foreign key back to the primary key for the supply sub pool';


--
-- Name: COLUMN aps_sply_sub_pool.org_nbr_vnd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_sply_sub_pool.org_nbr_vnd IS 'The organization number of the vendor from whom the inventory was purchased.';


--
-- Name: COLUMN aps_sply_sub_pool.ut_user_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_sply_sub_pool.ut_user_nbr IS 'Surrogate primary key for UT_USER';


--
-- Name: ic_item_mast; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.ic_item_mast (
    item_cd character varying(50) NOT NULL,
    item_nbr integer NOT NULL,
    item_descr character varying(50) NOT NULL,
    stk_um character varying(3) NOT NULL,
    sell_um character varying(3),
    std_cost numeric(17,6),
    list_price numeric(17,6),
    upc_cd character varying(20),
    ean character varying(50),
    qty_per_box integer,
    box_per_ctn integer,
    sls_qty_min integer,
    sls_qty_incr integer,
    replen_qty_min integer,
    replen_qty_incr integer,
    ic_category_nbr integer NOT NULL,
    non_stk_flg character varying(1) NOT NULL,
    ser_nbr_reqr_flg character varying(1) NOT NULL,
    mfr_ser_nbr_reqr_flg character varying(1) NOT NULL,
    inspect_reqr_flg character varying(1) NOT NULL,
    mfr_lot_ctrl_flg character varying(1) DEFAULT 'N'::character varying NOT NULL,
    kit_flg character varying(1) DEFAULT 'N'::character varying NOT NULL,
    price_chg_flg character varying(1) NOT NULL,
    ut_user_nbr integer DEFAULT 1 NOT NULL,
    last_mod_dt timestamp without time zone NOT NULL,
    sell_flg character varying(1),
    harmonized_cd character varying(15),
    plan_bucket_sz smallint,
    curr_cd character varying(3),
    reqr_mfr_flg character varying(1) NOT NULL,
    shelf_life_dy integer,
    lead_tm_dy integer,
    indiv_nbr_buyer integer,
    stat_id character varying(1) NOT NULL,
    pick_scan_id character varying(1) NOT NULL,
    intro_dt timestamp without time zone NOT NULL,
    split_at_bin_flg character varying(1) NOT NULL,
    label_nm_box character varying(20),
    ic_recv_rule_cd character varying(16),
    cycle_cnt_rule_cd character varying(16),
    fifo_dt_id character varying(1) NOT NULL,
    replen_type_id character varying(1) NOT NULL,
    item_nbr_primary integer,
    item_nbr_supersede integer,
    sched_qty_optimal integer,
    img_image_set_hdr_nbr integer,
    item_wght numeric(12,5),
    ctn_volume numeric(10,2),
    user_fld_1 character varying(20),
    user_fld_2 character varying(20),
    user_fld_3 character varying(20),
    user_fld_4 character varying(20),
    user_fld_5 character varying(20),
    user_fld_6 character varying(20),
    user_fld_7 character varying(20),
    user_fld_8 character varying(20),
    user_fld_9 character varying(20),
    CONSTRAINT iim_check_fifo_dt_id CHECK (((fifo_dt_id)::text = ANY (ARRAY[('R'::character varying)::text, ('M'::character varying)::text, ('E'::character varying)::text]))),
    CONSTRAINT iim_check_replen_type_id CHECK (((replen_type_id)::text = ANY (ARRAY[('B'::character varying)::text, ('M'::character varying)::text, ('A'::character varying)::text, ('K'::character varying)::text, ('D'::character varying)::text]))),
    CONSTRAINT sys_c0015251 CHECK (((non_stk_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0015252 CHECK (((ser_nbr_reqr_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0015253 CHECK (((mfr_ser_nbr_reqr_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0015254 CHECK (((inspect_reqr_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0015255 CHECK (((mfr_lot_ctrl_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0015256 CHECK (((kit_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0015257 CHECK (((price_chg_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0015262 CHECK (((sell_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0015263 CHECK (((reqr_mfr_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0015264 CHECK (((stat_id)::text = ANY (ARRAY[('A'::character varying)::text, ('I'::character varying)::text, ('S'::character varying)::text]))),
    CONSTRAINT sys_c0015265 CHECK (((split_at_bin_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0015948 CHECK (((non_stk_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0015949 CHECK (((ser_nbr_reqr_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0015950 CHECK (((mfr_ser_nbr_reqr_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0015951 CHECK (((inspect_reqr_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0015952 CHECK (((mfr_lot_ctrl_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0015953 CHECK (((kit_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0015954 CHECK (((price_chg_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0015955 CHECK (((sell_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0015956 CHECK (((reqr_mfr_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0015957 CHECK (((stat_id)::text = ANY (ARRAY[('A'::character varying)::text, ('I'::character varying)::text, ('S'::character varying)::text]))),
    CONSTRAINT sys_c0015958 CHECK (((split_at_bin_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text])))
);


ALTER TABLE aerodemo.ic_item_mast OWNER TO jjs;

--
-- Name: COLUMN ic_item_mast.item_cd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_item_mast.item_cd IS 'The primary product code of the selling institution for this part.';


--
-- Name: COLUMN ic_item_mast.item_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_item_mast.item_nbr IS 'Product identifier, reference to item master (IC_ITEM_MAST.ITEM_NBR)';


--
-- Name: COLUMN ic_item_mast.item_descr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_item_mast.item_descr IS 'Description of product.';


--
-- Name: COLUMN ic_item_mast.stk_um; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_item_mast.stk_um IS 'ANSI X.12 stock keeping unit of measure.';


--
-- Name: COLUMN ic_item_mast.sell_um; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_item_mast.sell_um IS 'ANSI X.12 unit of measure associated with the selling_qty';


--
-- Name: COLUMN ic_item_mast.std_cost; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_item_mast.std_cost IS 'Standard cost in base currency for the stock keeping unit of measure.';


--
-- Name: COLUMN ic_item_mast.price_chg_flg; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_item_mast.price_chg_flg IS '?????????????';


--
-- Name: COLUMN ic_item_mast.ut_user_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_item_mast.ut_user_nbr IS 'Surrogate primary key for UT_USER';


--
-- Name: COLUMN ic_item_mast.curr_cd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_item_mast.curr_cd IS 'The ANSI X.12 currency code associated with the unit cost.';


--
-- Name: COLUMN ic_item_mast.intro_dt; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_item_mast.intro_dt IS 'Introduction date.  The date the item became active.';


--
-- Name: COLUMN ic_item_mast.fifo_dt_id; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_item_mast.fifo_dt_id IS 'R-Receipt Date, M-Manufacture Date, E-Expiration Date';


--
-- Name: COLUMN ic_item_mast.replen_type_id; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_item_mast.replen_type_id IS 'B-Buy, M-Manufacture, A-Assemble, K-Kit, D-Do not Buy';


--
-- Name: na_org; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.na_org (
    org_nbr integer NOT NULL,
    org_nm character varying(60) NOT NULL,
    ut_user_nbr integer NOT NULL,
    last_mod_dt timestamp without time zone NOT NULL,
    org_web_site character varying(255),
    curr_cd_dflt character varying(3),
    org_cd character varying(15) NOT NULL,
    phn_nbr_dflt character varying(20),
    fax_nbr_dflt character varying(20),
    calendar character varying(6) NOT NULL,
    ut_locale_nbr integer
);


ALTER TABLE aerodemo.na_org OWNER TO jjs;

--
-- Name: COLUMN na_org.org_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.na_org.org_nbr IS 'Surrogate primary key for ORG_NBR';


--
-- Name: COLUMN na_org.ut_user_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.na_org.ut_user_nbr IS 'Surrogate primary key for UT_USER';


--
-- Name: COLUMN na_org.curr_cd_dflt; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.na_org.curr_cd_dflt IS 'The default currency code that the customer will use when placing orders.';


--
-- Name: COLUMN na_org.phn_nbr_dflt; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.na_org.phn_nbr_dflt IS 'Default telephone number for this entity.';


--
-- Name: COLUMN na_org.calendar; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.na_org.calendar IS 'The business calendar associated with this date.';


--
-- Name: aps_avail_onhand_dtl_vw; Type: VIEW; Schema: aerodemo; Owner: jjs
--

CREATE VIEW aerodemo.aps_avail_onhand_dtl_vw AS
 SELECT aaod.facility,
    assp.aps_sply_pool_cd,
    assp.aps_sply_sub_pool_cd,
    assp.sply_pool_type_id,
    om.org_cd,
    aaod.org_nbr_vnd,
    aaod.lot_nbr,
    aaod.lot_um,
    iim.item_cd,
    aaod.item_nbr,
    aaod.avail_dt,
    aaod.onhand_qty,
    aaod.rev_lvl,
    aaod.pk_supply,
    aaod.lot_cost,
    aaod.cntry_cd_origin,
    aaod.mfr_date,
    aaod.expire_dt,
    aaod.rcpt_dt,
    aaod.avail_dt_id
   FROM aerodemo.aps_avail_onhand_dtl aaod,
    aerodemo.aps_sply_sub_pool assp,
    aerodemo.na_org om,
    aerodemo.ic_item_mast iim
  WHERE ((aaod.aps_sply_sub_pool_nbr = assp.aps_sply_sub_pool_nbr) AND (om.org_nbr = aaod.org_nbr_mfr) AND (iim.item_nbr = aaod.item_nbr));


ALTER TABLE aerodemo.aps_avail_onhand_dtl_vw OWNER TO jjs;

--
-- Name: ic_multiple_cert; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.ic_multiple_cert (
    lot_nbr integer NOT NULL,
    item_nbr integer NOT NULL,
    rev_lvl character varying(5),
    inspected_flg character varying(1) NOT NULL,
    ut_user_nbr integer NOT NULL,
    last_mod_dt timestamp without time zone NOT NULL,
    CONSTRAINT sys_c0015390 CHECK (((inspected_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0016187 CHECK (((inspected_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0016188 CHECK (((inspected_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text])))
);


ALTER TABLE aerodemo.ic_multiple_cert OWNER TO jjs;

--
-- Name: COLUMN ic_multiple_cert.lot_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_multiple_cert.lot_nbr IS 'The lot which was shipped, a foreign key back to the primary surrogate key in ic_lot_mast.';


--
-- Name: COLUMN ic_multiple_cert.item_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_multiple_cert.item_nbr IS 'Product identifier, reference to item master (IC_ITEM_MAST.ITEM_NBR)';


--
-- Name: COLUMN ic_multiple_cert.rev_lvl; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_multiple_cert.rev_lvl IS 'The revision level of the part from the lot master or ic_multiple_cert_rev_lvl.';


--
-- Name: COLUMN ic_multiple_cert.ut_user_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_multiple_cert.ut_user_nbr IS 'Surrogate primary key for UT_USER';


--
-- Name: aps_avail_onhand_dtl_multi_vw; Type: VIEW; Schema: aerodemo; Owner: jjs
--

CREATE VIEW aerodemo.aps_avail_onhand_dtl_multi_vw AS
 SELECT aps_avail_onhand_dtl_vw.facility,
    'N'::text AS multi_cert_flg,
    aps_avail_onhand_dtl_vw.aps_sply_pool_cd,
    aps_avail_onhand_dtl_vw.aps_sply_sub_pool_cd,
    aps_avail_onhand_dtl_vw.sply_pool_type_id,
    aps_avail_onhand_dtl_vw.org_cd,
    aps_avail_onhand_dtl_vw.org_nbr_vnd,
    aps_avail_onhand_dtl_vw.lot_nbr,
    aps_avail_onhand_dtl_vw.lot_um,
    aps_avail_onhand_dtl_vw.item_cd,
    aps_avail_onhand_dtl_vw.item_nbr,
    aps_avail_onhand_dtl_vw.avail_dt,
    aps_avail_onhand_dtl_vw.onhand_qty,
    aps_avail_onhand_dtl_vw.rev_lvl,
    aps_avail_onhand_dtl_vw.pk_supply,
    aps_avail_onhand_dtl_vw.lot_cost,
    aps_avail_onhand_dtl_vw.cntry_cd_origin,
    aps_avail_onhand_dtl_vw.mfr_date,
    aps_avail_onhand_dtl_vw.expire_dt,
    aps_avail_onhand_dtl_vw.rcpt_dt,
    aps_avail_onhand_dtl_vw.avail_dt_id
   FROM aerodemo.aps_avail_onhand_dtl_vw
UNION
 SELECT aaodv.facility,
    'Y'::text AS multi_cert_flg,
    aaodv.aps_sply_pool_cd,
    aaodv.aps_sply_sub_pool_cd,
    aaodv.sply_pool_type_id,
    aaodv.org_cd,
    aaodv.org_nbr_vnd,
    aaodv.lot_nbr,
    aaodv.lot_um,
    aaodv.item_cd,
    aaodv.item_nbr,
    aaodv.avail_dt,
    aaodv.onhand_qty,
    aaodv.rev_lvl,
    aaodv.pk_supply,
    aaodv.lot_cost,
    aaodv.cntry_cd_origin,
    aaodv.mfr_date,
    aaodv.expire_dt,
    aaodv.rcpt_dt,
    aaodv.avail_dt_id
   FROM aerodemo.aps_avail_onhand_dtl_vw aaodv,
    aerodemo.ic_multiple_cert imc,
    aerodemo.ic_item_mast iim
  WHERE ((imc.lot_nbr = aaodv.lot_nbr) AND (iim.item_nbr = aaodv.item_nbr));


ALTER TABLE aerodemo.aps_avail_onhand_dtl_multi_vw OWNER TO jjs;

--
-- Name: aps_avail_onhand_vw; Type: VIEW; Schema: aerodemo; Owner: jjs
--

CREATE VIEW aerodemo.aps_avail_onhand_vw AS
 SELECT a.facility,
    a.aps_sply_sub_pool_nbr,
    a.org_nbr_mfr,
    mfr.org_cd AS org_cd_mfr,
    a.org_nbr_vnd,
    vorg.org_cd AS org_cd_vend,
    a.lot_nbr,
    a.lot_um,
    a.item_nbr,
    iim.item_cd,
    iim.item_descr,
    a.avail_dt,
    a.gross_avail_qty,
    a.rev_lvl,
    a.pk_supply,
    a.sply_identifier,
    a.lot_cost,
    a.cntry_cd_origin,
    a.mfr_date,
    a.expire_dt,
    a.rcpt_dt,
    a.avail_dt_id
   FROM aerodemo.aps_avail_onhand a,
    aerodemo.ic_item_mast iim,
    aerodemo.na_org vorg,
    aerodemo.na_org mfr
  WHERE ((a.item_nbr = iim.item_nbr) AND (vorg.org_nbr = a.org_nbr_vnd) AND (mfr.org_nbr = a.org_nbr_mfr));


ALTER TABLE aerodemo.aps_avail_onhand_vw OWNER TO jjs;

--
-- Name: po_line_hdr; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.po_line_hdr (
    po_line_hdr_nbr integer NOT NULL,
    po_ord_hdr_nbr integer NOT NULL,
    po_line_nbr smallint NOT NULL,
    item_nbr integer NOT NULL,
    replen_um character varying(3) NOT NULL,
    unit_cost numeric(17,6) NOT NULL,
    unit_cost_denom numeric(13,5) NOT NULL,
    rev_lvl character varying(5),
    org_nbr_mfr integer,
    line_stat_id character varying(1) NOT NULL,
    vndr_ord_line_cd character varying(3),
    cntry_cd_origin character varying(3),
    ut_user_nbr integer NOT NULL,
    last_mod_dt timestamp without time zone NOT NULL,
    enter_dt timestamp without time zone NOT NULL,
    item_cd_vnd character varying(50),
    cancel_cd character varying(8),
    cancel_dt timestamp without time zone,
    ut_user_nbr_cancel integer,
    lot_not_expire_before_dt timestamp without time zone,
    lot_manufacture_after_dt timestamp without time zone,
    replen_qty numeric(13,5) NOT NULL,
    replen_qty_stk_um numeric(13,5) NOT NULL,
    unit_cost_stk_um numeric(17,6),
    unit_cost_denom_stk_um numeric(17,6),
    po_close_reason_cd character varying(8),
    close_tm timestamp without time zone,
    ut_user_nbr_close integer,
    CONSTRAINT plh_check_line_stat_id CHECK (((line_stat_id)::text = ANY (ARRAY[('O'::character varying)::text, ('C'::character varying)::text, ('X'::character varying)::text])))
);


ALTER TABLE aerodemo.po_line_hdr OWNER TO jjs;

--
-- Name: COLUMN po_line_hdr.po_line_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.po_line_hdr.po_line_nbr IS 'Identifier for the line on the purchase order.';


--
-- Name: COLUMN po_line_hdr.item_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.po_line_hdr.item_nbr IS 'Product identifier, reference to item master (IC_ITEM_MAST.ITEM_NBR)';


--
-- Name: COLUMN po_line_hdr.replen_um; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.po_line_hdr.replen_um IS 'ANSI X.12 unit of measure.';


--
-- Name: COLUMN po_line_hdr.unit_cost; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.po_line_hdr.unit_cost IS 'Cost per unit in the replenishment unit of measure and currency.';


--
-- Name: COLUMN po_line_hdr.rev_lvl; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.po_line_hdr.rev_lvl IS 'The revision level of a SKU required to satisfy sourcing in advanced planning.';


--
-- Name: COLUMN po_line_hdr.org_nbr_mfr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.po_line_hdr.org_nbr_mfr IS 'The organization number of the manufacturer, copied from the lot master (ic_lot_mast).';


--
-- Name: COLUMN po_line_hdr.line_stat_id; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.po_line_hdr.line_stat_id IS 'O-Open, C-Closed, X-Cancelled';


--
-- Name: COLUMN po_line_hdr.ut_user_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.po_line_hdr.ut_user_nbr IS 'Surrogate primary key for UT_USER';


--
-- Name: COLUMN po_line_hdr.replen_qty; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.po_line_hdr.replen_qty IS 'Replenishment quantity in the replenishment unit of measure.';


--
-- Name: COLUMN po_line_hdr.unit_cost_stk_um; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.po_line_hdr.unit_cost_stk_um IS 'cost per unit in the base currency for the stock keeping unit of measure';


--
-- Name: COLUMN po_line_hdr.unit_cost_denom_stk_um; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.po_line_hdr.unit_cost_denom_stk_um IS 'cost per unit in the base currency for the stock keeping unit of measure';


--
-- Name: po_ord_hdr; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.po_ord_hdr (
    po_ord_hdr_nbr integer NOT NULL,
    po_cd character varying(20) NOT NULL,
    po_dt timestamp without time zone NOT NULL,
    org_nbr_vnd integer NOT NULL,
    addr_nbr_vnd integer NOT NULL,
    curr_cd character varying(3) NOT NULL,
    ship_to_addr_nbr_dflt integer NOT NULL,
    bill_to_addr_nbr integer NOT NULL,
    indiv_nbr_buy integer NOT NULL,
    next_po_line_nbr smallint NOT NULL,
    ord_stat_id character varying(1) NOT NULL,
    vndr_ord_cd character varying(20),
    term_cd character varying(10),
    fob_cd character varying(8),
    trd_flg character varying(1) NOT NULL,
    ut_user_nbr integer NOT NULL,
    last_mod_dt timestamp without time zone NOT NULL,
    ship_via_cd_dflt character varying(8) NOT NULL,
    cancel_cd character varying(8),
    cancel_dt timestamp without time zone,
    ut_user_nbr_cancel integer,
    indiv_nm_seller character varying(45),
    seller_phn_nbr character varying(20),
    seller_email_addr character varying(40),
    ack_flg character varying(1) NOT NULL,
    seller_fax_nbr character varying(20),
    transmit_flg character varying(1) NOT NULL,
    po_type_id character varying(1) NOT NULL,
    CONSTRAINT poh_check_po_type_id CHECK (((po_type_id)::text = ANY (ARRAY[('R'::character varying)::text, ('U'::character varying)::text]))),
    CONSTRAINT sys_c0015701 CHECK (((ord_stat_id)::text = ANY (ARRAY[('O'::character varying)::text, ('C'::character varying)::text, ('X'::character varying)::text]))),
    CONSTRAINT sys_c0015702 CHECK (((trd_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0015707 CHECK (((ack_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0015708 CHECK (((transmit_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0016471 CHECK (((ord_stat_id)::text = ANY (ARRAY[('O'::character varying)::text, ('C'::character varying)::text, ('X'::character varying)::text]))),
    CONSTRAINT sys_c0016472 CHECK (((trd_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0016473 CHECK (((ack_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0016474 CHECK (((transmit_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0016475 CHECK (((ord_stat_id)::text = ANY (ARRAY[('O'::character varying)::text, ('C'::character varying)::text, ('X'::character varying)::text]))),
    CONSTRAINT sys_c0016476 CHECK (((trd_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0016477 CHECK (((ack_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0016478 CHECK (((transmit_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text])))
);


ALTER TABLE aerodemo.po_ord_hdr OWNER TO jjs;

--
-- Name: COLUMN po_ord_hdr.po_cd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.po_ord_hdr.po_cd IS 'Legacy purchase order code, identifies the purchase order.';


--
-- Name: COLUMN po_ord_hdr.po_dt; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.po_ord_hdr.po_dt IS 'The date the purchase order was created.';


--
-- Name: COLUMN po_ord_hdr.org_nbr_vnd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.po_ord_hdr.org_nbr_vnd IS 'The organization number of the vendor from whom the inventory was purchased.';


--
-- Name: COLUMN po_ord_hdr.curr_cd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.po_ord_hdr.curr_cd IS 'The ANSI X.12 currency code associated with the unit cost.';


--
-- Name: COLUMN po_ord_hdr.ship_to_addr_nbr_dflt; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.po_ord_hdr.ship_to_addr_nbr_dflt IS 'Identifies the default ship to address for the customer.';


--
-- Name: COLUMN po_ord_hdr.term_cd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.po_ord_hdr.term_cd IS 'Payment terms code.';


--
-- Name: COLUMN po_ord_hdr.fob_cd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.po_ord_hdr.fob_cd IS 'Free on Board code.  Identifies when the customer takes ownership of this inventory.';


--
-- Name: COLUMN po_ord_hdr.ut_user_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.po_ord_hdr.ut_user_nbr IS 'Surrogate primary key for UT_USER';


--
-- Name: COLUMN po_ord_hdr.ship_via_cd_dflt; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.po_ord_hdr.ship_via_cd_dflt IS 'Identifier for default mechanism for shipping to this customer.';


--
-- Name: aps_avail_replen; Type: VIEW; Schema: aerodemo; Owner: jjs
--

CREATE VIEW aerodemo.aps_avail_replen AS
 SELECT (((((poh.po_cd)::text || '-'::text) || lpad(((plh.po_line_nbr)::character varying)::text, 3, '0'::text)) || '-'::text) || lpad(((pld.po_line_dtl_nbr)::character varying)::text, 8, '0'::text)) AS sply_identifier,
    plh.item_nbr,
    pld.facility,
    pld.aps_sply_sub_pool_nbr,
    plh.org_nbr_mfr,
    poh.org_nbr_vnd,
    COALESCE(pld.aps_avail_dt, pld.replen_curr_est_dt) AS avail_dt,
    (COALESCE(pld.sched_qty_stk_um, (0)::numeric) - COALESCE(pld.recv_qty_stk_um, (0)::numeric)) AS gross_avail_qty,
    plh.replen_um,
    plh.rev_lvl,
    pld.po_line_dtl_nbr,
    plh.unit_cost_stk_um,
    plh.cntry_cd_origin,
    plh.lot_manufacture_after_dt,
    plh.lot_not_expire_before_dt,
    pld.aps_avail_dt,
    plh.po_line_hdr_nbr
   FROM aerodemo.po_ord_hdr poh,
    aerodemo.po_line_hdr plh,
    aerodemo.po_line_dtl pld
  WHERE ((plh.po_ord_hdr_nbr = poh.po_ord_hdr_nbr) AND (pld.po_line_hdr_nbr = plh.po_line_hdr_nbr) AND ((plh.line_stat_id)::text = 'O'::text) AND ((COALESCE(pld.sched_qty, (0)::numeric) - COALESCE(pld.recv_qty, (0)::numeric)) > (0)::numeric) AND (pld.cancel_cd IS NULL));


ALTER TABLE aerodemo.aps_avail_replen OWNER TO jjs;

--
-- Name: COLUMN aps_avail_replen.item_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_avail_replen.item_nbr IS 'Product identifier, reference to item master (IC_ITEM_MAST.ITEM_NBR)';


--
-- Name: COLUMN aps_avail_replen.facility; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_avail_replen.facility IS 'The facility (e.g. warehouse) in which this inventory is to be received.';


--
-- Name: COLUMN aps_avail_replen.aps_sply_sub_pool_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_avail_replen.aps_sply_sub_pool_nbr IS 'a foreign key back to the primary key for the supply sub pool';


--
-- Name: COLUMN aps_avail_replen.org_nbr_mfr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_avail_replen.org_nbr_mfr IS 'The organization number of the manufacturer, copied from the lot master (ic_lot_mast).';


--
-- Name: COLUMN aps_avail_replen.org_nbr_vnd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_avail_replen.org_nbr_vnd IS 'The organization number of the vendor from whom the inventory was purchased.';


--
-- Name: COLUMN aps_avail_replen.replen_um; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_avail_replen.replen_um IS 'ANSI X.12 unit of measure.';


--
-- Name: COLUMN aps_avail_replen.rev_lvl; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_avail_replen.rev_lvl IS 'The revision level of a SKU that was ordered or is in manufacturing';


--
-- Name: COLUMN aps_avail_replen.unit_cost_stk_um; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_avail_replen.unit_cost_stk_um IS 'cost per unit in the base currency for the stock keeping unit of measure';


--
-- Name: aps_avail_wo; Type: VIEW; Schema: aerodemo; Owner: jjs
--

CREATE VIEW aerodemo.aps_avail_wo AS
 SELECT (woh.wo_hdr_nbr)::character varying AS sply_identifier,
    woh.item_nbr_rqst AS item_nbr,
    woh.facility,
    woh.aps_sply_sub_pool_nbr,
    woh.need_by_dt AS avail_dt,
    (woh.rqst_qty - COALESCE(woh.fill_qty, 0)) AS gross_avail_qty,
    woh.wo_um,
    woh.wo_hdr_nbr
   FROM aerodemo.wo_hdr woh
  WHERE ((woh.wo_stat_id)::text = 'O'::text);


ALTER TABLE aerodemo.aps_avail_wo OWNER TO jjs;

--
-- Name: COLUMN aps_avail_wo.item_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_avail_wo.item_nbr IS 'Product identifier, reference to item master (IC_ITEM_MAST.ITEM_NBR)';


--
-- Name: COLUMN aps_avail_wo.facility; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_avail_wo.facility IS 'The facility in which this work order will complete this item';


--
-- Name: COLUMN aps_avail_wo.aps_sply_sub_pool_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_avail_wo.aps_sply_sub_pool_nbr IS 'a foreign key back to the primary key for the supply sub pool';


--
-- Name: COLUMN aps_avail_wo.wo_hdr_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_avail_wo.wo_hdr_nbr IS 'The surrogate primary key for WO_HDR.';


--
-- Name: aps_ctl; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.aps_ctl (
    pipe_nm character varying(80),
    pipe_nm_synch character varying(80),
    lock_pick character varying(1),
    push_window_dy smallint,
    push_limit_cost integer,
    push_limit_pct smallint,
    pull_window_dy smallint,
    pull_limit_pct smallint,
    asynch_notify_pipe_nm character varying(80),
    effective_date timestamp without time zone
);


ALTER TABLE aerodemo.aps_ctl OWNER TO jjs;

--
-- Name: aps_dispatch_queue; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.aps_dispatch_queue (
    item_nbr integer NOT NULL,
    dispatch_time timestamp without time zone,
    plan_grp_nbr integer
);


ALTER TABLE aerodemo.aps_dispatch_queue OWNER TO jjs;

--
-- Name: COLUMN aps_dispatch_queue.item_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_dispatch_queue.item_nbr IS 'Product identifier, reference to item master (IC_ITEM_MAST.ITEM_NBR)';


--
-- Name: fc_fcst; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.fc_fcst (
    fc_fcst_nbr integer NOT NULL,
    fc_item_mast_nbr integer NOT NULL,
    cycle smallint NOT NULL,
    intvl smallint NOT NULL,
    raw_fcst numeric(17,5),
    adj_fcst numeric(17,5),
    fcst_consumed_qty numeric(8,4),
    fc_item_fcst_mdl_nbr integer,
    fcst_alloc_qty numeric(17,5),
    fc_fcst_dt timestamp without time zone NOT NULL
);


ALTER TABLE aerodemo.fc_fcst OWNER TO jjs;

--
-- Name: COLUMN fc_fcst.fc_item_mast_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.fc_fcst.fc_item_mast_nbr IS 'Surrogate primary key for FC_ITEM_MAST.';


--
-- Name: COLUMN fc_fcst.fc_item_fcst_mdl_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.fc_fcst.fc_item_fcst_mdl_nbr IS 'Surrogate primary key for';


--
-- Name: fc_item_mast; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.fc_item_mast (
    fc_item_mast_nbr integer NOT NULL,
    item_nbr integer NOT NULL,
    svc_lvl numeric(2,2),
    tot_lead_time bigint NOT NULL,
    safety_stk_min_prd numeric(3,1),
    safety_stk_max_prd numeric(3,1),
    safety_stk_min_unit numeric(17,6),
    safety_stk_max_unit numeric(17,6),
    replen_qty_min_unit integer,
    replen_qty_max_unit integer,
    replen_qty_min_prd numeric(4,1),
    replen_qty_max_prd numeric(4,1),
    store_alt_fcst_flg character varying(1),
    arch_alt_fcst_flg character varying(1),
    calendar character varying(6),
    fcst_mdl_grp character varying(8),
    stat_id character varying(1),
    aps_src_rule_set_nbr integer NOT NULL,
    safety_stk_adj integer,
    fcst_type_id character varying(1) NOT NULL,
    org_nbr_cust integer NOT NULL,
    rev_lvl character varying(5),
    org_nbr_mfr_rqst integer,
    fcst_grp character varying(8) NOT NULL,
    fc_item_mast_stat_id character varying(1) NOT NULL,
    fc_item_mast_descr character varying(30),
    safety_stk_alloc_qty integer,
    fcst_end_dt timestamp without time zone,
    fc_build_rate_grp_cd character varying(10),
    cust_ref_cd character varying(40),
    safety_stk_avail_to_sell character varying(1) NOT NULL,
    hard_alloc_fc_within_lead_tm character varying(1) NOT NULL,
    safety_stk_constrain numeric(10,2),
    descr character varying(50),
    replen_policy integer,
    fc_item_mast_nbr_replen_policy integer,
    facility character varying(16),
    trc_file_nm_absolute character varying(255),
    fc_item_alloc_policy_id character varying(1) DEFAULT 'F'::character varying NOT NULL,
    trc_fcst_flg character varying(1) DEFAULT 'N'::character varying,
    safety_stk_calc numeric(10,2),
    unit_cost_stk_um numeric(17,5),
    fcst_aggr_type_id character varying(1),
    CONSTRAINT check_fc_item_mast_stat_id CHECK (((stat_id)::text = ANY (ARRAY[('A'::character varying)::text, ('I'::character varying)::text]))),
    CONSTRAINT fim_check_alloc_policy_id CHECK (((fc_item_alloc_policy_id)::text = ANY (ARRAY[('F'::character varying)::text, ('S'::character varying)::text, ('B'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0015135 CHECK (((fcst_type_id)::text = ANY (ARRAY[('I'::character varying)::text, ('C'::character varying)::text, ('S'::character varying)::text]))),
    CONSTRAINT sys_c0015139 CHECK (((safety_stk_avail_to_sell)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0015140 CHECK (((hard_alloc_fc_within_lead_tm)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0016556 CHECK (((fcst_type_id)::text = ANY (ARRAY[('I'::character varying)::text, ('C'::character varying)::text, ('S'::character varying)::text]))),
    CONSTRAINT sys_c0016557 CHECK (((safety_stk_avail_to_sell)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0016558 CHECK (((hard_alloc_fc_within_lead_tm)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0016748 CHECK (((safety_stk_avail_to_sell)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0016749 CHECK (((hard_alloc_fc_within_lead_tm)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0016750 CHECK (((safety_stk_avail_to_sell)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0016751 CHECK (((hard_alloc_fc_within_lead_tm)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0016757 CHECK (((safety_stk_avail_to_sell)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0016758 CHECK (((hard_alloc_fc_within_lead_tm)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0016760 CHECK (((fcst_type_id)::text = ANY (ARRAY[('I'::character varying)::text, ('C'::character varying)::text, ('S'::character varying)::text]))),
    CONSTRAINT sys_c0016761 CHECK (((safety_stk_avail_to_sell)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0016762 CHECK (((hard_alloc_fc_within_lead_tm)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0016767 CHECK (((fcst_type_id)::text = ANY (ARRAY[('I'::character varying)::text, ('C'::character varying)::text, ('S'::character varying)::text]))),
    CONSTRAINT sys_c0016768 CHECK (((safety_stk_avail_to_sell)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0016769 CHECK (((hard_alloc_fc_within_lead_tm)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0016770 CHECK (((fcst_type_id)::text = ANY (ARRAY[('I'::character varying)::text, ('C'::character varying)::text, ('S'::character varying)::text]))),
    CONSTRAINT sys_c0016771 CHECK (((safety_stk_avail_to_sell)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0016772 CHECK (((hard_alloc_fc_within_lead_tm)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text])))
);


ALTER TABLE aerodemo.fc_item_mast OWNER TO jjs;

--
-- Name: COLUMN fc_item_mast.fc_item_mast_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.fc_item_mast.fc_item_mast_nbr IS 'Surrogate primary key.';


--
-- Name: COLUMN fc_item_mast.item_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.fc_item_mast.item_nbr IS 'The surrogate key for the associated sku, if applicable.';


--
-- Name: COLUMN fc_item_mast.safety_stk_min_prd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.fc_item_mast.safety_stk_min_prd IS 'The minimum number of periods of safety stock that should be maintained based on the selected forecast model.';


--
-- Name: COLUMN fc_item_mast.safety_stk_max_prd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.fc_item_mast.safety_stk_max_prd IS 'The maximum number of periods of safety stock that should be maintained based on the selected forecast model.';


--
-- Name: COLUMN fc_item_mast.safety_stk_min_unit; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.fc_item_mast.safety_stk_min_unit IS 'The minimum number of periods of safety stock that should be maintained based on the selected forecast model.';


--
-- Name: COLUMN fc_item_mast.safety_stk_max_unit; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.fc_item_mast.safety_stk_max_unit IS 'The maximum number of periods of safety stock that should be maintained based on the selected forecast model.';


--
-- Name: COLUMN fc_item_mast.replen_qty_min_prd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.fc_item_mast.replen_qty_min_prd IS 'The minimum periods of demand which should be replenished at one time.';


--
-- Name: COLUMN fc_item_mast.replen_qty_max_prd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.fc_item_mast.replen_qty_max_prd IS 'The maximu periods of demand which should be replenished at one time.';


--
-- Name: COLUMN fc_item_mast.store_alt_fcst_flg; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.fc_item_mast.store_alt_fcst_flg IS 'If ''Y'' then alternate forecasts that were evaluated are stored in the database.';


--
-- Name: COLUMN fc_item_mast.calendar; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.fc_item_mast.calendar IS 'The name of the calendar to be used for this entity.';


--
-- Name: COLUMN fc_item_mast.fcst_mdl_grp; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.fc_item_mast.fcst_mdl_grp IS 'The name of the forecast model group to be used for this entity.';


--
-- Name: COLUMN fc_item_mast.fcst_type_id; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.fc_item_mast.fcst_type_id IS 'H - History Aggregated Forecast, F - Forecast Aggregated Forecast';


--
-- Name: COLUMN fc_item_mast.org_nbr_cust; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.fc_item_mast.org_nbr_cust IS 'Surrogate key that identifies the customer associated with this forecasting entity.';


--
-- Name: COLUMN fc_item_mast.rev_lvl; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.fc_item_mast.rev_lvl IS 'The revision level of a SKU required to satisfy sourcing in advanced planning.';


--
-- Name: COLUMN fc_item_mast.fcst_grp; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.fc_item_mast.fcst_grp IS '???????????';


--
-- Name: COLUMN fc_item_mast.fc_item_mast_stat_id; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.fc_item_mast.fc_item_mast_stat_id IS '?????????????????';


--
-- Name: COLUMN fc_item_mast.fc_item_mast_descr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.fc_item_mast.fc_item_mast_descr IS 'Description of this forecasting entity.';


--
-- Name: COLUMN fc_item_mast.safety_stk_alloc_qty; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.fc_item_mast.safety_stk_alloc_qty IS '????????????????';


--
-- Name: COLUMN fc_item_mast.fc_build_rate_grp_cd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.fc_item_mast.fc_build_rate_grp_cd IS '????????????????';


--
-- Name: COLUMN fc_item_mast.cust_ref_cd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.fc_item_mast.cust_ref_cd IS '???????????????????';


--
-- Name: COLUMN fc_item_mast.safety_stk_avail_to_sell; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.fc_item_mast.safety_stk_avail_to_sell IS '??????????????????';


--
-- Name: COLUMN fc_item_mast.hard_alloc_fc_within_lead_tm; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.fc_item_mast.hard_alloc_fc_within_lead_tm IS '??????????????????';


--
-- Name: COLUMN fc_item_mast.fc_item_alloc_policy_id; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.fc_item_mast.fc_item_alloc_policy_id IS 'F - Forecast, S - Safety Stock, B - Both, N - None';


--
-- Name: oe_cust_mast; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.oe_cust_mast (
    org_nbr_cust integer NOT NULL,
    stat_id character varying(1) NOT NULL,
    cust_price_grp character varying(10),
    cust_grp character varying(8),
    sic_cd character varying(8),
    reqr_po_flg character varying(1) NOT NULL,
    contract_cust_flg character varying(1) NOT NULL,
    price_chg_flg character varying(1) NOT NULL,
    trd_flg character varying(1) NOT NULL,
    trd_gl_acct character varying(20),
    ut_user_nbr integer NOT NULL,
    last_mod_dt timestamp without time zone NOT NULL,
    sell_indiv_nbr integer,
    intro_dt timestamp without time zone NOT NULL,
    virtual_cust_flg character varying(1) NOT NULL,
    ship_to_addr_nbr_dflt integer NOT NULL,
    bill_to_addr_nbr_dflt integer NOT NULL,
    term_cd_dflt character varying(10) NOT NULL,
    ship_via_cd_dflt character varying(8) NOT NULL,
    fob_cd_dflt character varying(8) NOT NULL,
    curr_cd_dflt character varying(3) NOT NULL,
    ship_pct_line_dflt numeric(5,2),
    ship_pct_dollar_dflt numeric(5,2),
    cust_alloc_prty smallint NOT NULL,
    ord_type_cd_dflt character varying(8) NOT NULL,
    dup_po_allow_flg character varying(1) NOT NULL,
    credit_limit numeric(12,2),
    curr_ar_bal numeric(10,2),
    sales_terr_cd_dflt character varying(8) NOT NULL,
    label_nm_bag character varying(20),
    label_nm_pack_box character varying(20),
    pack_box_contents_rpt_nm character varying(255),
    pack_slip_rpt_nm character varying(255),
    show_price_on_pack_slip_flg character varying(1) NOT NULL,
    nbr_pack_slip_copies smallint NOT NULL,
    add_addr_flg character varying(1) NOT NULL,
    fcst_grp character varying(8) NOT NULL,
    summary_inv_rpt_nm character varying(255),
    avg_days_to_pay smallint,
    indiv_nbr_cust_contact integer,
    nbr_invoice_copies smallint NOT NULL,
    ar_integration_tm timestamp without time zone,
    sales_region_cd_dflt character varying(8),
    ship_line_pct_dflt smallint,
    auto_close_line_pct_dflt smallint,
    max_shipments_per_line_dflt smallint,
    org_nbr_cust_parent integer,
    wh_ship_prty_nbr_dflt integer,
    payment_method_cd_dflt character varying(3),
    price_policy_cd character varying(10) NOT NULL,
    transmit_pack_slip_on_ship_flg character varying(1) NOT NULL,
    CONSTRAINT ocm_check_stat_id CHECK (((stat_id)::text = ANY (ARRAY[('S'::character varying)::text, ('A'::character varying)::text, ('I'::character varying)::text, ('H'::character varying)::text]))),
    CONSTRAINT sys_c0015479 CHECK (((reqr_po_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0015480 CHECK (((contract_cust_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0015481 CHECK (((price_chg_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0015482 CHECK (((trd_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0015485 CHECK (((virtual_cust_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0015486 CHECK (((cust_alloc_prty >= 0) AND (cust_alloc_prty <= 999))),
    CONSTRAINT sys_c0015487 CHECK (((dup_po_allow_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0015488 CHECK (((show_price_on_pack_slip_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0015489 CHECK (((add_addr_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0015491 CHECK (((transmit_pack_slip_on_ship_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0015917 CHECK (((reqr_po_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0015918 CHECK (((contract_cust_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0015919 CHECK (((price_chg_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0015920 CHECK (((trd_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0015921 CHECK (((virtual_cust_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0015922 CHECK (((cust_alloc_prty >= 0) AND (cust_alloc_prty <= 999))),
    CONSTRAINT sys_c0015923 CHECK (((dup_po_allow_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0015924 CHECK (((show_price_on_pack_slip_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0015925 CHECK (((add_addr_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text])))
);


ALTER TABLE aerodemo.oe_cust_mast OWNER TO jjs;

--
-- Name: COLUMN oe_cust_mast.org_nbr_cust; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.oe_cust_mast.org_nbr_cust IS 'Surrogate key that identifies this customer.';


--
-- Name: COLUMN oe_cust_mast.price_chg_flg; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.oe_cust_mast.price_chg_flg IS '?????????????';


--
-- Name: COLUMN oe_cust_mast.trd_gl_acct; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.oe_cust_mast.trd_gl_acct IS 'The General Ledger account to be used to track the due/from due/to amount for the customer if the customer is a trading customer.';


--
-- Name: COLUMN oe_cust_mast.ut_user_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.oe_cust_mast.ut_user_nbr IS 'Surrogate primary key for UT_USER';


--
-- Name: COLUMN oe_cust_mast.sell_indiv_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.oe_cust_mast.sell_indiv_nbr IS 'Identifies the individual that is the sales manager for this customer.';


--
-- Name: COLUMN oe_cust_mast.intro_dt; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.oe_cust_mast.intro_dt IS 'The date this customer relationship was established.';


--
-- Name: COLUMN oe_cust_mast.virtual_cust_flg; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.oe_cust_mast.virtual_cust_flg IS 'If ''Y'' this customer may be used for multiple customers.  Useful for cash and over the counter sales.';


--
-- Name: COLUMN oe_cust_mast.ship_to_addr_nbr_dflt; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.oe_cust_mast.ship_to_addr_nbr_dflt IS 'Identifies the default ship to address for the customer.';


--
-- Name: COLUMN oe_cust_mast.bill_to_addr_nbr_dflt; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.oe_cust_mast.bill_to_addr_nbr_dflt IS 'Identifies the default bill to address for the customer.';


--
-- Name: COLUMN oe_cust_mast.term_cd_dflt; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.oe_cust_mast.term_cd_dflt IS 'The default payment terms for the customer, used as a default when creating customer orders.';


--
-- Name: COLUMN oe_cust_mast.ship_via_cd_dflt; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.oe_cust_mast.ship_via_cd_dflt IS 'Identifier for default mechanism for shipping to this customer.';


--
-- Name: COLUMN oe_cust_mast.curr_cd_dflt; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.oe_cust_mast.curr_cd_dflt IS 'The default currency code that the customer will use when placing orders.';


--
-- Name: COLUMN oe_cust_mast.ship_pct_line_dflt; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.oe_cust_mast.ship_pct_line_dflt IS 'The default percentage of lines which must be fulfilled on the first shipment to this customer.';


--
-- Name: COLUMN oe_cust_mast.ship_pct_dollar_dflt; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.oe_cust_mast.ship_pct_dollar_dflt IS 'The default percentage of the value of the order which should be shipped to the customer on the first shipment.';


--
-- Name: COLUMN oe_cust_mast.cust_alloc_prty; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.oe_cust_mast.cust_alloc_prty IS 'The relative priority for this customer as demand when allocating inventory.';


--
-- Name: COLUMN oe_cust_mast.ord_type_cd_dflt; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.oe_cust_mast.ord_type_cd_dflt IS 'The type of order to be used as a default for this customer.';


--
-- Name: COLUMN oe_cust_mast.dup_po_allow_flg; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.oe_cust_mast.dup_po_allow_flg IS '''Y'' Allow multiple sales orders to this customer to have the same purchase order number.';


--
-- Name: COLUMN oe_cust_mast.credit_limit; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.oe_cust_mast.credit_limit IS 'The maximum amount of credit allowed for this customer as open receivables before ???';


--
-- Name: COLUMN oe_cust_mast.curr_ar_bal; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.oe_cust_mast.curr_ar_bal IS 'The current receivables balance from this customer.';


--
-- Name: COLUMN oe_cust_mast.sales_terr_cd_dflt; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.oe_cust_mast.sales_terr_cd_dflt IS 'The sales territory associated with this customer.';


--
-- Name: COLUMN oe_cust_mast.label_nm_bag; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.oe_cust_mast.label_nm_bag IS 'The name of the label identifier to be used when creating custom labels on inner packing for the customer.';


--
-- Name: COLUMN oe_cust_mast.label_nm_pack_box; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.oe_cust_mast.label_nm_pack_box IS 'The name of the label to be used on boxes packed for this customer.';


--
-- Name: COLUMN oe_cust_mast.pack_box_contents_rpt_nm; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.oe_cust_mast.pack_box_contents_rpt_nm IS 'The name of the report to be used when generating a box contents report for this customer.';


--
-- Name: COLUMN oe_cust_mast.pack_slip_rpt_nm; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.oe_cust_mast.pack_slip_rpt_nm IS 'The name of the report to be used when generating a packing slip for this customer.';


--
-- Name: COLUMN oe_cust_mast.show_price_on_pack_slip_flg; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.oe_cust_mast.show_price_on_pack_slip_flg IS 'If ''Y'' show the price on the packing slip.';


--
-- Name: COLUMN oe_cust_mast.nbr_pack_slip_copies; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.oe_cust_mast.nbr_pack_slip_copies IS 'The number of packing slips to be included with a shipment.';


--
-- Name: COLUMN oe_cust_mast.add_addr_flg; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.oe_cust_mast.add_addr_flg IS '''Y'' - allow new addresses to be created for this customer during the order entry process.';


--
-- Name: COLUMN oe_cust_mast.fcst_grp; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.oe_cust_mast.fcst_grp IS 'The group to which this customer is to be aggregated when forecasting.';


--
-- Name: COLUMN oe_cust_mast.summary_inv_rpt_nm; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.oe_cust_mast.summary_inv_rpt_nm IS 'The name of the report which creates the summary invoice for this customer.';


--
-- Name: COLUMN oe_cust_mast.avg_days_to_pay; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.oe_cust_mast.avg_days_to_pay IS 'Historical average days to pay';


--
-- Name: COLUMN oe_cust_mast.indiv_nbr_cust_contact; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.oe_cust_mast.indiv_nbr_cust_contact IS 'Identifies the primary sales contact for this customer.';


--
-- Name: COLUMN oe_cust_mast.nbr_invoice_copies; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.oe_cust_mast.nbr_invoice_copies IS 'The number of invoice copies that should be printed for this customer.';


--
-- Name: COLUMN oe_cust_mast.ar_integration_tm; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.oe_cust_mast.ar_integration_tm IS 'Time the last Accounts Receivable integration run was made for this customer.';


--
-- Name: COLUMN oe_cust_mast.sales_region_cd_dflt; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.oe_cust_mast.sales_region_cd_dflt IS 'The sales region to be used by default when creating new orders for this customer.';


--
-- Name: COLUMN oe_cust_mast.ship_line_pct_dflt; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.oe_cust_mast.ship_line_pct_dflt IS 'The default percentage of lines that should be shippable for this customer on the first shipment.';


--
-- Name: COLUMN oe_cust_mast.max_shipments_per_line_dflt; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.oe_cust_mast.max_shipments_per_line_dflt IS 'The default maximum number of shipments for a line when creating new orders for this custoemr.';


--
-- Name: COLUMN oe_cust_mast.org_nbr_cust_parent; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.oe_cust_mast.org_nbr_cust_parent IS 'The customer that is the owning entity of this subsidiary.';


--
-- Name: aps_dmd_fc; Type: VIEW; Schema: aerodemo; Owner: jjs
--

CREATE VIEW aerodemo.aps_dmd_fc AS
 SELECT 'FC'::text AS dmd_type_cd,
    ((((('FC'::text || fim.fc_item_mast_nbr) || ' '::text) || ff.cycle) || '/'::text) || ff.intvl) AS dmd_cd,
    fim.item_nbr AS item_nbr_dmd,
    ff.fc_fcst_nbr,
    to_date(((((ff.cycle)::character varying)::text || '/'::text) || ((ff.intvl)::character varying)::text), 'yyyy/mm'::text) AS rqst_dt,
    fim.aps_src_rule_set_nbr,
    fim.org_nbr_cust,
    no.org_cd AS org_cd_cust,
    COALESCE(ff.adj_fcst, ff.raw_fcst) AS open_qty,
    NULL::text AS contract_cust_flg,
    COALESCE((ocm.cust_alloc_prty)::integer, 999) AS cust_alloc_prty,
    fim.rev_lvl,
    fim.org_nbr_mfr_rqst,
    fim.fc_item_mast_nbr,
    fim.fcst_grp
   FROM aerodemo.fc_item_mast fim,
    aerodemo.fc_fcst ff,
    aerodemo.oe_cust_mast ocm,
    aerodemo.na_org no
  WHERE ((ff.fc_item_mast_nbr = fim.fc_item_mast_nbr) AND (fim.org_nbr_cust = ocm.org_nbr_cust) AND (no.org_nbr = ocm.org_nbr_cust) AND (COALESCE(ff.adj_fcst, ff.raw_fcst) > (0)::numeric));


ALTER TABLE aerodemo.aps_dmd_fc OWNER TO jjs;

--
-- Name: COLUMN aps_dmd_fc.rqst_dt; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_dmd_fc.rqst_dt IS 'The date the customer requests the item to be shipped.';


--
-- Name: COLUMN aps_dmd_fc.org_nbr_cust; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_dmd_fc.org_nbr_cust IS 'Reference to the customer (OE_CUST_MAST.ORG_NBR_CUST)';


--
-- Name: COLUMN aps_dmd_fc.org_cd_cust; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_dmd_fc.org_cd_cust IS 'Identifier for the customer that placed the order.';


--
-- Name: COLUMN aps_dmd_fc.cust_alloc_prty; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_dmd_fc.cust_alloc_prty IS 'The relative priority for this customer as demand when allocating inventory.';


--
-- Name: COLUMN aps_dmd_fc.rev_lvl; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_dmd_fc.rev_lvl IS 'The revision level of a SKU required to satisfy sourcing in advanced planning.';


--
-- Name: COLUMN aps_dmd_fc.fc_item_mast_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_dmd_fc.fc_item_mast_nbr IS 'Surrogate primary key for FC_ITEM_MAST.';


--
-- Name: COLUMN aps_dmd_fc.fcst_grp; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_dmd_fc.fcst_grp IS 'The Group assigned to the Customer for Forecasting purposes';


--
-- Name: oe_cust_contract; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.oe_cust_contract (
    contract_cd character varying(8) NOT NULL,
    org_nbr_cust integer NOT NULL,
    ut_user_nbr integer NOT NULL,
    last_mod_dt timestamp without time zone NOT NULL,
    contract_cd_descr character varying(60),
    bin_grp_reqr_flg character varying(1) NOT NULL,
    fcst_grp character varying(8) NOT NULL,
    accept_multi_scan_for_bin_flg character varying(1) NOT NULL,
    ord_turn_around_dy smallint NOT NULL,
    CONSTRAINT sys_c0015450 CHECK (((bin_grp_reqr_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0015451 CHECK (((accept_multi_scan_for_bin_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0016069 CHECK (((bin_grp_reqr_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0016070 CHECK (((accept_multi_scan_for_bin_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text])))
);


ALTER TABLE aerodemo.oe_cust_contract OWNER TO jjs;

--
-- Name: COLUMN oe_cust_contract.contract_cd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.oe_cust_contract.contract_cd IS 'The contract code, from the order detail line under which the goods were purchased.';


--
-- Name: COLUMN oe_cust_contract.org_nbr_cust; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.oe_cust_contract.org_nbr_cust IS 'Reference to the customer (OE_CUST_MAST.ORG_NBR_CUST)';


--
-- Name: COLUMN oe_cust_contract.ut_user_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.oe_cust_contract.ut_user_nbr IS 'Surrogate primary key for UT_USER';


--
-- Name: COLUMN oe_cust_contract.fcst_grp; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.oe_cust_contract.fcst_grp IS 'The Group assigned to the Customer for Forecasting purposes';


--
-- Name: oe_ord_hdr; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.oe_ord_hdr (
    oe_ord_hdr_nbr integer NOT NULL,
    ord_dt timestamp without time zone NOT NULL,
    ord_stat_id character varying(1) NOT NULL,
    org_nbr_cust integer NOT NULL,
    bill_to_addr_nbr integer NOT NULL,
    ship_to_addr_nbr_dflt integer NOT NULL,
    cust_po_cd character varying(30),
    cust_po_dt timestamp without time zone,
    rqst_dt_dflt timestamp without time zone,
    cancel_dt timestamp without time zone,
    term_cd character varying(10),
    ship_via_cd_dflt character varying(8) NOT NULL,
    fob_cd character varying(8),
    curr_cd character varying(3) NOT NULL,
    ut_user_nbr_cancel integer,
    cancel_cd character varying(8),
    ord_prty smallint,
    sell_indiv_nbr integer,
    trd_flg character varying(1) NOT NULL,
    ut_user_nbr integer NOT NULL,
    last_mod_dt timestamp without time zone NOT NULL,
    ship_pct_line smallint,
    ship_pct_dollar smallint,
    next_line_nbr smallint,
    org_nm_cust character varying(60) NOT NULL,
    ord_type_cd character varying(8) NOT NULL,
    ord_cd character varying(20) NOT NULL,
    buyer_email_addr character varying(40),
    indiv_nm_buyer character varying(45),
    buyer_phn_nbr character varying(20),
    sales_terr_cd character varying(8) NOT NULL,
    buyer_fax_nbr character varying(20),
    transmit_flg character varying(1) NOT NULL,
    wh_ship_prty_nbr_dflt integer,
    payment_method_cd_dflt character varying(3),
    CONSTRAINT check_ooh_ord_stat_id CHECK (((ord_stat_id)::text = ANY (ARRAY[('O'::character varying)::text, ('C'::character varying)::text, ('H'::character varying)::text, ('X'::character varying)::text]))),
    CONSTRAINT sys_c0015570 CHECK (((trd_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0015573 CHECK (((ship_pct_line >= 1) AND (ship_pct_line <= 100))),
    CONSTRAINT sys_c0015574 CHECK (((ship_pct_dollar >= 1) AND (ship_pct_dollar <= 100))),
    CONSTRAINT sys_c0015578 CHECK (((transmit_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0016293 CHECK (((ship_pct_dollar >= 1) AND (ship_pct_dollar <= 100))),
    CONSTRAINT sys_c0016294 CHECK (((transmit_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0016311 CHECK (((trd_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0016312 CHECK (((ship_pct_line >= 1) AND (ship_pct_line <= 100))),
    CONSTRAINT sys_c0016313 CHECK (((ship_pct_dollar >= 1) AND (ship_pct_dollar <= 100))),
    CONSTRAINT sys_c0016314 CHECK (((transmit_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0016315 CHECK (((trd_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0016316 CHECK (((ship_pct_line >= 1) AND (ship_pct_line <= 100)))
);


ALTER TABLE aerodemo.oe_ord_hdr OWNER TO jjs;

--
-- Name: COLUMN oe_ord_hdr.ord_dt; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.oe_ord_hdr.ord_dt IS 'The date the order was placed.  May differ for every line.';


--
-- Name: COLUMN oe_ord_hdr.org_nbr_cust; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.oe_ord_hdr.org_nbr_cust IS 'Reference to the customer (OE_CUST_MAST.ORG_NBR_CUST)';


--
-- Name: COLUMN oe_ord_hdr.ship_to_addr_nbr_dflt; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.oe_ord_hdr.ship_to_addr_nbr_dflt IS 'Identifies the default ship to address for the customer.';


--
-- Name: COLUMN oe_ord_hdr.cust_po_cd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.oe_ord_hdr.cust_po_cd IS 'The purchase order number for this line assigned by the customer.';


--
-- Name: COLUMN oe_ord_hdr.term_cd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.oe_ord_hdr.term_cd IS 'Payment terms code.';


--
-- Name: COLUMN oe_ord_hdr.ship_via_cd_dflt; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.oe_ord_hdr.ship_via_cd_dflt IS 'Identifier for default mechanism for shipping to this customer.';


--
-- Name: COLUMN oe_ord_hdr.fob_cd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.oe_ord_hdr.fob_cd IS 'Free on Board code.  Identifies when the customer takes ownership of this inventory.';


--
-- Name: COLUMN oe_ord_hdr.curr_cd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.oe_ord_hdr.curr_cd IS 'The ANSI X.12 currency code associated with the unit cost.';


--
-- Name: COLUMN oe_ord_hdr.sell_indiv_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.oe_ord_hdr.sell_indiv_nbr IS 'Identifies the individual that is the sales manager for this customer.';


--
-- Name: COLUMN oe_ord_hdr.ut_user_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.oe_ord_hdr.ut_user_nbr IS 'Surrogate primary key for UT_USER';


--
-- Name: COLUMN oe_ord_hdr.ord_type_cd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.oe_ord_hdr.ord_type_cd IS 'Identifier for the type of order, e.g. PHN - phone, EDI - X.12, FAX, MAIL, WEB, SOA - web service';


--
-- Name: COLUMN oe_ord_hdr.ord_cd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.oe_ord_hdr.ord_cd IS 'The order code generated by order entry for the order.';


--
-- Name: COLUMN oe_ord_hdr.sales_terr_cd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.oe_ord_hdr.sales_terr_cd IS 'The sales territory that gets credit for this sale.';


--
-- Name: aps_dmd_oo; Type: VIEW; Schema: aerodemo; Owner: jjs
--

CREATE VIEW aerodemo.aps_dmd_oo AS
 SELECT 'OO'::text AS dmd_type_cd,
    ((((ooh.ord_type_cd)::text || (ooh.ord_cd)::text) || '-'::text) || ((ood.line_nbr)::character varying)::text) AS dmd_cd,
    ood.item_nbr_ord AS item_nbr_dmd,
    ood.oe_ord_dtl_nbr,
    ood.rqst_dt,
    ood.prom_dt_curr,
    ood.aps_src_rule_set_nbr,
    ood.org_nbr_cust,
    (COALESCE(ood.qty_ord_stk_um, (0)::numeric) - COALESCE(ood.qty_ship_stk_um, (0)::numeric)) AS open_qty,
    ood.qty_alloc_stk_um AS open_qty_adj,
    cust.org_cd AS org_cd_cust,
    ood.org_nbr_mfr_rqst,
    pmm.org_cd AS org_cd_mfr,
        CASE
            WHEN (ood.contract_cd IS NULL) THEN 'N'::text
            ELSE 'Y'::text
        END AS contract_cust_flg,
    ood.unit_price_stk_um AS unit_price,
    ocm.cust_alloc_prty,
    ood.rev_lvl,
    ood.cntry_cd_origin,
    ood.lot_not_expire_before_dt,
    ood.lot_manufacture_after_dt,
        CASE
            WHEN (ood.contract_cd IS NULL) THEN ocm.fcst_grp
            ELSE ( SELECT occ.fcst_grp
               FROM aerodemo.oe_cust_contract occ
              WHERE ((occ.org_nbr_cust = ood.org_nbr_cust) AND ((occ.contract_cd)::text = (ood.contract_cd)::text)))
        END AS fcst_grp,
    ood.ship_from_facility
   FROM aerodemo.oe_ord_hdr ooh,
    aerodemo.oe_cust_mast ocm,
    aerodemo.na_org cust,
    (aerodemo.oe_ord_dtl ood
     LEFT JOIN aerodemo.na_org pmm ON ((ood.org_nbr_mfr_rqst = pmm.org_nbr)))
  WHERE ((ood.oe_ord_hdr_nbr = ooh.oe_ord_hdr_nbr) AND (ood.org_nbr_cust = ocm.org_nbr_cust) AND (ood.org_nbr_cust = cust.org_nbr) AND ((ood.line_stat_id)::text = 'O'::text) AND ((COALESCE(ood.qty_ord_stk_um, (0)::numeric) - COALESCE(ood.qty_ship_stk_um, (0)::numeric)) > (0)::numeric) AND (ood.cancel_cd IS NULL));


ALTER TABLE aerodemo.aps_dmd_oo OWNER TO jjs;

--
-- Name: COLUMN aps_dmd_oo.oe_ord_dtl_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_dmd_oo.oe_ord_dtl_nbr IS 'A foreign key back to the order detail.';


--
-- Name: COLUMN aps_dmd_oo.rqst_dt; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_dmd_oo.rqst_dt IS 'The date the customer requests the item to be shipped.';


--
-- Name: COLUMN aps_dmd_oo.org_nbr_cust; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_dmd_oo.org_nbr_cust IS 'Reference to the customer (OE_CUST_MAST.ORG_NBR_CUST)';


--
-- Name: COLUMN aps_dmd_oo.org_cd_cust; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_dmd_oo.org_cd_cust IS 'Identifier for the customer that placed the order.';


--
-- Name: COLUMN aps_dmd_oo.org_cd_mfr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_dmd_oo.org_cd_mfr IS 'Identifies the orgranization that manufactured the inventory.';


--
-- Name: COLUMN aps_dmd_oo.cust_alloc_prty; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_dmd_oo.cust_alloc_prty IS 'The relative priority for this customer as demand when allocating inventory.';


--
-- Name: COLUMN aps_dmd_oo.rev_lvl; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_dmd_oo.rev_lvl IS 'The revision level of a SKU required to satisfy sourcing in advanced planning.';


--
-- Name: COLUMN aps_dmd_oo.fcst_grp; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_dmd_oo.fcst_grp IS 'The Group assigned to the Customer for Forecasting purposes';


--
-- Name: COLUMN aps_dmd_oo.ship_from_facility; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_dmd_oo.ship_from_facility IS 'The facility from which this order line should preferably be shipped.';


--
-- Name: aps_dmd_rule_set_item_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.aps_dmd_rule_set_item_nbr_seq
    START WITH 359297
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.aps_dmd_rule_set_item_nbr_seq OWNER TO jjs;

--
-- Name: aps_dmd_ss; Type: VIEW; Schema: aerodemo; Owner: jjs
--

CREATE VIEW aerodemo.aps_dmd_ss AS
 SELECT 'SS'::text AS dmd_type_cd,
    (('SS'::text || '-'::text) || fim.fc_item_mast_nbr) AS dmd_cd,
    fim.item_nbr AS item_nbr_dmd,
    fim.item_nbr AS item_nbr_alloc_rqst,
    fim.fc_item_mast_nbr,
    date_trunc('day'::text, ('now'::text)::timestamp without time zone) AS rqst_dt,
    fim.aps_src_rule_set_nbr,
    fim.org_nbr_cust,
    na.org_cd AS org_cd_cust,
    fim.safety_stk_adj AS open_qty,
    fim.safety_stk_alloc_qty AS open_qty_adj,
    ocm.contract_cust_flg,
    COALESCE((ocm.cust_alloc_prty)::integer, 999) AS cust_alloc_prty,
    fim.rev_lvl,
    fim.org_nbr_mfr_rqst,
    fim.fcst_grp
   FROM aerodemo.fc_item_mast fim,
    aerodemo.oe_cust_mast ocm,
    aerodemo.na_org na
  WHERE ((fim.org_nbr_cust = ocm.org_nbr_cust) AND (fim.org_nbr_cust = na.org_nbr) AND (COALESCE(fim.safety_stk_adj, 0) > 0));


ALTER TABLE aerodemo.aps_dmd_ss OWNER TO jjs;

--
-- Name: COLUMN aps_dmd_ss.fc_item_mast_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_dmd_ss.fc_item_mast_nbr IS 'Surrogate primary key for FC_ITEM_MAST.';


--
-- Name: COLUMN aps_dmd_ss.rqst_dt; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_dmd_ss.rqst_dt IS 'The date the safety stock is needed.';


--
-- Name: COLUMN aps_dmd_ss.org_nbr_cust; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_dmd_ss.org_nbr_cust IS 'Reference to the customer (OE_CUST_MAST.ORG_NBR_CUST)';


--
-- Name: COLUMN aps_dmd_ss.org_cd_cust; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_dmd_ss.org_cd_cust IS 'Identifier for the customer that placed the order.';


--
-- Name: COLUMN aps_dmd_ss.cust_alloc_prty; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_dmd_ss.cust_alloc_prty IS 'The relative priority for this customer as demand when allocating inventory.';


--
-- Name: COLUMN aps_dmd_ss.rev_lvl; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_dmd_ss.rev_lvl IS 'The revision level of a SKU required to satisfy sourcing in advanced planning.';


--
-- Name: COLUMN aps_dmd_ss.fcst_grp; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_dmd_ss.fcst_grp IS 'The Group assigned to the Customer for Forecasting purposes';


--
-- Name: wo_dtl; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.wo_dtl (
    wo_dtl_nbr integer NOT NULL,
    wo_hdr_nbr integer NOT NULL,
    item_nbr_component integer NOT NULL,
    component_um character varying(2) NOT NULL,
    ut_user_nbr integer NOT NULL,
    last_mod_dt timestamp without time zone NOT NULL,
    component_qty_per_unit numeric(13,5) NOT NULL,
    rev_lvl character varying(5),
    org_nbr_mfr_rqst integer,
    qty_alloc numeric(13,5),
    qty_alloc_stk_um numeric(13,5),
    mix_mfr_lot_flg character varying(1) NOT NULL,
    mandatory_item_flg character varying(1) NOT NULL,
    print_bag_lbl_flg character varying(1) NOT NULL,
    CONSTRAINT sys_c0015825 CHECK (((mix_mfr_lot_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0015826 CHECK (((mandatory_item_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0015827 CHECK (((print_bag_lbl_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0016575 CHECK (((mix_mfr_lot_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0016576 CHECK (((mandatory_item_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0016577 CHECK (((print_bag_lbl_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text])))
);


ALTER TABLE aerodemo.wo_dtl OWNER TO jjs;

--
-- Name: COLUMN wo_dtl.wo_hdr_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.wo_dtl.wo_hdr_nbr IS 'The surrogate primary key for WO_HDR.';


--
-- Name: COLUMN wo_dtl.ut_user_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.wo_dtl.ut_user_nbr IS 'Surrogate primary key for UT_USER';


--
-- Name: COLUMN wo_dtl.rev_lvl; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.wo_dtl.rev_lvl IS 'The revision level of a SKU required to satisfy sourcing in advanced planning.';


--
-- Name: aps_dmd_wo; Type: VIEW; Schema: aerodemo; Owner: jjs
--

CREATE VIEW aerodemo.aps_dmd_wo AS
 SELECT 'WO'::text AS dmd_type_cd,
    ('WO'::text || ((woh.wo_hdr_nbr)::character varying)::text) AS dmd_cd,
    wod.item_nbr_component AS item_nbr_dmd,
    wod.wo_dtl_nbr,
    woh.need_by_dt,
    woh.aps_src_rule_set_nbr,
    woh.org_nbr_cust,
    cust.org_cd AS org_cd_cust,
    wod.org_nbr_mfr_rqst,
    mfr.org_cd AS org_cd_mfr_rqst,
    wod.rev_lvl,
    (((COALESCE(woh.rqst_qty, 0) - COALESCE(woh.fill_qty, 0)))::numeric * COALESCE(wod.component_qty_per_unit, (0)::numeric)) AS open_qty,
    wod.qty_alloc_stk_um AS open_qty_adj,
    ocm.fcst_grp,
    wod.mix_mfr_lot_flg,
    wod.component_qty_per_unit,
    ocm.cust_alloc_prty
   FROM aerodemo.wo_hdr woh,
    aerodemo.oe_cust_mast ocm,
    aerodemo.na_org cust,
    (aerodemo.wo_dtl wod
     LEFT JOIN aerodemo.na_org mfr ON ((wod.org_nbr_mfr_rqst = mfr.org_nbr)))
  WHERE ((wod.wo_hdr_nbr = woh.wo_hdr_nbr) AND (woh.org_nbr_cust = cust.org_nbr) AND ((woh.wo_stat_id)::text = 'O'::text) AND (woh.org_nbr_cust = ocm.org_nbr_cust));


ALTER TABLE aerodemo.aps_dmd_wo OWNER TO jjs;

--
-- Name: COLUMN aps_dmd_wo.org_nbr_cust; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_dmd_wo.org_nbr_cust IS 'Reference to the customer (OE_CUST_MAST.ORG_NBR_CUST)';


--
-- Name: COLUMN aps_dmd_wo.org_cd_cust; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_dmd_wo.org_cd_cust IS 'Identifier for the customer that placed the order.';


--
-- Name: COLUMN aps_dmd_wo.rev_lvl; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_dmd_wo.rev_lvl IS 'The revision level of a SKU required to satisfy sourcing in advanced planning.';


--
-- Name: COLUMN aps_dmd_wo.fcst_grp; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_dmd_wo.fcst_grp IS 'The Group assigned to the Customer for Forecasting purposes';


--
-- Name: COLUMN aps_dmd_wo.cust_alloc_prty; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_dmd_wo.cust_alloc_prty IS 'The relative priority for this customer as demand when allocating inventory.';


--
-- Name: aps_ideal_global_replen; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.aps_ideal_global_replen (
    item_nbr integer NOT NULL,
    replen_dt timestamp without time zone NOT NULL,
    replen_qty numeric(17,5)
);


ALTER TABLE aerodemo.aps_ideal_global_replen OWNER TO jjs;

--
-- Name: COLUMN aps_ideal_global_replen.item_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_ideal_global_replen.item_nbr IS 'Product identifier, reference to item master (IC_ITEM_MAST.ITEM_NBR)';


--
-- Name: COLUMN aps_ideal_global_replen.replen_qty; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_ideal_global_replen.replen_qty IS 'Replenishment quantity in the replenishment unit of measure.';


--
-- Name: aps_item_global_subst; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.aps_item_global_subst (
    item_nbr integer NOT NULL,
    item_nbr_subst integer NOT NULL,
    ut_user_nbr integer NOT NULL,
    last_mod_dt timestamp without time zone NOT NULL
);


ALTER TABLE aerodemo.aps_item_global_subst OWNER TO jjs;

--
-- Name: COLUMN aps_item_global_subst.item_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_item_global_subst.item_nbr IS 'Product identifier, reference to item master (IC_ITEM_MAST.ITEM_NBR)';


--
-- Name: COLUMN aps_item_global_subst.ut_user_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_item_global_subst.ut_user_nbr IS 'Surrogate primary key for UT_USER';


--
-- Name: aps_item_log; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.aps_item_log (
    item_nbr integer NOT NULL,
    aps_log_file_name character varying(255),
    last_plan_dt timestamp without time zone
);


ALTER TABLE aerodemo.aps_item_log OWNER TO jjs;

--
-- Name: COLUMN aps_item_log.item_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_item_log.item_nbr IS 'Product identifier, reference to item master (IC_ITEM_MAST.ITEM_NBR)';


--
-- Name: aps_item_replen_policy; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.aps_item_replen_policy (
    item_nbr integer NOT NULL,
    facility character varying(16) NOT NULL,
    replen_qty_min_unit integer,
    replen_qty_max_unit integer,
    replen_qty_min_prd numeric(4,1),
    replen_qty_max_prd numeric(4,1),
    replen_qty_incr_unit integer
);


ALTER TABLE aerodemo.aps_item_replen_policy OWNER TO jjs;

--
-- Name: COLUMN aps_item_replen_policy.item_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_item_replen_policy.item_nbr IS 'Product identifier, reference to item master (IC_ITEM_MAST.ITEM_NBR)';


--
-- Name: COLUMN aps_item_replen_policy.facility; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_item_replen_policy.facility IS 'The facility associated with this record.  ';


--
-- Name: COLUMN aps_item_replen_policy.replen_qty_min_prd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_item_replen_policy.replen_qty_min_prd IS 'The minimum periods of demand which should be replenished at one time.';


--
-- Name: COLUMN aps_item_replen_policy.replen_qty_max_prd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_item_replen_policy.replen_qty_max_prd IS 'The maximu periods of demand which should be replenished at one time.';


--
-- Name: aps_plan_grp; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.aps_plan_grp (
    plan_grp_nbr integer,
    item_nbr integer NOT NULL
);


ALTER TABLE aerodemo.aps_plan_grp OWNER TO jjs;

--
-- Name: COLUMN aps_plan_grp.item_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_plan_grp.item_nbr IS 'Product identifier, reference to item master (IC_ITEM_MAST.ITEM_NBR)';


--
-- Name: aps_plan_grp_dmd; Type: VIEW; Schema: aerodemo; Owner: jjs
--

CREATE VIEW aerodemo.aps_plan_grp_dmd AS
 SELECT aps_plan_grp.plan_grp_nbr,
    count(*) AS item_nbr_cnt,
    aps_plan_grp.item_nbr
   FROM aerodemo.aps_plan_grp,
    aerodemo.aps_dmd_oo
  WHERE (aps_dmd_oo.item_nbr_dmd = aps_plan_grp.item_nbr)
  GROUP BY aps_plan_grp.item_nbr, aps_plan_grp.plan_grp_nbr
  ORDER BY aps_plan_grp.plan_grp_nbr, aps_plan_grp.item_nbr;


ALTER TABLE aerodemo.aps_plan_grp_dmd OWNER TO jjs;

--
-- Name: aps_plan_grp_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.aps_plan_grp_nbr_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.aps_plan_grp_nbr_seq OWNER TO jjs;

--
-- Name: aps_result_dtl_dmd; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.aps_result_dtl_dmd (
    aps_result_dtl_dmd_nbr integer NOT NULL,
    item_nbr_rqst integer,
    dmd_identifier character varying(20),
    oe_ord_dtl_nbr integer,
    wo_dtl_nbr integer,
    fc_fcst_nbr integer,
    fc_item_mast_nbr integer,
    dmd_qty numeric(13,5),
    dmd_qty_adj numeric(13,5),
    alloc_qty numeric(13,5),
    rqst_dt_alloc_qty numeric(13,5),
    rqst_dt timestamp without time zone,
    prom_dt_curr timestamp without time zone,
    avail_dt timestamp without time zone,
    aps_src_rule_set_nbr_dmd integer,
    facility_dmd character varying(16),
    org_nbr_cust integer,
    org_nbr_mfr_rqst integer
);


ALTER TABLE aerodemo.aps_result_dtl_dmd OWNER TO jjs;

--
-- Name: COLUMN aps_result_dtl_dmd.oe_ord_dtl_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_result_dtl_dmd.oe_ord_dtl_nbr IS 'A foreign key back to the order detail.';


--
-- Name: COLUMN aps_result_dtl_dmd.fc_item_mast_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_result_dtl_dmd.fc_item_mast_nbr IS 'Surrogate primary key for FC_ITEM_MAST.';


--
-- Name: COLUMN aps_result_dtl_dmd.rqst_dt; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_result_dtl_dmd.rqst_dt IS 'The date the customer requests the item to be shipped.';


--
-- Name: COLUMN aps_result_dtl_dmd.org_nbr_cust; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_result_dtl_dmd.org_nbr_cust IS 'Reference to the customer (OE_CUST_MAST.ORG_NBR_CUST)';


--
-- Name: aps_result_dtl_dmd_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.aps_result_dtl_dmd_nbr_seq
    START WITH 327942360
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 999999999
    CACHE 20
    CYCLE;


ALTER TABLE aerodemo.aps_result_dtl_dmd_nbr_seq OWNER TO jjs;

--
-- Name: aps_result_dtl_dmd_seq; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.aps_result_dtl_dmd_seq (
    nextval integer
);


ALTER TABLE aerodemo.aps_result_dtl_dmd_seq OWNER TO jjs;

--
-- Name: aps_result_dtl_sply; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.aps_result_dtl_sply (
    aps_result_dtl_dmd_nbr integer,
    sply_identifier character varying(30),
    lot_nbr_sply integer,
    facility_sply character varying(16),
    aps_sply_sub_pool_nbr_sply integer,
    po_line_dtl_nbr integer,
    wo_hdr_nbr integer,
    sply_qty numeric(13,5),
    sply_qty_alloc numeric(13,5),
    avail_dt timestamp without time zone,
    org_nbr_mfr_sply integer,
    org_nbr_vnd_sply integer,
    aps_avail_dt timestamp without time zone,
    wh_facility_trans_onhand_nbr integer,
    wh_facility_trans_replen_nbr integer,
    wh_facility_trans_wo_nbr integer,
    src_rule_flg character varying(1),
    sply_cert_to_demand_flg character varying(1),
    explicit_mfr_flg character varying(1),
    apprv_mfr_flg character varying(1),
    attribute_cert_flg character varying(1),
    rev_lvl_flg character varying(1),
    lot_dt_flg character varying(1),
    cntry_of_origin_flg character varying(1),
    cust_subst_flg character varying(1),
    global_subst_flg character varying(1),
    equiv_flg character varying(1),
    avail_dt_type_id character varying(1),
    CONSTRAINT ards_check_avail_dt_type_id CHECK (((avail_dt_type_id)::text = ANY (ARRAY[('F'::character varying)::text, ('P'::character varying)::text]))),
    CONSTRAINT sys_c0016218 CHECK (((src_rule_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0016219 CHECK (((sply_cert_to_demand_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0016220 CHECK (((explicit_mfr_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0016221 CHECK (((apprv_mfr_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0016222 CHECK (((attribute_cert_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0016223 CHECK (((rev_lvl_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0016224 CHECK (((lot_dt_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0016225 CHECK (((cntry_of_origin_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0016226 CHECK (((cust_subst_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0016227 CHECK (((global_subst_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0016228 CHECK (((equiv_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0016230 CHECK ((avail_dt_type_id IS NOT NULL)),
    CONSTRAINT sys_c0016231 CHECK (((src_rule_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0016232 CHECK (((sply_cert_to_demand_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0016233 CHECK (((explicit_mfr_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0016234 CHECK (((apprv_mfr_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0016235 CHECK (((attribute_cert_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0016236 CHECK (((rev_lvl_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0016237 CHECK (((lot_dt_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0016238 CHECK (((cntry_of_origin_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0016239 CHECK (((cust_subst_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0016240 CHECK (((global_subst_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0016241 CHECK (((equiv_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text])))
);


ALTER TABLE aerodemo.aps_result_dtl_sply OWNER TO jjs;

--
-- Name: COLUMN aps_result_dtl_sply.wo_hdr_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_result_dtl_sply.wo_hdr_nbr IS 'The surrogate primary key for WO_HDR.';


--
-- Name: aps_rqst_dmd_fc; Type: VIEW; Schema: aerodemo; Owner: jjs
--

CREATE VIEW aerodemo.aps_rqst_dmd_fc AS
 SELECT fc_item_mast.item_nbr AS item_nbr_ord
   FROM aerodemo.fc_item_mast;


ALTER TABLE aerodemo.aps_rqst_dmd_fc OWNER TO jjs;

--
-- Name: aps_rqst_dmd_oo; Type: VIEW; Schema: aerodemo; Owner: jjs
--

CREATE VIEW aerodemo.aps_rqst_dmd_oo AS
 SELECT oe_ord_dtl.item_nbr_ord
   FROM aerodemo.oe_ord_dtl
  WHERE (((oe_ord_dtl.qty_ord - COALESCE(oe_ord_dtl.qty_ship, (0)::numeric)) > (0)::numeric) AND ((oe_ord_dtl.line_stat_id)::text = 'O'::text));


ALTER TABLE aerodemo.aps_rqst_dmd_oo OWNER TO jjs;

--
-- Name: aps_rqst_dmd_wo; Type: VIEW; Schema: aerodemo; Owner: jjs
--

CREATE VIEW aerodemo.aps_rqst_dmd_wo AS
 SELECT wod.item_nbr_component AS item_nbr_ord
   FROM aerodemo.wo_dtl wod
  WHERE (EXISTS ( SELECT 'x'::text AS text
           FROM aerodemo.wo_hdr woh
          WHERE ((woh.wo_hdr_nbr = wod.wo_hdr_nbr) AND ((woh.wo_stat_id)::text = 'O'::text) AND ((COALESCE(woh.rqst_qty, 0) - COALESCE(woh.fill_qty, 0)) > 0))));


ALTER TABLE aerodemo.aps_rqst_dmd_wo OWNER TO jjs;

--
-- Name: aps_rqst_sply_oh; Type: VIEW; Schema: aerodemo; Owner: jjs
--

CREATE VIEW aerodemo.aps_rqst_sply_oh AS
 SELECT ic_lot_mast.item_nbr AS item_nbr_rqst
   FROM aerodemo.ic_item_loc,
    aerodemo.ic_lot_mast
  WHERE (ic_item_loc.lot_nbr = ic_lot_mast.lot_nbr);


ALTER TABLE aerodemo.aps_rqst_sply_oh OWNER TO jjs;

--
-- Name: po_ord_dtl; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.po_ord_dtl (
    po_line_dtl_nbr integer NOT NULL,
    po_ord_hdr_nbr integer NOT NULL,
    po_line_hdr_nbr integer NOT NULL,
    po_line_nbr smallint NOT NULL,
    po_cd character varying(20) NOT NULL,
    po_dt timestamp without time zone NOT NULL,
    vndr_ord_cd character varying(20),
    curr_cd character varying(3) NOT NULL,
    trd_flg character varying(1) NOT NULL,
    org_nbr_vnd integer NOT NULL,
    org_cd_vnd character varying(15) NOT NULL,
    org_nm_vnd character varying(60) NOT NULL,
    vndr_ord_line_cd character varying(3),
    replen_qty numeric(13,5) NOT NULL,
    unit_cost numeric(17,6) NOT NULL,
    unit_cost_denom numeric(13,5) NOT NULL,
    sched_qty numeric(13,5) NOT NULL,
    item_nbr integer NOT NULL,
    item_cd character varying(50) NOT NULL,
    item_descr character varying(50) NOT NULL,
    stk_um character varying(3) NOT NULL,
    item_cd_vnd character varying(50),
    replen_um character varying(3) NOT NULL,
    recv_qty numeric(13,5),
    replen_est_ship_dt timestamp without time zone NOT NULL,
    replen_rqst_ship_dt timestamp without time zone NOT NULL,
    replen_curr_est_dt timestamp without time zone NOT NULL,
    rev_lvl character varying(5),
    org_nbr_mfr integer,
    org_cd_mfr character varying(15),
    org_nm_mfr character varying(60),
    line_stat_id character varying(1) NOT NULL,
    cntry_cd_origin character varying(3),
    facility character varying(16) NOT NULL,
    aps_sply_sub_pool_nbr integer NOT NULL,
    ship_via_cd character varying(8) NOT NULL,
    ship_to_addr_nbr integer NOT NULL,
    aps_sply_pool_cd character varying(20) NOT NULL,
    aps_sply_sub_pool_cd character varying(20) NOT NULL,
    ic_category_nbr integer NOT NULL,
    po_cancel_cd character varying(8),
    line_cancel_cd character varying(8),
    sched_cancel_cd character varying(8),
    reqr_mfr_flg character varying(1) NOT NULL,
    std_cost numeric(17,6),
    list_price numeric(17,6),
    indiv_nbr_buy integer NOT NULL,
    indiv_nm_seller character varying(45),
    seller_phn_nbr character varying(20),
    seller_email_addr character varying(40),
    sched_qty_stk_um numeric(13,5) NOT NULL,
    recv_qty_stk_um numeric(13,5),
    unit_cost_stk_um numeric(17,6),
    unit_cost_denom_stk_um numeric(17,6),
    ord_stat_id character varying(1) NOT NULL,
    lot_manufacture_after_dt timestamp without time zone,
    lot_not_expire_before_dt timestamp without time zone,
    aps_avail_dt timestamp without time zone,
    buy_reason_cd character varying(8)
);


ALTER TABLE aerodemo.po_ord_dtl OWNER TO jjs;

--
-- Name: COLUMN po_ord_dtl.po_line_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.po_ord_dtl.po_line_nbr IS 'Identifier for the line on the purchase order.';


--
-- Name: COLUMN po_ord_dtl.po_cd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.po_ord_dtl.po_cd IS 'Legacy purchase order code, identifies the purchase order.';


--
-- Name: COLUMN po_ord_dtl.po_dt; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.po_ord_dtl.po_dt IS 'The date the purchase order was created.';


--
-- Name: COLUMN po_ord_dtl.curr_cd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.po_ord_dtl.curr_cd IS 'The ANSI X.12 currency code associated with the unit cost for this line.';


--
-- Name: COLUMN po_ord_dtl.org_nbr_vnd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.po_ord_dtl.org_nbr_vnd IS 'The organization number of the vendor from whom the inventory was purchased.';


--
-- Name: COLUMN po_ord_dtl.org_cd_vnd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.po_ord_dtl.org_cd_vnd IS 'Identifies the organization from which this is being purchased.';


--
-- Name: COLUMN po_ord_dtl.org_nm_vnd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.po_ord_dtl.org_nm_vnd IS 'The organization name of the vendor from whom the inventory was purchased.';


--
-- Name: COLUMN po_ord_dtl.replen_qty; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.po_ord_dtl.replen_qty IS 'Replenishment quantity in the replenishment unit of measure.';


--
-- Name: COLUMN po_ord_dtl.unit_cost; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.po_ord_dtl.unit_cost IS 'Cost per unit in the replenishment unit of measure and currency.';


--
-- Name: COLUMN po_ord_dtl.item_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.po_ord_dtl.item_nbr IS 'Product identifier, reference to item master (IC_ITEM_MAST.ITEM_NBR)';


--
-- Name: COLUMN po_ord_dtl.item_cd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.po_ord_dtl.item_cd IS 'Product Number - SKU';


--
-- Name: COLUMN po_ord_dtl.item_descr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.po_ord_dtl.item_descr IS 'Description of product.';


--
-- Name: COLUMN po_ord_dtl.stk_um; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.po_ord_dtl.stk_um IS 'ANSI X.12 stock keeping unit of measure.';


--
-- Name: COLUMN po_ord_dtl.replen_um; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.po_ord_dtl.replen_um IS 'ANSI X.12 unit of measure.';


--
-- Name: COLUMN po_ord_dtl.replen_curr_est_dt; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.po_ord_dtl.replen_curr_est_dt IS 'Current estimated availability date of the schedule.';


--
-- Name: COLUMN po_ord_dtl.rev_lvl; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.po_ord_dtl.rev_lvl IS 'The revision level of a SKU required to satisfy sourcing in advanced planning.';


--
-- Name: COLUMN po_ord_dtl.org_nbr_mfr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.po_ord_dtl.org_nbr_mfr IS 'The organization number of the manufacturer, copied from the lot master (ic_lot_mast).';


--
-- Name: COLUMN po_ord_dtl.org_cd_mfr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.po_ord_dtl.org_cd_mfr IS 'Identifier for the manufacturer.';


--
-- Name: COLUMN po_ord_dtl.org_nm_mfr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.po_ord_dtl.org_nm_mfr IS 'The name of the manufacturer of the inventory as of the time the invoice was created.';


--
-- Name: COLUMN po_ord_dtl.line_stat_id; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.po_ord_dtl.line_stat_id IS 'O-Open, C-Closed, X-Cancelled';


--
-- Name: COLUMN po_ord_dtl.facility; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.po_ord_dtl.facility IS 'The facility (i.e warehouse) in which this inventory is to be shipped';


--
-- Name: COLUMN po_ord_dtl.aps_sply_sub_pool_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.po_ord_dtl.aps_sply_sub_pool_nbr IS 'a foreign key back to the primary key for the supply sub pool';


--
-- Name: COLUMN po_ord_dtl.ship_via_cd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.po_ord_dtl.ship_via_cd IS 'The shipment method, identifies the carrier and priority.';


--
-- Name: COLUMN po_ord_dtl.std_cost; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.po_ord_dtl.std_cost IS 'Standard cost in base currency for the stock keeping unit of measure.';


--
-- Name: COLUMN po_ord_dtl.unit_cost_stk_um; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.po_ord_dtl.unit_cost_stk_um IS 'cost per unit in the base currency for the stock keeping unit of measure';


--
-- Name: COLUMN po_ord_dtl.unit_cost_denom_stk_um; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.po_ord_dtl.unit_cost_denom_stk_um IS 'cost per unit in the base currency for the stock keeping unit of measure';


--
-- Name: aps_rqst_sply_po; Type: VIEW; Schema: aerodemo; Owner: jjs
--

CREATE VIEW aerodemo.aps_rqst_sply_po AS
 SELECT po_ord_dtl.item_nbr AS item_nbr_rqst
   FROM aerodemo.po_ord_dtl
  WHERE (((po_ord_dtl.sched_qty - COALESCE(po_ord_dtl.recv_qty, (0)::numeric)) > (0)::numeric) AND ((po_ord_dtl.line_stat_id)::text = 'O'::text) AND (po_ord_dtl.sched_cancel_cd IS NULL));


ALTER TABLE aerodemo.aps_rqst_sply_po OWNER TO jjs;

--
-- Name: aps_rqst_sply_wo; Type: VIEW; Schema: aerodemo; Owner: jjs
--

CREATE VIEW aerodemo.aps_rqst_sply_wo AS
 SELECT wo_hdr.item_nbr_rqst
   FROM aerodemo.wo_hdr
  WHERE (((wo_hdr.rqst_qty - COALESCE(wo_hdr.fill_qty, 0)) > 0) AND ((wo_hdr.wo_stat_id)::text = 'O'::text));


ALTER TABLE aerodemo.aps_rqst_sply_wo OWNER TO jjs;

--
-- Name: aps_rqst_dtl; Type: VIEW; Schema: aerodemo; Owner: jjs
--

CREATE VIEW aerodemo.aps_rqst_dtl AS
 SELECT aps_rqst_dmd_oo.item_nbr_ord AS item_nbr,
    'Y'::character varying AS dmd_oo_flg,
    NULL::character varying AS dmd_fc_flg,
    NULL::character varying AS dmd_wo_flg,
    NULL::character varying AS sply_oh_flg,
    NULL::character varying AS sply_po_flg,
    NULL::character varying AS sply_wo_flg
   FROM aerodemo.aps_rqst_dmd_oo
UNION ALL
 SELECT aps_rqst_dmd_fc.item_nbr_ord AS item_nbr,
    NULL::character varying AS dmd_oo_flg,
    'Y'::character varying AS dmd_fc_flg,
    NULL::character varying AS dmd_wo_flg,
    NULL::character varying AS sply_oh_flg,
    NULL::character varying AS sply_po_flg,
    NULL::character varying AS sply_wo_flg
   FROM aerodemo.aps_rqst_dmd_fc
UNION ALL
 SELECT aps_rqst_dmd_wo.item_nbr_ord AS item_nbr,
    NULL::character varying AS dmd_oo_flg,
    NULL::character varying AS dmd_fc_flg,
    'Y'::character varying AS dmd_wo_flg,
    NULL::character varying AS sply_oh_flg,
    NULL::character varying AS sply_po_flg,
    NULL::character varying AS sply_wo_flg
   FROM aerodemo.aps_rqst_dmd_wo
UNION ALL
 SELECT aps_rqst_sply_oh.item_nbr_rqst AS item_nbr,
    NULL::character varying AS dmd_oo_flg,
    NULL::character varying AS dmd_fc_flg,
    NULL::character varying AS dmd_wo_flg,
    'Y'::character varying AS sply_oh_flg,
    NULL::character varying AS sply_po_flg,
    NULL::character varying AS sply_wo_flg
   FROM aerodemo.aps_rqst_sply_oh
UNION ALL
 SELECT aps_rqst_sply_po.item_nbr_rqst AS item_nbr,
    NULL::character varying AS dmd_oo_flg,
    NULL::character varying AS dmd_fc_flg,
    NULL::character varying AS dmd_wo_flg,
    NULL::character varying AS sply_oh_flg,
    'Y'::character varying AS sply_po_flg,
    NULL::character varying AS sply_wo_flg
   FROM aerodemo.aps_rqst_sply_po
UNION ALL
 SELECT aps_rqst_sply_wo.item_nbr_rqst AS item_nbr,
    NULL::character varying AS dmd_oo_flg,
    NULL::character varying AS dmd_fc_flg,
    NULL::character varying AS dmd_wo_flg,
    NULL::character varying AS sply_oh_flg,
    NULL::character varying AS sply_po_flg,
    'Y'::character varying AS sply_wo_flg
   FROM aerodemo.aps_rqst_sply_wo;


ALTER TABLE aerodemo.aps_rqst_dtl OWNER TO jjs;

--
-- Name: COLUMN aps_rqst_dtl.item_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_rqst_dtl.item_nbr IS 'Product identifier, reference to item master (IC_ITEM_MAST.ITEM_NBR)';


--
-- Name: aps_rqst_grp; Type: VIEW; Schema: aerodemo; Owner: jjs
--

CREATE VIEW aerodemo.aps_rqst_grp AS
 SELECT aps_rqst_dtl.item_nbr,
    COALESCE(max((aps_rqst_dtl.dmd_oo_flg)::text), 'N'::text) AS dmd_oo_flg,
    COALESCE(max((aps_rqst_dtl.dmd_fc_flg)::text), 'N'::text) AS dmd_fc_flg,
    COALESCE(max((aps_rqst_dtl.dmd_wo_flg)::text), 'N'::text) AS dmd_wo_flg,
    COALESCE(max((aps_rqst_dtl.sply_oh_flg)::text), 'N'::text) AS sply_oh_flg,
    COALESCE(max((aps_rqst_dtl.sply_po_flg)::text), 'N'::text) AS sply_po_flg,
    COALESCE(max((aps_rqst_dtl.sply_wo_flg)::text), 'N'::text) AS sply_wo_flg
   FROM aerodemo.aps_rqst_dtl
  GROUP BY aps_rqst_dtl.item_nbr;


ALTER TABLE aerodemo.aps_rqst_grp OWNER TO jjs;

--
-- Name: COLUMN aps_rqst_grp.item_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_rqst_grp.item_nbr IS 'Product identifier, reference to item master (IC_ITEM_MAST.ITEM_NBR)';


--
-- Name: aps_rqst_queue; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.aps_rqst_queue (
    item_nbr integer NOT NULL,
    dmd_oo_flg character varying(1),
    dmd_fc_flg character varying(1),
    dmd_wo_flg character varying(1),
    sply_oh_flg character varying(1),
    sply_po_flg character varying(1),
    sply_wo_flg character varying(1),
    rqst_tm timestamp without time zone DEFAULT ('now'::text)::timestamp without time zone NOT NULL,
    aps_exception character varying(2048),
    item_prty smallint DEFAULT 9 NOT NULL,
    dispatch_tm timestamp without time zone,
    rqst_src character varying(61) DEFAULT 'UNKNOWN'::character varying NOT NULL
);


ALTER TABLE aerodemo.aps_rqst_queue OWNER TO jjs;

--
-- Name: COLUMN aps_rqst_queue.item_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_rqst_queue.item_nbr IS 'Product identifier, reference to item master (IC_ITEM_MAST.ITEM_NBR)';


--
-- Name: aps_rqst_queue_vw; Type: VIEW; Schema: aerodemo; Owner: jjs
--

CREATE VIEW aerodemo.aps_rqst_queue_vw AS
 SELECT aps_rqst_queue.item_nbr,
    max((aps_rqst_queue.dmd_oo_flg)::text) AS dmd_oo_flg,
    max((aps_rqst_queue.dmd_fc_flg)::text) AS dmd_fc_flg,
    max((aps_rqst_queue.dmd_wo_flg)::text) AS dmd_wo_flg,
    max((aps_rqst_queue.sply_oh_flg)::text) AS sply_oh_flg,
    max((aps_rqst_queue.sply_po_flg)::text) AS sply_po_flg,
    max((aps_rqst_queue.sply_wo_flg)::text) AS sply_wo_flg,
    min(aps_rqst_queue.rqst_tm) AS rqst_tm
   FROM aerodemo.aps_rqst_queue
  WHERE (aps_rqst_queue.aps_exception IS NULL)
  GROUP BY aps_rqst_queue.item_nbr
  ORDER BY (max((aps_rqst_queue.dmd_oo_flg)::text)) DESC, (max((aps_rqst_queue.dmd_wo_flg)::text)) DESC, (max((aps_rqst_queue.dmd_fc_flg)::text)) DESC, (max((aps_rqst_queue.sply_po_flg)::text)) DESC, (max((aps_rqst_queue.sply_wo_flg)::text)) DESC, (max((aps_rqst_queue.sply_oh_flg)::text)) DESC, aps_rqst_queue.item_nbr;


ALTER TABLE aerodemo.aps_rqst_queue_vw OWNER TO jjs;

--
-- Name: aps_sply_pool; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.aps_sply_pool (
    aps_sply_pool_cd character varying(20) NOT NULL,
    aps_sply_pool_descr character varying(60),
    ut_user_nbr integer,
    last_mod_dt timestamp without time zone,
    aps_sply_pool_stat_id character varying(1) DEFAULT 'A'::character varying,
    CONSTRAINT sys_c0015969 CHECK ((ut_user_nbr IS NOT NULL)),
    CONSTRAINT sys_c0015970 CHECK ((last_mod_dt IS NOT NULL)),
    CONSTRAINT sys_c0015971 CHECK ((aps_sply_pool_stat_id IS NOT NULL)),
    CONSTRAINT sys_c0015972 CHECK (((aps_sply_pool_stat_id)::text = ANY (ARRAY[('A'::character varying)::text, ('I'::character varying)::text]))),
    CONSTRAINT sys_c0015973 CHECK (((aps_sply_pool_stat_id)::text = ANY (ARRAY[('A'::character varying)::text, ('I'::character varying)::text])))
);


ALTER TABLE aerodemo.aps_sply_pool OWNER TO jjs;

--
-- Name: COLUMN aps_sply_pool.ut_user_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_sply_pool.ut_user_nbr IS 'Surrogate primary key for UT_USER';


--
-- Name: aps_sply_sub_pool_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.aps_sply_sub_pool_nbr_seq
    START WITH 335
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.aps_sply_sub_pool_nbr_seq OWNER TO jjs;

--
-- Name: aps_src_rule; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.aps_src_rule (
    aps_src_rule_nbr integer NOT NULL,
    aps_src_rule_set_nbr integer NOT NULL,
    aps_sply_sub_pool_nbr integer NOT NULL,
    facility character varying(16) NOT NULL,
    sply_type_id character varying(1) NOT NULL,
    src_prty smallint NOT NULL,
    ut_user_nbr integer NOT NULL,
    last_mod_dt timestamp without time zone NOT NULL,
    CONSTRAINT sys_c0015020 CHECK ((aps_src_rule_nbr IS NOT NULL)),
    CONSTRAINT sys_c0015021 CHECK ((aps_src_rule_set_nbr IS NOT NULL)),
    CONSTRAINT sys_c0015022 CHECK ((aps_sply_sub_pool_nbr IS NOT NULL)),
    CONSTRAINT sys_c0015023 CHECK ((facility IS NOT NULL)),
    CONSTRAINT sys_c0015024 CHECK ((sply_type_id IS NOT NULL)),
    CONSTRAINT sys_c0015025 CHECK ((src_prty IS NOT NULL)),
    CONSTRAINT sys_c0015026 CHECK ((ut_user_nbr IS NOT NULL)),
    CONSTRAINT sys_c0015027 CHECK ((last_mod_dt IS NOT NULL)),
    CONSTRAINT sys_c0015028 CHECK (((sply_type_id)::text = ANY (ARRAY[('O'::character varying)::text, ('R'::character varying)::text, ('L'::character varying)::text, ('W'::character varying)::text]))),
    CONSTRAINT sys_c0015029 CHECK (((sply_type_id)::text = ANY (ARRAY[('O'::character varying)::text, ('R'::character varying)::text, ('L'::character varying)::text, ('W'::character varying)::text]))),
    CONSTRAINT sys_c0015030 CHECK (((sply_type_id)::text = ANY (ARRAY[('O'::character varying)::text, ('R'::character varying)::text, ('L'::character varying)::text, ('W'::character varying)::text]))),
    CONSTRAINT sys_c0016588 CHECK (((sply_type_id)::text = ANY (ARRAY[('O'::character varying)::text, ('R'::character varying)::text, ('L'::character varying)::text, ('W'::character varying)::text]))),
    CONSTRAINT sys_c0016589 CHECK (((sply_type_id)::text = ANY (ARRAY[('O'::character varying)::text, ('R'::character varying)::text, ('L'::character varying)::text, ('W'::character varying)::text])))
);


ALTER TABLE aerodemo.aps_src_rule OWNER TO jjs;

--
-- Name: COLUMN aps_src_rule.aps_sply_sub_pool_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_src_rule.aps_sply_sub_pool_nbr IS 'a foreign key back to the primary key for the supply sub pool';


--
-- Name: COLUMN aps_src_rule.facility; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_src_rule.facility IS 'The facility associated with this record.  ';


--
-- Name: COLUMN aps_src_rule.ut_user_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_src_rule.ut_user_nbr IS 'Surrogate primary key for UT_USER';


--
-- Name: aps_src_rule_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.aps_src_rule_nbr_seq
    START WITH 1943
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.aps_src_rule_nbr_seq OWNER TO jjs;

--
-- Name: aps_src_rule_primary; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.aps_src_rule_primary (
    aps_src_rule_set_nbr integer NOT NULL,
    aps_src_rule_nbr integer NOT NULL
);


ALTER TABLE aerodemo.aps_src_rule_primary OWNER TO jjs;

--
-- Name: aps_src_rule_replen; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.aps_src_rule_replen (
    aps_src_rule_set_nbr integer,
    aps_src_rule_nbr integer
);


ALTER TABLE aerodemo.aps_src_rule_replen OWNER TO jjs;

--
-- Name: aps_src_rule_set; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.aps_src_rule_set (
    aps_src_rule_set_nbr integer NOT NULL,
    aps_src_rule_set_cd character varying(20) NOT NULL,
    aps_src_rule_set_descr character varying(60),
    ut_user_nbr integer NOT NULL,
    last_mod_dt timestamp without time zone NOT NULL,
    facility_fcst_consume character varying(16) NOT NULL,
    aps_sply_pool_cd_fcst_consume character varying(20) NOT NULL,
    src_rule_set_stat_id character varying(1) NOT NULL,
    CONSTRAINT check_src_rule_set_stat_id CHECK (((src_rule_set_stat_id)::text = ANY (ARRAY[('A'::character varying)::text, ('I'::character varying)::text]))),
    CONSTRAINT sys_c0015047 CHECK ((aps_src_rule_set_nbr IS NOT NULL)),
    CONSTRAINT sys_c0015048 CHECK ((aps_src_rule_set_cd IS NOT NULL)),
    CONSTRAINT sys_c0015049 CHECK ((ut_user_nbr IS NOT NULL)),
    CONSTRAINT sys_c0015050 CHECK ((last_mod_dt IS NOT NULL)),
    CONSTRAINT sys_c0015051 CHECK ((facility_fcst_consume IS NOT NULL)),
    CONSTRAINT sys_c0015052 CHECK ((aps_sply_pool_cd_fcst_consume IS NOT NULL)),
    CONSTRAINT sys_c0015053 CHECK ((src_rule_set_stat_id IS NOT NULL))
);


ALTER TABLE aerodemo.aps_src_rule_set OWNER TO jjs;

--
-- Name: COLUMN aps_src_rule_set.ut_user_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_src_rule_set.ut_user_nbr IS 'Surrogate primary key for UT_USER';


--
-- Name: COLUMN aps_src_rule_set.src_rule_set_stat_id; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.aps_src_rule_set.src_rule_set_stat_id IS 'A-Active, I-Inactive';


--
-- Name: aps_src_rule_set_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.aps_src_rule_set_nbr_seq
    START WITH 667
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.aps_src_rule_set_nbr_seq OWNER TO jjs;

--
-- Name: aps_summary_dat_amt_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.aps_summary_dat_amt_nbr_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.aps_summary_dat_amt_nbr_seq OWNER TO jjs;

--
-- Name: aps_summary_dat_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.aps_summary_dat_nbr_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.aps_summary_dat_nbr_seq OWNER TO jjs;

--
-- Name: ar_inv_batch_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.ar_inv_batch_nbr_seq
    START WITH 380512
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.ar_inv_batch_nbr_seq OWNER TO jjs;

--
-- Name: ar_inv_dtl; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.ar_inv_dtl (
    ar_inv_dtl_nbr integer NOT NULL,
    inv_cd character varying(20) NOT NULL,
    line_nbr smallint NOT NULL,
    ord_cd character varying(20) NOT NULL,
    oe_ord_dtl_nbr integer NOT NULL,
    line_nbr_ord smallint NOT NULL,
    cust_po_cd character varying(30),
    cust_line_cd character varying(5),
    item_nbr integer NOT NULL,
    item_cd character varying(50) NOT NULL,
    item_descr character varying(50) NOT NULL,
    ship_to_addr_nbr integer NOT NULL,
    ship_to_addr_cd character varying(16) NOT NULL,
    sell_um character varying(3) NOT NULL,
    qty_open numeric(13,5) NOT NULL,
    qty_ship numeric(13,5) NOT NULL,
    lot_nbr integer NOT NULL,
    org_nbr_vnd integer NOT NULL,
    org_nm_vnd character varying(60) NOT NULL,
    org_nbr_mfr integer,
    org_nm_mfr character varying(60),
    mfr_lot_cd character varying(20),
    rev_lvl character varying(5),
    unit_cost_stk_um numeric(17,6),
    unit_cost_denom_stk_um numeric(17,6),
    unit_cost_sell_um numeric(17,6),
    unit_cost_denom_sell_um numeric(17,6),
    unit_price_stk_um numeric(17,6),
    unit_price_denom_stk_um numeric(17,6),
    unit_price_sell_um numeric(17,6),
    unit_price_denom_sell_um numeric(17,6),
    tie_cd character varying(1),
    contract_cd character varying(8),
    cust_bin_cd character varying(40),
    aps_sply_sub_pool_nbr integer NOT NULL,
    facility character varying(16) NOT NULL,
    org_cd_mfr character varying(15),
    org_cd_vnd character varying(15) NOT NULL,
    qty_open_stk_um numeric(13,5) NOT NULL,
    qty_ship_stk_um numeric(13,5) NOT NULL,
    bin_cd character varying(16),
    ic_category_nbr integer,
    ic_category_nm character varying(16),
    ic_category_descr character varying(60),
    cust_bin_cd_new character varying(40)
);


ALTER TABLE aerodemo.ar_inv_dtl OWNER TO jjs;

--
-- Name: TABLE ar_inv_dtl; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON TABLE aerodemo.ar_inv_dtl IS 'The surrogate primary key for this table';


--
-- Name: COLUMN ar_inv_dtl.ar_inv_dtl_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ar_inv_dtl.ar_inv_dtl_nbr IS 'The surrogate primary key for this table.';


--
-- Name: COLUMN ar_inv_dtl.inv_cd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ar_inv_dtl.inv_cd IS 'Foreign key back to the invoice header';


--
-- Name: COLUMN ar_inv_dtl.line_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ar_inv_dtl.line_nbr IS 'The invoice line number.';


--
-- Name: COLUMN ar_inv_dtl.ord_cd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ar_inv_dtl.ord_cd IS 'The order code generated by order entry for the order.
This will be the same for all lines on an invoice.';


--
-- Name: COLUMN ar_inv_dtl.oe_ord_dtl_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ar_inv_dtl.oe_ord_dtl_nbr IS 'A foreign key back to the order detail.';


--
-- Name: COLUMN ar_inv_dtl.line_nbr_ord; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ar_inv_dtl.line_nbr_ord IS 'The line number on the customer order.';


--
-- Name: COLUMN ar_inv_dtl.cust_po_cd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ar_inv_dtl.cust_po_cd IS 'The customer purchase order number.';


--
-- Name: COLUMN ar_inv_dtl.cust_line_cd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ar_inv_dtl.cust_line_cd IS 'The line number from the customer purchase order.';


--
-- Name: COLUMN ar_inv_dtl.item_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ar_inv_dtl.item_nbr IS 'A foreign key back to the item master.';


--
-- Name: COLUMN ar_inv_dtl.item_cd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ar_inv_dtl.item_cd IS 'The item code at the time the order was invoiced.
Subsequent changes to the the item code on the item master on not reflected here, to facilitate reprinting of invoices.';


--
-- Name: COLUMN ar_inv_dtl.item_descr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ar_inv_dtl.item_descr IS 'The description from the item master at the time the invoice was created';


--
-- Name: COLUMN ar_inv_dtl.ship_to_addr_cd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ar_inv_dtl.ship_to_addr_cd IS 'The code assigned to the billing address at the time the invoice was created.
Will not reflect changes made to the address code after invoice creation.';


--
-- Name: COLUMN ar_inv_dtl.sell_um; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ar_inv_dtl.sell_um IS 'Selling unit of measure.';


--
-- Name: COLUMN ar_inv_dtl.qty_open; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ar_inv_dtl.qty_open IS 'qty open at the time the invoice was created in the order unit of measure.';


--
-- Name: COLUMN ar_inv_dtl.qty_ship; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ar_inv_dtl.qty_ship IS 'the quantity shipped for this invoice line in the stock keeping unit of measure.';


--
-- Name: COLUMN ar_inv_dtl.lot_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ar_inv_dtl.lot_nbr IS 'The lot which was shipped, a foreign key back to the primary surrogate key in ic_lot_mast.';


--
-- Name: COLUMN ar_inv_dtl.org_nbr_vnd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ar_inv_dtl.org_nbr_vnd IS 'The organization number of the vendor from whom the inventory was purchased.';


--
-- Name: COLUMN ar_inv_dtl.org_nm_vnd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ar_inv_dtl.org_nm_vnd IS 'The organization name of the vendor from whom the inventory was purchased.';


--
-- Name: COLUMN ar_inv_dtl.org_nbr_mfr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ar_inv_dtl.org_nbr_mfr IS 'The organization number of the manufacturer, copied from the lot master (ic_lot_mast).';


--
-- Name: COLUMN ar_inv_dtl.org_nm_mfr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ar_inv_dtl.org_nm_mfr IS 'The name of the manufacturer of the inventory as of the time the invoice was created.';


--
-- Name: COLUMN ar_inv_dtl.mfr_lot_cd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ar_inv_dtl.mfr_lot_cd IS 'The manufacturer lot code from the lot master.';


--
-- Name: COLUMN ar_inv_dtl.rev_lvl; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ar_inv_dtl.rev_lvl IS 'The revision level of the part from the lot master or ic_multiple_cert_rev_lvl.';


--
-- Name: COLUMN ar_inv_dtl.unit_cost_stk_um; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ar_inv_dtl.unit_cost_stk_um IS 'cost per unit in the base currency for the stock keeping unit of measure';


--
-- Name: COLUMN ar_inv_dtl.unit_cost_denom_stk_um; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ar_inv_dtl.unit_cost_denom_stk_um IS 'cost per unit in the base currency for the stock keeping unit of measure';


--
-- Name: COLUMN ar_inv_dtl.unit_cost_sell_um; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ar_inv_dtl.unit_cost_sell_um IS 'cost per unit in the base currency for the selling unit of measure';


--
-- Name: COLUMN ar_inv_dtl.unit_cost_denom_sell_um; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ar_inv_dtl.unit_cost_denom_sell_um IS 'cost per unit in the denodminat currency for the selling unit of measure';


--
-- Name: COLUMN ar_inv_dtl.tie_cd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ar_inv_dtl.tie_cd IS 'The tie code from the order line.';


--
-- Name: COLUMN ar_inv_dtl.contract_cd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ar_inv_dtl.contract_cd IS 'The contract code, from the order detail line under which the goods were purchased.';


--
-- Name: COLUMN ar_inv_dtl.cust_bin_cd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ar_inv_dtl.cust_bin_cd IS 'The customer bin for which the inventory was destined.';


--
-- Name: COLUMN ar_inv_dtl.aps_sply_sub_pool_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ar_inv_dtl.aps_sply_sub_pool_nbr IS 'a foreign key back to the primary key for the supply sub pool';


--
-- Name: COLUMN ar_inv_dtl.facility; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ar_inv_dtl.facility IS 'the facility from which the inventory was shipped.';


--
-- Name: COLUMN ar_inv_dtl.org_cd_mfr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ar_inv_dtl.org_cd_mfr IS 'Identifier for the manufacturer.';


--
-- Name: COLUMN ar_inv_dtl.org_cd_vnd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ar_inv_dtl.org_cd_vnd IS 'Identifies the organization from which this is being purchased.';


--
-- Name: COLUMN ar_inv_dtl.bin_cd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ar_inv_dtl.bin_cd IS 'The identifier for the location within the facility for this inventory.';


--
-- Name: COLUMN ar_inv_dtl.ic_category_nm; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ar_inv_dtl.ic_category_nm IS 'The category associated with this product.';


--
-- Name: ar_inv_dtl_charge_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.ar_inv_dtl_charge_nbr_seq
    START WITH 3799
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.ar_inv_dtl_charge_nbr_seq OWNER TO jjs;

--
-- Name: ar_inv_dtl_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.ar_inv_dtl_nbr_seq
    START WITH 2458961
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.ar_inv_dtl_nbr_seq OWNER TO jjs;

--
-- Name: ar_inv_hdr; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.ar_inv_hdr (
    inv_cd character varying(20) NOT NULL,
    inv_dt timestamp without time zone NOT NULL,
    inv_stat_id character varying(1) NOT NULL,
    org_nbr_cust integer NOT NULL,
    org_nm_cust character varying(60) NOT NULL,
    oe_ord_hdr_nbr integer NOT NULL,
    ord_cd character varying(20) NOT NULL,
    cust_po_cd character varying(30),
    curr_cd character varying(3) NOT NULL,
    ship_dt timestamp without time zone NOT NULL,
    bill_to_addr_nbr integer NOT NULL,
    bill_to_addr_cd character varying(8) NOT NULL,
    bill_to_addr_descr character varying(60),
    bill_to_addr_1 character varying(30),
    bill_to_addr_2 character varying(30),
    bill_to_addr_3 character varying(30),
    bill_to_city character varying(25),
    bill_to_state_cd character varying(5),
    bill_to_postal_cd character varying(10),
    bill_to_cntry_cd character varying(3),
    ship_to_addr_nbr integer NOT NULL,
    ship_to_addr_cd character varying(8) NOT NULL,
    ship_to_addr_descr character varying(60),
    ship_to_addr_1 character varying(30),
    ship_to_addr_2 character varying(30),
    ship_to_addr_3 character varying(30),
    ship_to_city character varying(25),
    ship_to_state_cd character varying(5),
    ship_to_postal_cd character varying(10),
    ship_to_cntry_cd character varying(3),
    ship_via_cd character varying(8) NOT NULL,
    term_cd character varying(10) NOT NULL,
    gross_inv_value numeric(17,5) NOT NULL,
    wght numeric(10,3),
    ctn_cnt integer,
    frgt_charge numeric(11,2),
    net_inv_value numeric(17,5),
    waybill_cd character varying(20),
    trd_flg character varying(1) NOT NULL,
    ar_inv_batch_nbr integer,
    fob_cd character varying(8),
    org_cd_cust character varying(15) NOT NULL,
    sales_terr_cd character varying(8) NOT NULL,
    sell_indiv_nbr integer,
    ar_summary_inv_nbr integer,
    gl_tax_grp_nbr integer,
    print_flg character varying(1) DEFAULT 'N'::character varying NOT NULL,
    inv_print_dt_orig timestamp without time zone,
    inv_print_dt_last timestamp without time zone,
    ut_user_nbr_print integer,
    ord_type_cd character varying(8) NOT NULL,
    summary_inv_ref character varying(30),
    CONSTRAINT arih_check_inv_stat_id CHECK (((inv_stat_id)::text = ANY (ARRAY[('N'::character varying)::text, ('W'::character varying)::text, ('R'::character varying)::text, ('E'::character varying)::text, ('P'::character varying)::text, ('T'::character varying)::text, ('F'::character varying)::text]))),
    CONSTRAINT sys_c0015863 CHECK (((trd_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0015864 CHECK (((print_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text])))
);


ALTER TABLE aerodemo.ar_inv_hdr OWNER TO jjs;

--
-- Name: TABLE ar_inv_hdr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON TABLE aerodemo.ar_inv_hdr IS 'In invoice review the bill to address, ship to address, terms code and trading flag may be changed on the invoice header.
The following G/L transactions should be effected.Credit Receiving Expense';


--
-- Name: COLUMN ar_inv_hdr.inv_cd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ar_inv_hdr.inv_cd IS 'This is the Unique Invoice Number assigned to each Invoice. System Generated using a Function GET_INV_CD.
Specifics of the format of he';


--
-- Name: COLUMN ar_inv_hdr.inv_dt; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ar_inv_hdr.inv_dt IS 'The Date the Invoice was created.
This is not the date the inventory was shipped.
If the inventory is shipped on the last day of the month and invoice posting doesn''t occur until the following month, then the revenue
is not recognized.';


--
-- Name: COLUMN ar_inv_hdr.inv_stat_id; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ar_inv_hdr.inv_stat_id IS 'The Status of the Invoice. This can be one of N-New,';


--
-- Name: COLUMN ar_inv_hdr.org_nbr_cust; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ar_inv_hdr.org_nbr_cust IS 'The foreign key to the customer organization master surrogate primary key.';


--
-- Name: COLUMN ar_inv_hdr.org_nm_cust; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ar_inv_hdr.org_nm_cust IS 'The name of the organization from the order header.
In order entry this defaults to the name of the organization from the org master';


--
-- Name: COLUMN ar_inv_hdr.oe_ord_hdr_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ar_inv_hdr.oe_ord_hdr_nbr IS 'A foreign key to the surrogate primary key of the customer order header.';


--
-- Name: COLUMN ar_inv_hdr.ord_cd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ar_inv_hdr.ord_cd IS 'The order code generated by order entry for the order.';


--
-- Name: COLUMN ar_inv_hdr.cust_po_cd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ar_inv_hdr.cust_po_cd IS 'The purchase order number assigned by the customer.
This purchase order number may appear on multiple customer orders.';


--
-- Name: COLUMN ar_inv_hdr.curr_cd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ar_inv_hdr.curr_cd IS 'The currency code in which the order was placed.
Tony wants to restrict each customer to only one currency code.';


--
-- Name: COLUMN ar_inv_hdr.ship_dt; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ar_inv_hdr.ship_dt IS 'The date the inventory was shipped.';


--
-- Name: COLUMN ar_inv_hdr.bill_to_addr_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ar_inv_hdr.bill_to_addr_nbr IS 'A foreign key to the surrogate primary key for the address for the customer.';


--
-- Name: COLUMN ar_inv_hdr.bill_to_addr_cd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ar_inv_hdr.bill_to_addr_cd IS 'The code assigned to the billing address at the time the invoice was created.
Will not reflect changes made to the address code after invoice creation.';


--
-- Name: COLUMN ar_inv_hdr.bill_to_addr_descr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ar_inv_hdr.bill_to_addr_descr IS 'The description of the bill to address copied from the address of record for the order.';


--
-- Name: COLUMN ar_inv_hdr.ship_via_cd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ar_inv_hdr.ship_via_cd IS 'The ship via code used at the time the shipment was made.';


--
-- Name: COLUMN ar_inv_hdr.term_cd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ar_inv_hdr.term_cd IS 'The payment terms, copied from the order at the time the invoice was created.
May be changed in invoice review prior to posting.';


--
-- Name: COLUMN ar_inv_hdr.waybill_cd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ar_inv_hdr.waybill_cd IS 'The waybill code assigned by the carrier at the time the invoice was created.';


--
-- Name: COLUMN ar_inv_hdr.trd_flg; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ar_inv_hdr.trd_flg IS '''Y'' this is a trade.
This may only be made ''Y'' if the customer is a trading partner.May be changed during "invoice review"';


--
-- Name: ar_inv_hdr_charge_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.ar_inv_hdr_charge_nbr_seq
    START WITH 184637
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.ar_inv_hdr_charge_nbr_seq OWNER TO jjs;

--
-- Name: ar_payment_rcpt_apply_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.ar_payment_rcpt_apply_nbr_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.ar_payment_rcpt_apply_nbr_seq OWNER TO jjs;

--
-- Name: ar_payment_rcpt_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.ar_payment_rcpt_nbr_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.ar_payment_rcpt_nbr_seq OWNER TO jjs;

--
-- Name: ar_rma_dtl; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.ar_rma_dtl (
    ar_rma_dtl_nbr integer NOT NULL,
    rma_cd character varying(20) NOT NULL,
    ar_rma_line_nbr smallint NOT NULL,
    rma_reason_cd character varying(8),
    ar_inv_dtl_nbr integer NOT NULL,
    item_nbr integer NOT NULL,
    item_cd character varying(50) NOT NULL,
    item_descr character varying(50) NOT NULL,
    sell_um character varying(3),
    qty_rtrn_auth numeric(13,5),
    qty_rtrn_auth_stk_um numeric(13,5),
    qty_received numeric(13,5),
    qty_received_stk_um numeric(13,5),
    qty_accepted numeric(13,5),
    qty_accepted_stk_um numeric(13,5),
    qty_credited numeric(13,5),
    qty_credited_stk_um numeric(13,5),
    unit_price_stk_um numeric(17,6),
    unit_price_denom_stk_um numeric(17,6),
    unit_price_sell_um numeric(17,6),
    unit_price_denom_sell_um numeric(17,6),
    credit_price_denom numeric(17,6),
    credit_price numeric(17,6),
    ut_user_nbr integer NOT NULL,
    last_mod_dt timestamp without time zone NOT NULL,
    unit_cost_stk_um numeric(17,6),
    unit_cost_denom_stk_um numeric(17,6),
    unit_cost_sell_um numeric(17,6),
    unit_cost_denom_sell_um numeric(17,6)
);


ALTER TABLE aerodemo.ar_rma_dtl OWNER TO jjs;

--
-- Name: COLUMN ar_rma_dtl.ar_inv_dtl_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ar_rma_dtl.ar_inv_dtl_nbr IS 'The surrogate primary key for this table.';


--
-- Name: COLUMN ar_rma_dtl.item_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ar_rma_dtl.item_nbr IS 'Product identifier, reference to item master (IC_ITEM_MAST.ITEM_NBR)';


--
-- Name: COLUMN ar_rma_dtl.item_cd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ar_rma_dtl.item_cd IS 'The item code at the time the order was invoiced.  Subsequent changes to the the item code on column the item master on not reflected here, to facilitate reprinting of invoices.';


--
-- Name: COLUMN ar_rma_dtl.item_descr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ar_rma_dtl.item_descr IS 'The description from the item master at the time the invoice was created';


--
-- Name: COLUMN ar_rma_dtl.sell_um; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ar_rma_dtl.sell_um IS 'ANSI X.12 unit of measure associated with the quantity ordered.';


--
-- Name: COLUMN ar_rma_dtl.ut_user_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ar_rma_dtl.ut_user_nbr IS 'Surrogate primary key for UT_USER';


--
-- Name: COLUMN ar_rma_dtl.unit_cost_stk_um; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ar_rma_dtl.unit_cost_stk_um IS 'cost per unit in the base currency for the stock keeping unit of measure';


--
-- Name: COLUMN ar_rma_dtl.unit_cost_denom_stk_um; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ar_rma_dtl.unit_cost_denom_stk_um IS 'cost per unit in the base currency for the stock keeping unit of measure';


--
-- Name: COLUMN ar_rma_dtl.unit_cost_sell_um; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ar_rma_dtl.unit_cost_sell_um IS 'cost per unit in the base currency for the selling unit of measure';


--
-- Name: COLUMN ar_rma_dtl.unit_cost_denom_sell_um; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ar_rma_dtl.unit_cost_denom_sell_um IS 'cost per unit in the denodminat currency for the selling unit of measure';


--
-- Name: ar_rma_dtl_charge_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.ar_rma_dtl_charge_nbr_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.ar_rma_dtl_charge_nbr_seq OWNER TO jjs;

--
-- Name: ar_rma_dtl_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.ar_rma_dtl_nbr_seq
    START WITH 34137
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.ar_rma_dtl_nbr_seq OWNER TO jjs;

--
-- Name: ar_rma_rcpt; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.ar_rma_rcpt (
    ar_rma_rcpt_nbr integer NOT NULL,
    rcpt_dt timestamp without time zone NOT NULL,
    ar_rma_dtl_nbr integer,
    org_nbr_cust integer,
    item_nbr integer NOT NULL,
    qty_received numeric(13,5) NOT NULL,
    qty_received_stk_um numeric(13,5) NOT NULL,
    qty_accepted numeric(13,5),
    qty_accepted_stk_um numeric(13,5),
    rma_um character varying(3) NOT NULL,
    bin_nbr_stage integer,
    rma_comments character varying(255),
    rcpt_stat_id character varying(1) NOT NULL,
    lot_nbr_recv integer,
    facility_recv character varying(16),
    aps_sply_sub_pool_nbr_recv integer,
    ut_user_nbr_recv integer NOT NULL,
    ut_user_nbr_inspect integer,
    process_dt timestamp without time zone,
    ut_user_nbr integer NOT NULL,
    last_mod_dt timestamp without time zone NOT NULL,
    lot_cost_landed numeric(13,6),
    ic_trans_gl_nbr integer
);


ALTER TABLE aerodemo.ar_rma_rcpt OWNER TO jjs;

--
-- Name: COLUMN ar_rma_rcpt.rcpt_dt; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ar_rma_rcpt.rcpt_dt IS 'The date this inventory was received.';


--
-- Name: COLUMN ar_rma_rcpt.org_nbr_cust; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ar_rma_rcpt.org_nbr_cust IS 'Reference to the customer (OE_CUST_MAST.ORG_NBR_CUST';


--
-- Name: COLUMN ar_rma_rcpt.item_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ar_rma_rcpt.item_nbr IS 'Product identifier, reference to item master (IC_ITEM_MAST.ITEM_NBR)';


--
-- Name: COLUMN ar_rma_rcpt.ut_user_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ar_rma_rcpt.ut_user_nbr IS 'Surrogate primary key for UT_USER';


--
-- Name: ar_rma_rcpt_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.ar_rma_rcpt_nbr_seq
    START WITH 21031
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.ar_rma_rcpt_nbr_seq OWNER TO jjs;

--
-- Name: ar_summary_inv_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.ar_summary_inv_nbr_seq
    START WITH 7096
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.ar_summary_inv_nbr_seq OWNER TO jjs;

--
-- Name: bill_of_lading_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.bill_of_lading_nbr_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.bill_of_lading_nbr_seq OWNER TO jjs;

--
-- Name: bin_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.bin_nbr_seq
    START WITH 450300
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.bin_nbr_seq OWNER TO jjs;

--
-- Name: box_cd_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.box_cd_seq
    START WITH 452487
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 999999
    CACHE 1
    CYCLE;


ALTER TABLE aerodemo.box_cd_seq OWNER TO jjs;

--
-- Name: brad_rel_cert_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.brad_rel_cert_seq
    START WITH 4579
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.brad_rel_cert_seq OWNER TO jjs;

--
-- Name: cal_calendar; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.cal_calendar (
    calendar character varying(6) NOT NULL,
    intvl_per_cycle smallint NOT NULL,
    stat_id character varying(1) DEFAULT 'S'::character varying,
    CONSTRAINT cal_stat_id_chk CHECK (((stat_id)::text = ANY (ARRAY[('A'::character varying)::text, ('I'::character varying)::text, ('S'::character varying)::text])))
);


ALTER TABLE aerodemo.cal_calendar OWNER TO jjs;

--
-- Name: COLUMN cal_calendar.calendar; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.cal_calendar.calendar IS 'The business calendar associated with this date.';


--
-- Name: cal_dt; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.cal_dt (
    cal_dt timestamp without time zone NOT NULL,
    calendar character varying(6) NOT NULL,
    cycle smallint NOT NULL,
    intvl smallint NOT NULL,
    intvl_pct numeric(6,3) NOT NULL,
    work_day_flg character varying(1) NOT NULL,
    prd_start_dt timestamp without time zone,
    cal_qtr smallint,
    work_day_nbr integer
);


ALTER TABLE aerodemo.cal_dt OWNER TO jjs;

--
-- Name: COLUMN cal_dt.cal_dt; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.cal_dt.cal_dt IS 'The relevent date.';


--
-- Name: COLUMN cal_dt.calendar; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.cal_dt.calendar IS 'The business calendar associated with this date.';


--
-- Name: COLUMN cal_dt.work_day_flg; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.cal_dt.work_day_flg IS 'W - Work Day
N  - Non Work Day
H  - Holiday (non work day that would normally be a work day based on the day of the week';


--
-- Name: COLUMN cal_dt.cal_qtr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.cal_dt.cal_qtr IS 'The calendar quarter associated with this date.';


--
-- Name: COLUMN cal_dt.work_day_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.cal_dt.work_day_nbr IS 'A relative work day number within the calendar.  System generated for calculated elapsed work days between two dates, finding a date ''x'' work days in the future, etc.';


--
-- Name: cal_holiday; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.cal_holiday (
    cal_holiday_nbr integer,
    calendar character varying(6),
    month smallint,
    day_of_month smallint,
    recurs character varying(2),
    align character varying(8),
    start_dt timestamp without time zone,
    end_dt timestamp without time zone,
    occurence character varying(8),
    day_of_week character varying(3),
    CONSTRAINT align_ck CHECK (((align)::text = ANY (ARRAY[('PREVWORK'::character varying)::text, ('NEXTWORK'::character varying)::text, ('IFWORK'::character varying)::text, ('CLOSEST'::character varying)::text]))),
    CONSTRAINT ck_occurence CHECK (((occurence)::text = ANY (ARRAY[('1ST'::character varying)::text, ('2ND'::character varying)::text, ('3RD'::character varying)::text, ('4TH'::character varying)::text, ('5TH'::character varying)::text, ('LAST'::character varying)::text])))
);


ALTER TABLE aerodemo.cal_holiday OWNER TO jjs;

--
-- Name: COLUMN cal_holiday.calendar; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.cal_holiday.calendar IS 'The business calendar associated with this date.';


--
-- Name: COLUMN cal_holiday.align; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.cal_holiday.align IS '''PREVWK'' - Previous Work Day 
''NEXTWK'' - Next Work Day 
''IFWK''        - If a work day 
''CLOSEST'' - Closest work day';


--
-- Name: COLUMN cal_holiday.occurence; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.cal_holiday.occurence IS '''1ST'',''2ND'',''3RD'',''4TH'',''5TH'',''LAST''';


--
-- Name: cm_dtl_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.cm_dtl_nbr_seq
    START WITH 15729
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.cm_dtl_nbr_seq OWNER TO jjs;

--
-- Name: cm_hdr_cd_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.cm_hdr_cd_seq
    START WITH 2481
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE aerodemo.cm_hdr_cd_seq OWNER TO jjs;

--
-- Name: currency; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.currency (
    curr_cd character varying(3) NOT NULL,
    curr_cd_descr character varying(60)
);


ALTER TABLE aerodemo.currency OWNER TO jjs;

--
-- Name: COLUMN currency.curr_cd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.currency.curr_cd IS 'The ANSI X.12 currency code';


--
-- Name: databasechangeloglock; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.databasechangeloglock (
    id numeric(38,0) NOT NULL,
    locked smallint NOT NULL,
    lockgranted timestamp without time zone,
    lockedby character varying(255)
);


ALTER TABLE aerodemo.databasechangeloglock OWNER TO jjs;

--
-- Name: dd_column_metadata; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.dd_column_metadata (
    table_catalog character varying(32),
    table_schema character varying(32),
    table_name character varying(64),
    column_name character varying(64),
    column_index integer,
    column_default character varying(64),
    is_nullable_flg character varying(1),
    data_type character varying(32),
    column_size integer,
    column_display_size integer,
    "precision" integer,
    scale integer,
    comments text,
    label character varying(32),
    heading character varying(32),
    excelformat character varying(32),
    java_format character varying(32),
    data_type_name character varying(32),
    workbook_formula character varying(128)
);


ALTER TABLE aerodemo.dd_column_metadata OWNER TO jjs;

--
-- Name: dd_column_metadata_distinct; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.dd_column_metadata_distinct (
    column_name character varying(64),
    column_default character varying(64),
    is_nullable_flg character varying(1),
    data_type character varying(32),
    column_size integer,
    column_display_size integer,
    "precision" integer,
    scale integer
);


ALTER TABLE aerodemo.dd_column_metadata_distinct OWNER TO jjs;

--
-- Name: dd_table_column_metadata; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.dd_table_column_metadata (
    table_catalog character varying(32),
    table_schema character varying(32),
    table_name character varying(64),
    table_type character varying(16),
    column_name character varying(64),
    column_index integer,
    column_default character varying(64),
    is_nullable_flg character varying(1),
    data_type character varying(32),
    column_size integer,
    column_display_size integer,
    "precision" integer,
    scale integer,
    comments text,
    label character varying(32),
    heading character varying(32),
    excelformat character varying(32),
    java_format character varying(32),
    data_type_name character varying(32),
    workbook_formula character varying(128)
);


ALTER TABLE aerodemo.dd_table_column_metadata OWNER TO jjs;

--
-- Name: debug_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.debug_nbr_seq
    START WITH 30001
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1000;


ALTER TABLE aerodemo.debug_nbr_seq OWNER TO jjs;

--
-- Name: debug_table; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.debug_table (
    debug_nbr integer NOT NULL,
    debug_msg character varying(4000)
);


ALTER TABLE aerodemo.debug_table OWNER TO jjs;

--
-- Name: dn_dtl_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.dn_dtl_nbr_seq
    START WITH 9143
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.dn_dtl_nbr_seq OWNER TO jjs;

--
-- Name: dn_hdr_cd_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.dn_hdr_cd_seq
    START WITH 733
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE aerodemo.dn_hdr_cd_seq OWNER TO jjs;

--
-- Name: edi_bin_scan_batch_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.edi_bin_scan_batch_nbr_seq
    START WITH 31829
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.edi_bin_scan_batch_nbr_seq OWNER TO jjs;

--
-- Name: edi_bin_scan_dtl_nbr; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.edi_bin_scan_dtl_nbr
    START WITH 365337
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.edi_bin_scan_dtl_nbr OWNER TO jjs;

--
-- Name: edi_bin_scan_dtl_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.edi_bin_scan_dtl_nbr_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.edi_bin_scan_dtl_nbr_seq OWNER TO jjs;

--
-- Name: fake_date; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.fake_date (
    max_mod_dt timestamp without time zone
);


ALTER TABLE aerodemo.fake_date OWNER TO jjs;

--
-- Name: fake_emails; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.fake_emails (
    buyer_email_addr character varying(40),
    fake_email character varying(40)
);


ALTER TABLE aerodemo.fake_emails OWNER TO jjs;

--
-- Name: fake_indiv_nm; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.fake_indiv_nm (
    indiv_nm character varying(45)
);


ALTER TABLE aerodemo.fake_indiv_nm OWNER TO jjs;

--
-- Name: fake_names; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.fake_names (
    indiv_nm_buyer character varying(45),
    fake_name character varying(45)
);


ALTER TABLE aerodemo.fake_names OWNER TO jjs;

--
-- Name: fake_org_nm; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.fake_org_nm (
    org_nm character varying(60),
    fake_org_nm character varying(60)
);


ALTER TABLE aerodemo.fake_org_nm OWNER TO jjs;

--
-- Name: fake_phn_nbrs; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.fake_phn_nbrs (
    phn_nbr character varying(20),
    type character varying(5),
    fake_phn_nbr character varying(20)
);


ALTER TABLE aerodemo.fake_phn_nbrs OWNER TO jjs;

--
-- Name: fc_adj; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.fc_adj (
    fc_adj_nbr integer NOT NULL,
    fc_item_mast_nbr integer NOT NULL,
    adj_id character varying(2) NOT NULL,
    adj_amt numeric(10,2) NOT NULL,
    adj_comm character varying(80),
    indiv_nbr_adj integer,
    adj_tm timestamp without time zone NOT NULL,
    effective_dt timestamp without time zone NOT NULL,
    CONSTRAINT fa_check_adj_id CHECK (((adj_id)::text = ANY (ARRAY[('OP'::character varying)::text, ('OM'::character varying)::text, ('PP'::character varying)::text, ('PM'::character varying)::text, ('AM'::character varying)::text, ('AP'::character varying)::text, ('FA'::character varying)::text, ('PA'::character varying)::text, ('FP'::character varying)::text, ('PP'::character varying)::text])))
);


ALTER TABLE aerodemo.fc_adj OWNER TO jjs;

--
-- Name: fc_adj_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.fc_adj_nbr_seq
    START WITH 2383681
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.fc_adj_nbr_seq OWNER TO jjs;

--
-- Name: fc_adj_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.fc_adj_seq
    START WITH 1100543
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.fc_adj_seq OWNER TO jjs;

--
-- Name: fc_aggr_mast; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.fc_aggr_mast (
    fc_aggr_mast_nbr integer NOT NULL,
    fc_aggr_mast_descr character varying(30),
    fcst_grp character varying(8),
    fcst_type_id character varying(1) NOT NULL,
    fcst_aggr_type_id character varying(1) NOT NULL,
    calendar character varying(6),
    tot_lead_time smallint,
    store_alt_fcst_flg character varying(1),
    fc_aggr_mast_stat_id character varying(1) NOT NULL,
    trc_file_nm_absolute character varying(255),
    CONSTRAINT fam_check_fc_aggr_mast_stat_id CHECK (((fc_aggr_mast_stat_id)::text = ANY (ARRAY[('A'::character varying)::text, ('I'::character varying)::text]))),
    CONSTRAINT fam_check_fcst_aggr_type_id CHECK (((fcst_aggr_type_id)::text = ANY (ARRAY[('Q'::character varying)::text, ('C'::character varying)::text, ('P'::character varying)::text]))),
    CONSTRAINT fam_check_fcst_type_id CHECK (((fcst_type_id)::text = ANY (ARRAY[('H'::character varying)::text, ('F'::character varying)::text])))
);


ALTER TABLE aerodemo.fc_aggr_mast OWNER TO jjs;

--
-- Name: COLUMN fc_aggr_mast.fcst_grp; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.fc_aggr_mast.fcst_grp IS 'The group to which this customer is to be aggregated when forecasting.';


--
-- Name: COLUMN fc_aggr_mast.fcst_type_id; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.fc_aggr_mast.fcst_type_id IS 'H - History Aggregated Forecast,
F - Forecast Aggregated Forecast';


--
-- Name: COLUMN fc_aggr_mast.fcst_aggr_type_id; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.fc_aggr_mast.fcst_aggr_type_id IS 'Q - Quantity Aggregation,
C - Cost Aggregation, P - Price Aggregation';


--
-- Name: COLUMN fc_aggr_mast.calendar; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.fc_aggr_mast.calendar IS 'The business calendar associated with this date.';


--
-- Name: COLUMN fc_aggr_mast.store_alt_fcst_flg; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.fc_aggr_mast.store_alt_fcst_flg IS 'If "Y" then alternate forecasts that were evaluated are stored in the database.';


--
-- Name: fc_aggr_mast_attr; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.fc_aggr_mast_attr (
    fc_aggr_mast_nbr integer NOT NULL,
    ic_attr_nbr integer NOT NULL,
    attr_val character varying(20) NOT NULL
);


ALTER TABLE aerodemo.fc_aggr_mast_attr OWNER TO jjs;

--
-- Name: fc_aggr_mast_dtl; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.fc_aggr_mast_dtl (
    fc_aggr_mast_nbr integer NOT NULL,
    fc_item_mast_nbr integer NOT NULL
);


ALTER TABLE aerodemo.fc_aggr_mast_dtl OWNER TO jjs;

--
-- Name: fc_aggr_mast_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.fc_aggr_mast_nbr_seq
    START WITH 124441
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.fc_aggr_mast_nbr_seq OWNER TO jjs;

--
-- Name: fc_attr; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.fc_attr (
    fc_attr_nbr integer NOT NULL,
    attr_nm character varying(16) NOT NULL,
    attr_descr character varying(60) NOT NULL,
    attr_seq smallint,
    reqr_flg character varying(1) NOT NULL,
    attr_constr_flg character varying(1) NOT NULL,
    ut_user_nbr integer NOT NULL,
    last_mod_dt timestamp without time zone NOT NULL,
    CONSTRAINT sys_c0016533 CHECK (((reqr_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0016534 CHECK (((attr_constr_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text])))
);


ALTER TABLE aerodemo.fc_attr OWNER TO jjs;

--
-- Name: COLUMN fc_attr.attr_nm; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.fc_attr.attr_nm IS 'Attribute name.';


--
-- Name: COLUMN fc_attr.attr_descr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.fc_attr.attr_descr IS 'Attribute description.';


--
-- Name: COLUMN fc_attr.attr_seq; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.fc_attr.attr_seq IS 'Attribute sequence.  Affects the order in which the attribute is displayed on certain screens.';


--
-- Name: COLUMN fc_attr.ut_user_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.fc_attr.ut_user_nbr IS 'Surrogate primary key for UT_USER';


--
-- Name: fc_attr_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.fc_attr_nbr_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.fc_attr_nbr_seq OWNER TO jjs;

--
-- Name: fc_attr_val; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.fc_attr_val (
    fc_attr_nbr integer NOT NULL,
    attr_val character varying(20) NOT NULL,
    attr_val_descr character varying(60),
    ut_user_nbr integer NOT NULL,
    last_mod_dt timestamp without time zone NOT NULL
);


ALTER TABLE aerodemo.fc_attr_val OWNER TO jjs;

--
-- Name: COLUMN fc_attr_val.attr_val; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.fc_attr_val.attr_val IS 'Attribute value.';


--
-- Name: COLUMN fc_attr_val.ut_user_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.fc_attr_val.ut_user_nbr IS 'Surrogate primary key for UT_USER';


--
-- Name: fc_build_rate; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.fc_build_rate (
    fc_build_rate_grp_cd character varying(10) NOT NULL,
    build_rate_eff_dt timestamp without time zone NOT NULL,
    build_rate_units integer NOT NULL
);


ALTER TABLE aerodemo.fc_build_rate OWNER TO jjs;

--
-- Name: fc_build_rate_grp; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.fc_build_rate_grp (
    fc_build_rate_grp_cd character varying(10) NOT NULL,
    fc_build_rate_grp_descr character varying(10) NOT NULL,
    fc_build_rate_grp_stat_id character varying(1) NOT NULL,
    CONSTRAINT sys_c0016078 CHECK (((fc_build_rate_grp_stat_id)::text = ANY (ARRAY[('A'::character varying)::text, ('I'::character varying)::text])))
);


ALTER TABLE aerodemo.fc_build_rate_grp OWNER TO jjs;

--
-- Name: COLUMN fc_build_rate_grp.fc_build_rate_grp_cd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.fc_build_rate_grp.fc_build_rate_grp_cd IS '????????????????';


--
-- Name: fc_cat_adj_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.fc_cat_adj_nbr_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.fc_cat_adj_nbr_seq OWNER TO jjs;

--
-- Name: fc_ctl; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.fc_ctl (
    run_date timestamp without time zone,
    prd_per_cycle smallint,
    cycle smallint,
    prd smallint,
    intvl_per_cycle smallint,
    intvl smallint,
    next_run_nbr smallint,
    cycle_nm character varying(6),
    intvl_nm character varying(6),
    prd_nm character varying(6),
    fc_reg_nbr bigint,
    safety_stk_lead_tm_flg character varying(1),
    carry_cost numeric(3,3),
    aquis_cost numeric(12,5),
    hit_cnt_force_mdl_other integer,
    hit_cnt_force_mdl_under integer,
    hit_cnt_cost numeric(7,2),
    hit_cnt smallint
);


ALTER TABLE aerodemo.fc_ctl OWNER TO jjs;

--
-- Name: fc_dtl_tmp; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.fc_dtl_tmp (
    fc_item_mast_nbr integer NOT NULL,
    item_nbr integer NOT NULL,
    item_cd character varying(50) NOT NULL,
    user_fld_1 character varying(20) NOT NULL,
    user_fld_2 character varying(20) NOT NULL,
    user_fld_3 character varying(20) NOT NULL,
    raw_fcst_tot bigint
);


ALTER TABLE aerodemo.fc_dtl_tmp OWNER TO jjs;

--
-- Name: COLUMN fc_dtl_tmp.fc_item_mast_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.fc_dtl_tmp.fc_item_mast_nbr IS 'Surrogate primary key for FC_ITEM_MAST.';


--
-- Name: COLUMN fc_dtl_tmp.item_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.fc_dtl_tmp.item_nbr IS 'Product identifier, reference to item master (IC_ITEM_MAST.ITEM_NBR)';


--
-- Name: COLUMN fc_dtl_tmp.item_cd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.fc_dtl_tmp.item_cd IS 'Product identifier. (IC_ITEM_MAST.ITEM_CD)';


--
-- Name: fc_fcst_aggr; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.fc_fcst_aggr (
    fc_aggr_mast_nbr integer NOT NULL,
    fc_fcst_dt timestamp without time zone NOT NULL,
    raw_fcst numeric(17,5),
    adj_fcst numeric(17,5)
);


ALTER TABLE aerodemo.fc_fcst_aggr OWNER TO jjs;

--
-- Name: fc_fcst_bucket; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.fc_fcst_bucket (
    fc_item_mast_nbr integer NOT NULL,
    prd_start_dt timestamp without time zone NOT NULL,
    intvl smallint NOT NULL,
    intvl_start_dt timestamp without time zone NOT NULL,
    fc_fcst_dt timestamp without time zone NOT NULL,
    frac_prd_dmd_raw bigint NOT NULL,
    whole_prd_dmd_raw bigint,
    whole_prd_adj_raw bigint,
    frac_prd_dmd_adj bigint,
    whole_prd_dmd_adj bigint,
    whole_prd_adj_adj bigint
);


ALTER TABLE aerodemo.fc_fcst_bucket OWNER TO jjs;

--
-- Name: COLUMN fc_fcst_bucket.fc_item_mast_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.fc_fcst_bucket.fc_item_mast_nbr IS 'Surrogate primary key for FC_ITEM_MAST.';


--
-- Name: fc_fcst_mdl; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.fc_fcst_mdl (
    fc_fcst_mdl_nbr integer NOT NULL,
    class_name character varying(255),
    alpha_1 numeric(4,2),
    alpha_2 numeric(4,2),
    alpha_3 numeric(4,2),
    fcst_mdl_descr character varying(60),
    mdl_intvl_cnt_min smallint,
    mdl_intvl_cnt_max smallint,
    min_non_zero_intvl_prev_cycle smallint,
    mdl_stat_id character varying(1) DEFAULT 'A'::character varying NOT NULL,
    min_sim_cnt smallint,
    trace_flg character varying(1) DEFAULT 'Y'::character varying NOT NULL,
    is_user_defined character varying(1),
    season_flg character varying(1),
    short_fcst_mdl_descr character varying(20),
    long_fcst_mdl_descr character varying(60),
    mdl_intvl_cnt smallint,
    CONSTRAINT sys_c0016201 CHECK (((is_user_defined)::text = 'Y'::text)),
    CONSTRAINT sys_c0016202 CHECK (((is_user_defined)::text = 'Y'::text)),
    CONSTRAINT sys_c0016203 CHECK (((is_user_defined)::text = 'Y'::text)),
    CONSTRAINT sys_c0016204 CHECK (((is_user_defined)::text = 'Y'::text))
);


ALTER TABLE aerodemo.fc_fcst_mdl OWNER TO jjs;

--
-- Name: fc_fcst_mdl_grp; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.fc_fcst_mdl_grp (
    fcst_mdl_grp character varying(16) NOT NULL,
    fcst_mdl_nbr smallint NOT NULL
);


ALTER TABLE aerodemo.fc_fcst_mdl_grp OWNER TO jjs;

--
-- Name: COLUMN fc_fcst_mdl_grp.fcst_mdl_grp; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.fc_fcst_mdl_grp.fcst_mdl_grp IS 'The name of the forecast model group to be used for this entity.';


--
-- Name: fc_fcst_mdl_grp_hdr; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.fc_fcst_mdl_grp_hdr (
    fcst_mdl_grp character varying(16) NOT NULL,
    fcst_mdl_grp_descr character varying(60) NOT NULL
);


ALTER TABLE aerodemo.fc_fcst_mdl_grp_hdr OWNER TO jjs;

--
-- Name: COLUMN fc_fcst_mdl_grp_hdr.fcst_mdl_grp; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.fc_fcst_mdl_grp_hdr.fcst_mdl_grp IS 'The name of the forecast model group to be used for this entity.';


--
-- Name: fc_fcst_mdl_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.fc_fcst_mdl_nbr_seq
    START WITH 41
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.fc_fcst_mdl_nbr_seq OWNER TO jjs;

--
-- Name: fc_item_fcst_mdl; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.fc_item_fcst_mdl (
    fc_item_fcst_mdl_nbr bigint NOT NULL,
    fc_item_mast_nbr integer,
    fc_fcst_mdl_nbr integer,
    std_dev bigint,
    mean_abs_dev bigint,
    rvw_cnt bigint,
    safety_stk_raw bigint,
    fcst_mdl_descr bigint,
    safety_stk_adj bigint,
    econ_ord_qty bigint,
    ord_qty_adj bigint,
    safety_stk_min_days bigint,
    safety_stk_max_days bigint,
    safety_stk_min_units bigint,
    safety_stk_max_units bigint,
    lead_time_fcst bigint,
    run_nbr bigint,
    chosen_flg character varying(1),
    thiel bigint,
    lead_time_hist bigint,
    error_ratio bigint,
    CONSTRAINT sys_c0016039 CHECK (((chosen_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text])))
);


ALTER TABLE aerodemo.fc_item_fcst_mdl OWNER TO jjs;

--
-- Name: COLUMN fc_item_fcst_mdl.fc_item_fcst_mdl_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.fc_item_fcst_mdl.fc_item_fcst_mdl_nbr IS 'Surrogate primary key for';


--
-- Name: COLUMN fc_item_fcst_mdl.fc_item_mast_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.fc_item_fcst_mdl.fc_item_mast_nbr IS 'Surrogate primary key for FC_ITEM_MAST.';


--
-- Name: fc_fcst_mnth_vw; Type: VIEW; Schema: aerodemo; Owner: jjs
--

CREATE VIEW aerodemo.fc_fcst_mnth_vw AS
 SELECT alias132.fc_item_mast_nbr,
    sum(alias132.mnth_1_raw) AS m1_raw,
    sum(alias132.mnth_1_adj) AS m1_adj,
    sum(alias132.mnth_1_value) AS m1v,
    sum(alias132.mnth_2_raw) AS m2_raw,
    sum(alias132.mnth_2_adj) AS m2_adj,
    sum(alias132.mnth_2_value) AS m2v,
    sum(alias132.mnth_3_raw) AS m3_raw,
    sum(alias132.mnth_3_adj) AS m3_adj,
    sum(alias132.mnth_3_value) AS m3v,
    sum(alias132.mnth_4_raw) AS m4_raw,
    sum(alias132.mnth_4_adj) AS m4_adj,
    sum(alias132.mnth_4_value) AS m4v,
    sum(alias132.mnth_5_raw) AS m5_raw,
    sum(alias132.mnth_5_adj) AS m5_adj,
    sum(alias132.mnth_5_value) AS m5v,
    sum(alias132.mnth_6_raw) AS m6_raw,
    sum(alias132.mnth_6_adj) AS m6_adj,
    sum(alias132.mnth_6_value) AS m6v,
    sum(alias132.mnth_7_raw) AS m7_raw,
    sum(alias132.mnth_7_adj) AS m7_adj,
    sum(alias132.mnth_7_value) AS m7v,
    sum(alias132.mnth_8_raw) AS m8_raw,
    sum(alias132.mnth_8_adj) AS m8_adj,
    sum(alias132.mnth_8_value) AS m8v,
    sum(alias132.mnth_9_raw) AS m9_raw,
    sum(alias132.mnth_9_adj) AS m9_adj,
    sum(alias132.mnth_9_value) AS m9v,
    sum(alias132.mnth_10_raw) AS m10_raw,
    sum(alias132.mnth_10_adj) AS m10_adj,
    sum(alias132.mnth_10_value) AS m10v,
    sum(alias132.mnth_11_raw) AS m11_raw,
    sum(alias132.mnth_11_adj) AS m11_adj,
    sum(alias132.mnth_11_value) AS m11v,
    sum(alias132.mnth_12_raw) AS m12_raw,
    sum(alias132.mnth_12_adj) AS m12_adj,
    sum(alias132.mnth_12_value) AS m12v
   FROM ( SELECT fim.fc_item_mast_nbr,
                CASE
                    WHEN (to_char(('now'::text)::timestamp without time zone, 'RRRR/MM'::text) = to_char(ff.fc_fcst_dt, 'RRRR/MM'::text)) THEN ff.raw_fcst
                    ELSE NULL::numeric
                END AS mnth_1_raw,
                CASE
                    WHEN (to_char(('now'::text)::timestamp without time zone, 'RRRR/MM'::text) = to_char(ff.fc_fcst_dt, 'RRRR/MM'::text)) THEN ff.adj_fcst
                    ELSE NULL::numeric
                END AS mnth_1_adj,
                CASE
                    WHEN (to_char(('now'::text)::timestamp without time zone, 'RRRR/MM'::text) = to_char(ff.fc_fcst_dt, 'RRRR/MM'::text)) THEN (COALESCE(COALESCE(ff.adj_fcst, ff.raw_fcst), (0)::numeric) * fim.unit_cost_stk_um)
                    ELSE NULL::numeric
                END AS mnth_1_value,
                CASE
                    WHEN (to_char((('now'::text)::timestamp without time zone + '1 mon'::interval), 'RRRR/MM'::text) = to_char(ff.fc_fcst_dt, 'RRRR/MM'::text)) THEN ff.raw_fcst
                    ELSE NULL::numeric
                END AS mnth_2_raw,
                CASE
                    WHEN (to_char((('now'::text)::timestamp without time zone + '1 mon'::interval), 'RRRR/MM'::text) = to_char(ff.fc_fcst_dt, 'RRRR/MM'::text)) THEN ff.adj_fcst
                    ELSE NULL::numeric
                END AS mnth_2_adj,
                CASE
                    WHEN (to_char((('now'::text)::timestamp without time zone + '1 mon'::interval), 'RRRR/MM'::text) = to_char(ff.fc_fcst_dt, 'RRRR/MM'::text)) THEN (COALESCE(COALESCE(ff.adj_fcst, ff.raw_fcst), (0)::numeric) * fim.unit_cost_stk_um)
                    ELSE (0)::numeric
                END AS mnth_2_value,
                CASE
                    WHEN (to_char((('now'::text)::timestamp without time zone + '2 mons'::interval), 'RRRR/MM'::text) = to_char(ff.fc_fcst_dt, 'RRRR/MM'::text)) THEN ff.raw_fcst
                    ELSE NULL::numeric
                END AS mnth_3_raw,
                CASE
                    WHEN (to_char((('now'::text)::timestamp without time zone + '2 mons'::interval), 'RRRR/MM'::text) = to_char(ff.fc_fcst_dt, 'RRRR/MM'::text)) THEN ff.adj_fcst
                    ELSE NULL::numeric
                END AS mnth_3_adj,
                CASE
                    WHEN (to_char((('now'::text)::timestamp without time zone + '2 mons'::interval), 'RRRR/MM'::text) = to_char(ff.fc_fcst_dt, 'RRRR/MM'::text)) THEN (COALESCE(COALESCE(ff.adj_fcst, ff.raw_fcst), (0)::numeric) * fim.unit_cost_stk_um)
                    ELSE (0)::numeric
                END AS mnth_3_value,
                CASE
                    WHEN (to_char((('now'::text)::timestamp without time zone + '3 mons'::interval), 'RRRR/MM'::text) = to_char(ff.fc_fcst_dt, 'RRRR/MM'::text)) THEN ff.raw_fcst
                    ELSE NULL::numeric
                END AS mnth_4_raw,
                CASE
                    WHEN (to_char((('now'::text)::timestamp without time zone + '3 mons'::interval), 'RRRR/MM'::text) = to_char(ff.fc_fcst_dt, 'RRRR/MM'::text)) THEN ff.adj_fcst
                    ELSE NULL::numeric
                END AS mnth_4_adj,
                CASE
                    WHEN (to_char((('now'::text)::timestamp without time zone + '3 mons'::interval), 'RRRR/MM'::text) = to_char(ff.fc_fcst_dt, 'RRRR/MM'::text)) THEN (COALESCE(COALESCE(ff.adj_fcst, ff.raw_fcst), (0)::numeric) * fim.unit_cost_stk_um)
                    ELSE (0)::numeric
                END AS mnth_4_value,
                CASE
                    WHEN (to_char((('now'::text)::timestamp without time zone + '4 mons'::interval), 'RRRR/MM'::text) = to_char(ff.fc_fcst_dt, 'RRRR/MM'::text)) THEN ff.raw_fcst
                    ELSE NULL::numeric
                END AS mnth_5_raw,
                CASE
                    WHEN (to_char((('now'::text)::timestamp without time zone + '4 mons'::interval), 'RRRR/MM'::text) = to_char(ff.fc_fcst_dt, 'RRRR/MM'::text)) THEN ff.adj_fcst
                    ELSE NULL::numeric
                END AS mnth_5_adj,
                CASE
                    WHEN (to_char((('now'::text)::timestamp without time zone + '4 mons'::interval), 'RRRR/MM'::text) = to_char(ff.fc_fcst_dt, 'RRRR/MM'::text)) THEN (COALESCE(COALESCE(ff.adj_fcst, ff.raw_fcst), (0)::numeric) * fim.unit_cost_stk_um)
                    ELSE (0)::numeric
                END AS mnth_5_value,
                CASE
                    WHEN (to_char((('now'::text)::timestamp without time zone + '5 mons'::interval), 'RRRR/MM'::text) = to_char(ff.fc_fcst_dt, 'RRRR/MM'::text)) THEN ff.raw_fcst
                    ELSE NULL::numeric
                END AS mnth_6_raw,
                CASE
                    WHEN (to_char((('now'::text)::timestamp without time zone + '5 mons'::interval), 'RRRR/MM'::text) = to_char(ff.fc_fcst_dt, 'RRRR/MM'::text)) THEN ff.adj_fcst
                    ELSE NULL::numeric
                END AS mnth_6_adj,
                CASE
                    WHEN (to_char((('now'::text)::timestamp without time zone + '5 mons'::interval), 'RRRR/MM'::text) = to_char(ff.fc_fcst_dt, 'RRRR/MM'::text)) THEN (COALESCE(COALESCE(ff.adj_fcst, ff.raw_fcst), (0)::numeric) * fim.unit_cost_stk_um)
                    ELSE (0)::numeric
                END AS mnth_6_value,
                CASE
                    WHEN (to_char((('now'::text)::timestamp without time zone + '6 mons'::interval), 'RRRR/MM'::text) = to_char(ff.fc_fcst_dt, 'RRRR/MM'::text)) THEN ff.raw_fcst
                    ELSE NULL::numeric
                END AS mnth_7_raw,
                CASE
                    WHEN (to_char((('now'::text)::timestamp without time zone + '6 mons'::interval), 'RRRR/MM'::text) = to_char(ff.fc_fcst_dt, 'RRRR/MM'::text)) THEN ff.adj_fcst
                    ELSE NULL::numeric
                END AS mnth_7_adj,
                CASE
                    WHEN (to_char((('now'::text)::timestamp without time zone + '6 mons'::interval), 'RRRR/MM'::text) = to_char(ff.fc_fcst_dt, 'RRRR/MM'::text)) THEN (COALESCE(COALESCE(ff.adj_fcst, ff.raw_fcst), (0)::numeric) * fim.unit_cost_stk_um)
                    ELSE (0)::numeric
                END AS mnth_7_value,
                CASE
                    WHEN (to_char((('now'::text)::timestamp without time zone + '7 mons'::interval), 'RRRR/MM'::text) = to_char(ff.fc_fcst_dt, 'RRRR/MM'::text)) THEN ff.raw_fcst
                    ELSE NULL::numeric
                END AS mnth_8_raw,
                CASE
                    WHEN (to_char((('now'::text)::timestamp without time zone + '7 mons'::interval), 'RRRR/MM'::text) = to_char(ff.fc_fcst_dt, 'RRRR/MM'::text)) THEN ff.adj_fcst
                    ELSE NULL::numeric
                END AS mnth_8_adj,
                CASE
                    WHEN (to_char((('now'::text)::timestamp without time zone + '7 mons'::interval), 'RRRR/MM'::text) = to_char(ff.fc_fcst_dt, 'RRRR/MM'::text)) THEN (COALESCE(COALESCE(ff.adj_fcst, ff.raw_fcst), (0)::numeric) * fim.unit_cost_stk_um)
                    ELSE (0)::numeric
                END AS mnth_8_value,
                CASE
                    WHEN (to_char((('now'::text)::timestamp without time zone + '8 mons'::interval), 'RRRR/MM'::text) = to_char(ff.fc_fcst_dt, 'RRRR/MM'::text)) THEN ff.raw_fcst
                    ELSE NULL::numeric
                END AS mnth_9_raw,
                CASE
                    WHEN (to_char((('now'::text)::timestamp without time zone + '8 mons'::interval), 'RRRR/MM'::text) = to_char(ff.fc_fcst_dt, 'RRRR/MM'::text)) THEN ff.adj_fcst
                    ELSE NULL::numeric
                END AS mnth_9_adj,
                CASE
                    WHEN (to_char((('now'::text)::timestamp without time zone + '8 mons'::interval), 'RRRR/MM'::text) = to_char(ff.fc_fcst_dt, 'RRRR/MM'::text)) THEN (COALESCE(COALESCE(ff.adj_fcst, ff.raw_fcst), (0)::numeric) * fim.unit_cost_stk_um)
                    ELSE (0)::numeric
                END AS mnth_9_value,
                CASE
                    WHEN (to_char((('now'::text)::timestamp without time zone + '9 mons'::interval), 'RRRR/MM'::text) = to_char(ff.fc_fcst_dt, 'RRRR/MM'::text)) THEN ff.raw_fcst
                    ELSE NULL::numeric
                END AS mnth_10_raw,
                CASE
                    WHEN (to_char((('now'::text)::timestamp without time zone + '9 mons'::interval), 'RRRR/MM'::text) = to_char(ff.fc_fcst_dt, 'RRRR/MM'::text)) THEN ff.adj_fcst
                    ELSE NULL::numeric
                END AS mnth_10_adj,
                CASE
                    WHEN (to_char((('now'::text)::timestamp without time zone + '9 mons'::interval), 'RRRR/MM'::text) = to_char(ff.fc_fcst_dt, 'RRRR/MM'::text)) THEN (COALESCE(COALESCE(ff.adj_fcst, ff.raw_fcst), (0)::numeric) * fim.unit_cost_stk_um)
                    ELSE (0)::numeric
                END AS mnth_10_value,
                CASE
                    WHEN (to_char((('now'::text)::timestamp without time zone + '10 mons'::interval), 'RRRR/MM'::text) = to_char(ff.fc_fcst_dt, 'RRRR/MM'::text)) THEN ff.raw_fcst
                    ELSE NULL::numeric
                END AS mnth_11_raw,
                CASE
                    WHEN (to_char((('now'::text)::timestamp without time zone + '10 mons'::interval), 'RRRR/MM'::text) = to_char(ff.fc_fcst_dt, 'RRRR/MM'::text)) THEN ff.adj_fcst
                    ELSE NULL::numeric
                END AS mnth_11_adj,
                CASE
                    WHEN (to_char((('now'::text)::timestamp without time zone + '10 mons'::interval), 'RRRR/MM'::text) = to_char(ff.fc_fcst_dt, 'RRRR/MM'::text)) THEN (COALESCE(COALESCE(ff.adj_fcst, ff.raw_fcst), (0)::numeric) * fim.unit_cost_stk_um)
                    ELSE (0)::numeric
                END AS mnth_11_value,
                CASE
                    WHEN (to_char((('now'::text)::timestamp without time zone + '11 mons'::interval), 'RRRR/MM'::text) = to_char(ff.fc_fcst_dt, 'RRRR/MM'::text)) THEN ff.raw_fcst
                    ELSE NULL::numeric
                END AS mnth_12_raw,
                CASE
                    WHEN (to_char((('now'::text)::timestamp without time zone + '11 mons'::interval), 'RRRR/MM'::text) = to_char(ff.fc_fcst_dt, 'RRRR/MM'::text)) THEN ff.adj_fcst
                    ELSE NULL::numeric
                END AS mnth_12_adj,
                CASE
                    WHEN (to_char((('now'::text)::timestamp without time zone + '11 mons'::interval), 'RRRR/MM'::text) = to_char(ff.fc_fcst_dt, 'RRRR/MM'::text)) THEN (COALESCE(COALESCE(ff.adj_fcst, ff.raw_fcst), (0)::numeric) * fim.unit_cost_stk_um)
                    ELSE (0)::numeric
                END AS mnth_12_value
           FROM aerodemo.fc_fcst ff,
            aerodemo.fc_item_fcst_mdl fifm,
            aerodemo.fc_item_mast fim
          WHERE ((ff.fc_item_fcst_mdl_nbr = fifm.fc_item_fcst_mdl_nbr) AND ((fifm.chosen_flg)::text = 'Y'::text) AND (ff.fc_item_mast_nbr = fim.fc_item_mast_nbr) AND ((fim.fc_item_mast_stat_id)::text = 'A'::text))) alias132
  GROUP BY alias132.fc_item_mast_nbr;


ALTER TABLE aerodemo.fc_fcst_mnth_vw OWNER TO jjs;

--
-- Name: fc_fcst_nbr; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.fc_fcst_nbr
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.fc_fcst_nbr OWNER TO jjs;

--
-- Name: fc_fcst_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.fc_fcst_nbr_seq
    START WITH 23889082
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.fc_fcst_nbr_seq OWNER TO jjs;

--
-- Name: fc_fcst_nbr_skip_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.fc_fcst_nbr_skip_seq
    START WITH 27354300
    INCREMENT BY 100
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.fc_fcst_nbr_skip_seq OWNER TO jjs;

--
-- Name: fc_fcst_prd; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.fc_fcst_prd (
    fc_item_mast_nbr integer NOT NULL,
    fc_fcst_dt timestamp without time zone NOT NULL,
    raw_fcst numeric(17,5),
    adj_fcst numeric(17,5),
    fcst_alloc_qty numeric(17,5)
);


ALTER TABLE aerodemo.fc_fcst_prd OWNER TO jjs;

--
-- Name: COLUMN fc_fcst_prd.fc_item_mast_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.fc_fcst_prd.fc_item_mast_nbr IS 'Surrogate primary key for FC_ITEM_MAST.';


--
-- Name: fc_fcst_prd_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.fc_fcst_prd_nbr_seq
    START WITH 1324061
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.fc_fcst_prd_nbr_seq OWNER TO jjs;

--
-- Name: fc_fcst_prd_old; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.fc_fcst_prd_old (
    fc_item_mast_nbr integer,
    prd_start_dt timestamp without time zone,
    frac_prd_dmd bigint,
    fc_fcst_prd_nbr integer,
    whole_prd_dmd bigint,
    whole_prd_adj bigint
);


ALTER TABLE aerodemo.fc_fcst_prd_old OWNER TO jjs;

--
-- Name: fc_hdr_tmp; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.fc_hdr_tmp (
    user_fld_1 character varying(20) NOT NULL,
    user_fld_2 character varying(20) NOT NULL,
    raw_fcst_tot bigint
);


ALTER TABLE aerodemo.fc_hdr_tmp OWNER TO jjs;

--
-- Name: fc_hist; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.fc_hist (
    fc_hist_nbr integer,
    fc_item_mast_nbr integer NOT NULL,
    dmd_act numeric(13,2),
    dmd_adj numeric(13,2),
    dmd_dt timestamp without time zone NOT NULL
);


ALTER TABLE aerodemo.fc_hist OWNER TO jjs;

--
-- Name: COLUMN fc_hist.fc_hist_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.fc_hist.fc_hist_nbr IS 'Surrogate primary key for';


--
-- Name: COLUMN fc_hist.fc_item_mast_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.fc_hist.fc_item_mast_nbr IS 'Surrogate primary key for FC_ITEM_MAST.';


--
-- Name: fc_hist_dist; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.fc_hist_dist (
    fc_item_mast_nbr integer NOT NULL,
    item_nbr integer,
    item_cd character varying(50),
    hist bigint,
    pct_dist_hist bigint
);


ALTER TABLE aerodemo.fc_hist_dist OWNER TO jjs;

--
-- Name: COLUMN fc_hist_dist.fc_item_mast_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.fc_hist_dist.fc_item_mast_nbr IS 'Surrogate primary key for FC_ITEM_MAST.';


--
-- Name: COLUMN fc_hist_dist.item_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.fc_hist_dist.item_nbr IS 'Product identifier, reference to item master (IC_ITEM_MAST.ITEM_NBR)';


--
-- Name: fc_hist_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.fc_hist_nbr_seq
    START WITH 7200097
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.fc_hist_nbr_seq OWNER TO jjs;

--
-- Name: fc_item_attr; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.fc_item_attr (
    fc_item_mast_nbr integer NOT NULL,
    fc_attr_nbr integer NOT NULL,
    attr_val character varying(20) NOT NULL
);


ALTER TABLE aerodemo.fc_item_attr OWNER TO jjs;

--
-- Name: COLUMN fc_item_attr.fc_item_mast_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.fc_item_attr.fc_item_mast_nbr IS 'Surrogate primary key for FC_ITEM_MAST.';


--
-- Name: COLUMN fc_item_attr.attr_val; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.fc_item_attr.attr_val IS 'Attribute value.';


--
-- Name: fc_item_dflt; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.fc_item_dflt (
    fc_item_dflt_nbr integer NOT NULL,
    item_nbr integer NOT NULL,
    svc_lvl numeric(2,2),
    ord_qty_min integer,
    ord_qty_incr integer,
    ord_qty_max integer,
    stk_cd character varying(1),
    tot_lead_time numeric(4,2),
    lead_time_ship numeric(4,2),
    safety_stk_min_prd numeric(3,1),
    safety_stk_max_prd numeric(3,1),
    safety_stk_min_unit numeric(17,6),
    safety_stk_max_unit numeric(17,6),
    intro_dt timestamp without time zone,
    shelf_life smallint,
    whsl_price numeric(13,5),
    fob_cost numeric(13,5),
    currency_cd character varying(3),
    ex_whse_cost numeric(13,5),
    land_cost numeric(13,5),
    carry_cost numeric(3,3),
    ord_qty_min_unit integer,
    ord_qty_max_unit integer,
    ord_qty_min_prd numeric(4,1),
    ord_qty_max_prd numeric(4,1),
    store_alt_fcst_flag character varying(1),
    arch_alt_fcst_flag character varying(1),
    calendar character varying(6),
    aquis_cost numeric(12,5),
    distrib_lead_time smallint,
    fcst_mdl_grp character varying(8),
    recv_cost numeric(13,5),
    resource_units_init numeric(13,2),
    resource_units_incr numeric(13,2),
    max_work_order_qty numeric(13,2),
    replen_lead_time numeric(4,2),
    fcst_lead_time numeric(4,2),
    stat_id character varying(1),
    econ_ord_qty numeric(13,5)
);


ALTER TABLE aerodemo.fc_item_dflt OWNER TO jjs;

--
-- Name: COLUMN fc_item_dflt.item_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.fc_item_dflt.item_nbr IS 'Product identifier, reference to item master (IC_ITEM_MAST.ITEM_NBR)';


--
-- Name: COLUMN fc_item_dflt.safety_stk_min_prd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.fc_item_dflt.safety_stk_min_prd IS 'The minimum number of periods of safety stock that should be maintained based on the selected forecast model.';


--
-- Name: COLUMN fc_item_dflt.safety_stk_max_prd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.fc_item_dflt.safety_stk_max_prd IS 'The maximum number of periods of safety stock that should be maintained based on the selected forecast model.';


--
-- Name: COLUMN fc_item_dflt.safety_stk_min_unit; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.fc_item_dflt.safety_stk_min_unit IS 'The minimum number of periods of safety stock that should be maintained based on the selected forecast model.';


--
-- Name: COLUMN fc_item_dflt.safety_stk_max_unit; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.fc_item_dflt.safety_stk_max_unit IS 'The maximum number of periods of safety stock that should be maintained based on the selected forecast model.';


--
-- Name: COLUMN fc_item_dflt.intro_dt; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.fc_item_dflt.intro_dt IS 'Introduction date.  The date the item became active.';


--
-- Name: COLUMN fc_item_dflt.calendar; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.fc_item_dflt.calendar IS 'The name of the calendar to be used for this entity.';


--
-- Name: COLUMN fc_item_dflt.fcst_mdl_grp; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.fc_item_dflt.fcst_mdl_grp IS 'The name of the forecast model group to be used for this entity.';


--
-- Name: fc_item_dflt_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.fc_item_dflt_nbr_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.fc_item_dflt_nbr_seq OWNER TO jjs;

--
-- Name: fc_item_fcst_mdl_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.fc_item_fcst_mdl_nbr_seq
    START WITH 1303855
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.fc_item_fcst_mdl_nbr_seq OWNER TO jjs;

--
-- Name: fc_item_mast_dtl; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.fc_item_mast_dtl (
    fc_item_mast_nbr_src integer NOT NULL,
    fc_item_mast_nbr integer NOT NULL,
    fcst_ratio numeric(10,3)
);


ALTER TABLE aerodemo.fc_item_mast_dtl OWNER TO jjs;

--
-- Name: COLUMN fc_item_mast_dtl.fc_item_mast_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.fc_item_mast_dtl.fc_item_mast_nbr IS 'Surrogate primary key for FC_ITEM_MAST.';


--
-- Name: fc_item_mast_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.fc_item_mast_nbr_seq
    START WITH 126150
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.fc_item_mast_nbr_seq OWNER TO jjs;

--
-- Name: fc_item_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.fc_item_nbr_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.fc_item_nbr_seq OWNER TO jjs;

--
-- Name: fc_item_unforecastable; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.fc_item_unforecastable (
    fc_item_mast_nbr integer
);


ALTER TABLE aerodemo.fc_item_unforecastable OWNER TO jjs;

--
-- Name: COLUMN fc_item_unforecastable.fc_item_mast_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.fc_item_unforecastable.fc_item_mast_nbr IS 'Surrogate primary key for FC_ITEM_MAST.';


--
-- Name: fc_queue; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.fc_queue (
    fc_item_mast_nbr integer NOT NULL,
    rqst_stat_id character varying(1) DEFAULT 'Q'::character varying NOT NULL,
    CONSTRAINT fq_check_rqst_stat_id CHECK (((rqst_stat_id)::text = ANY (ARRAY[('Q'::character varying)::text, ('P'::character varying)::text])))
);


ALTER TABLE aerodemo.fc_queue OWNER TO jjs;

--
-- Name: fcst_grp; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.fcst_grp (
    fcst_grp character varying(8) NOT NULL,
    fcst_grp_descr character varying(60) NOT NULL,
    ut_user_nbr integer NOT NULL,
    last_mod_dt timestamp without time zone NOT NULL,
    oo_prty smallint NOT NULL,
    wo_prty smallint NOT NULL,
    ss_prty smallint NOT NULL,
    fc_prty smallint NOT NULL
);


ALTER TABLE aerodemo.fcst_grp OWNER TO jjs;

--
-- Name: COLUMN fcst_grp.fcst_grp; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.fcst_grp.fcst_grp IS 'The group to which this customer is to be aggregated when forecasting.';


--
-- Name: COLUMN fcst_grp.ut_user_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.fcst_grp.ut_user_nbr IS 'Surrogate primary key for UT_USER';


--
-- Name: fcst_report_dtl; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.fcst_report_dtl (
    session_id character varying(100) NOT NULL,
    grouping_string character varying(100) NOT NULL,
    sort_seq smallint,
    dmd_type character varying(40) NOT NULL,
    qty_mnth_1 bigint,
    qty_mnth_2 bigint,
    qty_mnth_3 bigint,
    qty_mnth_4 bigint,
    qty_mnth_5 bigint,
    qty_mnth_6 bigint,
    qty_mnth_7 bigint,
    qty_mnth_8 bigint,
    qty_mnth_9 bigint,
    qty_mnth_10 bigint,
    qty_mnth_11 bigint,
    qty_mnth_12 bigint
);


ALTER TABLE aerodemo.fcst_report_dtl OWNER TO jjs;

--
-- Name: fim_attr; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.fim_attr (
    fc_item_mast_nbr integer NOT NULL,
    item_nbr integer,
    svc_lvl numeric(5,2),
    tot_lead_time smallint NOT NULL,
    safety_stk_min_prd numeric(3,1),
    safety_stk_max_prd numeric(3,1),
    safety_stk_min_unit numeric(11,3),
    safety_stk_max_unit numeric(17,6),
    replen_qty_min_unit integer,
    replen_qty_max_unit integer,
    replen_qty_min_prd numeric(4,1),
    replen_qty_max_prd numeric(4,1),
    store_alt_fcst_flg character varying(1),
    arch_alt_fcst_flg character varying(1),
    calendar character varying(6),
    fcst_mdl_grp character varying(8),
    stat_id character varying(1),
    aps_src_rule_set_nbr integer,
    safety_stk_adj integer,
    fcst_type_id character varying(1) NOT NULL,
    org_nbr_cust integer,
    rev_lvl character varying(5),
    org_nbr_mfr_rqst integer,
    fcst_grp character varying(8),
    fc_item_mast_stat_id character varying(1) NOT NULL,
    fc_item_mast_descr character varying(30),
    safety_stk_alloc_qty integer,
    fcst_end_dt timestamp without time zone,
    unit_cost_stk_um numeric(17,6),
    safety_stk_calc numeric(10,2),
    safety_stk_constrain numeric(10,2),
    cust_ref_cd character varying(40),
    safety_stk_avail_to_sell character varying(1) NOT NULL,
    hard_alloc_fc_within_lead_tm character varying(1) NOT NULL,
    fc_build_rate_grp_cd character varying(10),
    descr character varying(50),
    prod_line character varying(20) NOT NULL,
    style character varying(20) NOT NULL,
    color character varying(20) NOT NULL,
    prod_size character varying(20) NOT NULL,
    cust_grp character varying(8) NOT NULL
);


ALTER TABLE aerodemo.fim_attr OWNER TO jjs;

--
-- Name: COLUMN fim_attr.fc_item_mast_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.fim_attr.fc_item_mast_nbr IS 'Surrogate primary key for FC_ITEM_MAST.';


--
-- Name: COLUMN fim_attr.item_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.fim_attr.item_nbr IS 'Product identifier, reference to item master (IC_ITEM_MAST.ITEM_NBR)';


--
-- Name: COLUMN fim_attr.safety_stk_min_prd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.fim_attr.safety_stk_min_prd IS 'The minimum number of periods of safety stock that should be maintained based on the selected forecast model.';


--
-- Name: COLUMN fim_attr.safety_stk_max_prd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.fim_attr.safety_stk_max_prd IS 'The maximum number of periods of safety stock that should be maintained based on the selected forecast model.';


--
-- Name: COLUMN fim_attr.safety_stk_min_unit; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.fim_attr.safety_stk_min_unit IS 'The minimum number of periods of safety stock that should be maintained based on the selected forecast model.';


--
-- Name: COLUMN fim_attr.safety_stk_max_unit; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.fim_attr.safety_stk_max_unit IS 'The maximum number of periods of safety stock that should be maintained based on the selected forecast model.';


--
-- Name: COLUMN fim_attr.replen_qty_min_prd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.fim_attr.replen_qty_min_prd IS 'The minimum periods of demand which should be replenished at one time.';


--
-- Name: COLUMN fim_attr.replen_qty_max_prd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.fim_attr.replen_qty_max_prd IS 'The maximum periods of demand which should be replenished at one time.';


--
-- Name: COLUMN fim_attr.calendar; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.fim_attr.calendar IS 'The business calendar associated with this date.';


--
-- Name: COLUMN fim_attr.fcst_mdl_grp; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.fim_attr.fcst_mdl_grp IS 'The name of the forecast model group to be used for this entity.';


--
-- Name: COLUMN fim_attr.fcst_type_id; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.fim_attr.fcst_type_id IS 'H - History Aggregated Forecast, F - Forecast Aggregated Forecast';


--
-- Name: COLUMN fim_attr.org_nbr_cust; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.fim_attr.org_nbr_cust IS 'Reference to the customer (OE_CUST_MAST.ORG_NBR_CUST)';


--
-- Name: COLUMN fim_attr.rev_lvl; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.fim_attr.rev_lvl IS 'The revision level of a SKU required to satisfy sourcing in advanced planning.';


--
-- Name: COLUMN fim_attr.fcst_grp; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.fim_attr.fcst_grp IS 'The group to which this customer is to be aggregated when forecasting.';


--
-- Name: COLUMN fim_attr.fc_item_mast_stat_id; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.fim_attr.fc_item_mast_stat_id IS '?????????????????';


--
-- Name: COLUMN fim_attr.fc_item_mast_descr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.fim_attr.fc_item_mast_descr IS 'Description of this forecasting entity.';


--
-- Name: COLUMN fim_attr.safety_stk_alloc_qty; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.fim_attr.safety_stk_alloc_qty IS '????????????????';


--
-- Name: COLUMN fim_attr.unit_cost_stk_um; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.fim_attr.unit_cost_stk_um IS 'cost per unit in the base currency for the stock keeping unit of measure';


--
-- Name: COLUMN fim_attr.cust_ref_cd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.fim_attr.cust_ref_cd IS '???????????????????';


--
-- Name: COLUMN fim_attr.safety_stk_avail_to_sell; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.fim_attr.safety_stk_avail_to_sell IS '??????????????????';


--
-- Name: COLUMN fim_attr.hard_alloc_fc_within_lead_tm; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.fim_attr.hard_alloc_fc_within_lead_tm IS '??????????????????';


--
-- Name: COLUMN fim_attr.fc_build_rate_grp_cd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.fim_attr.fc_build_rate_grp_cd IS '????????????????';


--
-- Name: fim_msg; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.fim_msg (
    fim_msg_nbr bigint,
    fc_item_mast_nbr integer,
    msg_cd character varying(20),
    msg character varying(2000),
    msg_time timestamp without time zone
);


ALTER TABLE aerodemo.fim_msg OWNER TO jjs;

--
-- Name: COLUMN fim_msg.fc_item_mast_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.fim_msg.fc_item_mast_nbr IS 'Surrogate primary key for FC_ITEM_MAST.';


--
-- Name: gl_tax_grp_dtl_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.gl_tax_grp_dtl_nbr_seq
    START WITH 41
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.gl_tax_grp_dtl_nbr_seq OWNER TO jjs;

--
-- Name: gl_tax_grp_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.gl_tax_grp_nbr_seq
    START WITH 42
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.gl_tax_grp_nbr_seq OWNER TO jjs;

--
-- Name: hold_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.hold_nbr_seq
    START WITH 208
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.hold_nbr_seq OWNER TO jjs;

--
-- Name: hundred_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.hundred_seq
    START WITH 1500001
    INCREMENT BY 100
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.hundred_seq OWNER TO jjs;

--
-- Name: ic_attr; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.ic_attr (
    ic_attr_nbr integer NOT NULL,
    attr_nm character varying(16) NOT NULL,
    attr_descr character varying(60) NOT NULL,
    attr_seq smallint,
    reqr_flg character varying(1) NOT NULL,
    attr_constr_flg character varying(1) NOT NULL,
    ut_user_nbr integer NOT NULL,
    last_mod_dt timestamp without time zone NOT NULL,
    CONSTRAINT sys_c0015978 CHECK (((reqr_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0015979 CHECK (((attr_constr_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text])))
);


ALTER TABLE aerodemo.ic_attr OWNER TO jjs;

--
-- Name: COLUMN ic_attr.ic_attr_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_attr.ic_attr_nbr IS 'Surrogate primary key for IC_ATTR_NBR';


--
-- Name: COLUMN ic_attr.attr_nm; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_attr.attr_nm IS 'Attribute name.';


--
-- Name: COLUMN ic_attr.attr_descr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_attr.attr_descr IS 'Attribute description.';


--
-- Name: COLUMN ic_attr.attr_seq; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_attr.attr_seq IS 'Attribute sequence.  Affects the order in which the attribute is displayed on certain screens.';


--
-- Name: COLUMN ic_attr.ut_user_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_attr.ut_user_nbr IS 'Surrogate primary key for UT_USER';


--
-- Name: ic_attr_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.ic_attr_nbr_seq
    START WITH 284
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.ic_attr_nbr_seq OWNER TO jjs;

--
-- Name: ic_attr_val; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.ic_attr_val (
    ic_attr_nbr integer NOT NULL,
    attr_val character varying(20) NOT NULL,
    attr_val_descr character varying(60),
    ut_user_nbr integer NOT NULL,
    last_mod_dt timestamp without time zone NOT NULL,
    sort_seq smallint
);


ALTER TABLE aerodemo.ic_attr_val OWNER TO jjs;

--
-- Name: COLUMN ic_attr_val.ic_attr_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_attr_val.ic_attr_nbr IS 'Surrogate primary key for IC_ATTR_NBR';


--
-- Name: COLUMN ic_attr_val.attr_val; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_attr_val.attr_val IS 'Attribute value.';


--
-- Name: COLUMN ic_attr_val.ut_user_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_attr_val.ut_user_nbr IS 'Surrogate primary key for UT_USER';


--
-- Name: ic_attr_val_bak; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.ic_attr_val_bak (
    ic_attr_nbr integer NOT NULL,
    attr_val character varying(20) NOT NULL,
    attr_val_descr character varying(60),
    ut_user_nbr integer NOT NULL,
    last_mod_dt timestamp without time zone NOT NULL,
    sort_seq smallint
);


ALTER TABLE aerodemo.ic_attr_val_bak OWNER TO jjs;

--
-- Name: ic_bom; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.ic_bom (
    item_nbr integer NOT NULL,
    item_nbr_parent integer,
    child_qty numeric(13,6) NOT NULL,
    child_um character varying(3) NOT NULL,
    ut_user_nbr integer NOT NULL,
    last_mod_dt timestamp without time zone NOT NULL,
    mix_mfr_lot_flg character varying(1) NOT NULL,
    print_bag_lbl_flg character varying(1) NOT NULL,
    rev_lvl character varying(5),
    org_nbr_mfr_rqst integer,
    mandatory_item_flg character varying(1) NOT NULL,
    CONSTRAINT sys_c0015177 CHECK (((mix_mfr_lot_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0015178 CHECK (((print_bag_lbl_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0015179 CHECK (((mandatory_item_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text])))
);


ALTER TABLE aerodemo.ic_bom OWNER TO jjs;

--
-- Name: COLUMN ic_bom.item_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_bom.item_nbr IS 'Product identifier, reference to item master (IC_ITEM_MAST.ITEM_NBR)';


--
-- Name: COLUMN ic_bom.ut_user_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_bom.ut_user_nbr IS 'Surrogate primary key for UT_USER';


--
-- Name: COLUMN ic_bom.rev_lvl; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_bom.rev_lvl IS 'The revision level of the part.';


--
-- Name: ic_bom_cert; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.ic_bom_cert (
    item_nbr integer NOT NULL,
    item_nbr_parent integer NOT NULL,
    cert_cd character varying(8) NOT NULL,
    ut_user_nbr integer NOT NULL,
    last_mod_dt timestamp without time zone NOT NULL
);


ALTER TABLE aerodemo.ic_bom_cert OWNER TO jjs;

--
-- Name: COLUMN ic_bom_cert.item_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_bom_cert.item_nbr IS 'Product identifier, reference to item master (IC_ITEM_MAST.ITEM_NBR)';


--
-- Name: COLUMN ic_bom_cert.ut_user_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_bom_cert.ut_user_nbr IS 'Surrogate primary key for UT_USER';


--
-- Name: ic_category; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.ic_category (
    ic_category_nbr integer NOT NULL,
    ic_category_nbr_parent integer,
    ic_category_nm character varying(16) NOT NULL,
    ic_category_descr character varying(30),
    ut_user_nbr integer NOT NULL,
    last_mod_dt timestamp without time zone NOT NULL,
    po_vnd_set_hdr_nbr integer,
    ic_category_collate_nbr smallint,
    print_mfr_flg character varying(1)
);


ALTER TABLE aerodemo.ic_category OWNER TO jjs;

--
-- Name: COLUMN ic_category.ic_category_nm; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_category.ic_category_nm IS 'The category associated with the capacity for this manufacturer.';


--
-- Name: COLUMN ic_category.ut_user_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_category.ut_user_nbr IS 'Surrogate primary key for UT_USER';


--
-- Name: ic_category_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.ic_category_nbr_seq
    START WITH 737
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.ic_category_nbr_seq OWNER TO jjs;

--
-- Name: ic_category_old; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.ic_category_old (
    ic_category_nbr integer NOT NULL,
    ic_category_nbr_parent integer,
    ic_category_nm character varying(16) NOT NULL,
    ic_category_descr character varying(30),
    ut_user_nbr integer NOT NULL,
    last_mod_dt timestamp without time zone NOT NULL,
    po_vnd_set_hdr_nbr integer,
    ic_category_collate_nbr smallint
);


ALTER TABLE aerodemo.ic_category_old OWNER TO jjs;

--
-- Name: ic_cert_cd; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.ic_cert_cd (
    cert_cd character varying(8) NOT NULL,
    cert_cd_descr character varying(60),
    ut_user_nbr integer NOT NULL,
    last_mod_dt timestamp without time zone NOT NULL,
    doc_flg character varying(1) NOT NULL,
    cert_value smallint,
    cert_src_id character varying(1),
    stat_id character varying(1),
    CONSTRAINT sys_c0015193 CHECK (((doc_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0016150 CHECK (((cert_src_id)::text = ANY (ARRAY[('V'::character varying)::text, ('M'::character varying)::text, ('Q'::character varying)::text])))
);


ALTER TABLE aerodemo.ic_cert_cd OWNER TO jjs;

--
-- Name: COLUMN ic_cert_cd.ut_user_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_cert_cd.ut_user_nbr IS 'Surrogate primary key for UT_USER';


--
-- Name: ic_item_attr; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.ic_item_attr (
    item_nbr integer NOT NULL,
    ic_attr_nbr integer NOT NULL,
    attr_val character varying(20) NOT NULL,
    ut_user_nbr integer NOT NULL,
    last_mod_dt timestamp without time zone NOT NULL
);


ALTER TABLE aerodemo.ic_item_attr OWNER TO jjs;

--
-- Name: COLUMN ic_item_attr.item_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_item_attr.item_nbr IS 'A foreign key back to the item master.';


--
-- Name: COLUMN ic_item_attr.ic_attr_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_item_attr.ic_attr_nbr IS 'Surrogate primary key for IC_ATTR_NBR';


--
-- Name: COLUMN ic_item_attr.attr_val; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_item_attr.attr_val IS 'Attribute value.';


--
-- Name: COLUMN ic_item_attr.ut_user_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_item_attr.ut_user_nbr IS 'Surrogate primary key for UT_USER';


--
-- Name: ic_item_attr_bak; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.ic_item_attr_bak (
    item_nbr integer NOT NULL,
    ic_attr_nbr integer NOT NULL,
    attr_val character varying(20) NOT NULL,
    ut_user_nbr integer NOT NULL,
    last_mod_dt timestamp without time zone NOT NULL
);


ALTER TABLE aerodemo.ic_item_attr_bak OWNER TO jjs;

--
-- Name: ic_item_cost; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.ic_item_cost (
    item_nbr integer NOT NULL,
    cost_type_cd character varying(16) NOT NULL,
    unit_cost numeric(17,6) NOT NULL,
    cost_calc_dt timestamp without time zone,
    ut_user_nbr integer NOT NULL,
    last_mod_dt timestamp without time zone NOT NULL
);


ALTER TABLE aerodemo.ic_item_cost OWNER TO jjs;

--
-- Name: COLUMN ic_item_cost.item_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_item_cost.item_nbr IS 'Product identifier, reference to item master (IC_ITEM_MAST.ITEM_NBR)';


--
-- Name: COLUMN ic_item_cost.unit_cost; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_item_cost.unit_cost IS 'Cost per unit in the replenishment unit of measure and currency.';


--
-- Name: COLUMN ic_item_cost.ut_user_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_item_cost.ut_user_nbr IS 'Surrogate primary key for UT_USER';


--
-- Name: ic_item_cust_subst; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.ic_item_cust_subst (
    item_nbr integer NOT NULL,
    org_nbr_cust integer NOT NULL,
    item_nbr_subst integer NOT NULL,
    ut_user_nbr integer NOT NULL,
    last_mod_dt timestamp without time zone NOT NULL
);


ALTER TABLE aerodemo.ic_item_cust_subst OWNER TO jjs;

--
-- Name: COLUMN ic_item_cust_subst.item_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_item_cust_subst.item_nbr IS 'Product identifier, reference to item master (IC_ITEM_MAST.ITEM_NBR)';


--
-- Name: COLUMN ic_item_cust_subst.org_nbr_cust; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_item_cust_subst.org_nbr_cust IS 'Reference to the customer (OE_CUST_MAST.ORG_NBR_CUST)';


--
-- Name: COLUMN ic_item_cust_subst.ut_user_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_item_cust_subst.ut_user_nbr IS 'Surrogate primary key for UT_USER';


--
-- Name: ic_item_mast_equiv; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.ic_item_mast_equiv (
    item_nbr integer NOT NULL,
    item_nbr_equiv integer NOT NULL,
    ut_user_nbr integer NOT NULL,
    last_mod_dt timestamp without time zone NOT NULL
);


ALTER TABLE aerodemo.ic_item_mast_equiv OWNER TO jjs;

--
-- Name: COLUMN ic_item_mast_equiv.item_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_item_mast_equiv.item_nbr IS 'Product identifier, reference to item master (IC_ITEM_MAST.ITEM_NBR)';


--
-- Name: COLUMN ic_item_mast_equiv.ut_user_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_item_mast_equiv.ut_user_nbr IS 'Surrogate primary key for UT_USER';


--
-- Name: ic_item_equiv_mast_vw; Type: VIEW; Schema: aerodemo; Owner: jjs
--

CREATE VIEW aerodemo.ic_item_equiv_mast_vw AS
 SELECT iim1.item_cd,
    iim2.item_cd AS item_cd_equiv
   FROM aerodemo.ic_item_mast iim1,
    aerodemo.ic_item_mast iim2,
    aerodemo.ic_item_mast_equiv iime
  WHERE ((iime.item_nbr = iim1.item_nbr) AND (iime.item_nbr_equiv = iim2.item_nbr));


ALTER TABLE aerodemo.ic_item_equiv_mast_vw OWNER TO jjs;

--
-- Name: ic_item_loc_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.ic_item_loc_nbr_seq
    START WITH 6301147
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.ic_item_loc_nbr_seq OWNER TO jjs;

--
-- Name: ic_item_mast_cert; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.ic_item_mast_cert (
    item_nbr integer NOT NULL,
    cert_cd character varying(8) NOT NULL,
    ut_user_nbr integer NOT NULL,
    last_mod_dt timestamp without time zone NOT NULL
);


ALTER TABLE aerodemo.ic_item_mast_cert OWNER TO jjs;

--
-- Name: COLUMN ic_item_mast_cert.item_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_item_mast_cert.item_nbr IS 'Product identifier, reference to item master (IC_ITEM_MAST.ITEM_NBR)';


--
-- Name: COLUMN ic_item_mast_cert.ut_user_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_item_mast_cert.ut_user_nbr IS 'Surrogate primary key for UT_USER';


--
-- Name: ic_item_mast_equiv_ref; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.ic_item_mast_equiv_ref (
    item_nbr integer NOT NULL,
    item_nbr_equiv integer NOT NULL,
    ut_user_nbr integer NOT NULL,
    last_mod_dt timestamp without time zone NOT NULL
);


ALTER TABLE aerodemo.ic_item_mast_equiv_ref OWNER TO jjs;

--
-- Name: COLUMN ic_item_mast_equiv_ref.item_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_item_mast_equiv_ref.item_nbr IS 'Product identifier, reference to item master (IC_ITEM_MAST.ITEM_NBR)';


--
-- Name: COLUMN ic_item_mast_equiv_ref.ut_user_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_item_mast_equiv_ref.ut_user_nbr IS 'Surrogate primary key for UT_USER';


--
-- Name: ic_item_mast_nomen; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.ic_item_mast_nomen (
    item_nbr integer NOT NULL,
    org_nbr_nomen integer NOT NULL,
    item_cd_nomen character varying(50) NOT NULL,
    item_descr_nomen character varying(50),
    ut_user_nbr integer NOT NULL,
    last_mod_dt timestamp without time zone NOT NULL,
    display_flg character varying(1) NOT NULL,
    CONSTRAINT sys_c0015288 CHECK (((display_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text])))
);


ALTER TABLE aerodemo.ic_item_mast_nomen OWNER TO jjs;

--
-- Name: COLUMN ic_item_mast_nomen.item_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_item_mast_nomen.item_nbr IS 'Product identifier, reference to item master (IC_ITEM_MAST.ITEM_NBR)';


--
-- Name: COLUMN ic_item_mast_nomen.ut_user_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_item_mast_nomen.ut_user_nbr IS 'Surrogate primary key for UT_USER';


--
-- Name: ic_item_mast_nomen_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.ic_item_mast_nomen_nbr_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.ic_item_mast_nomen_nbr_seq OWNER TO jjs;

--
-- Name: ic_item_mast_org_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.ic_item_mast_org_nbr_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.ic_item_mast_org_nbr_seq OWNER TO jjs;

--
-- Name: ic_item_mast_rel; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.ic_item_mast_rel (
    item_nbr integer NOT NULL,
    item_nbr_rel integer NOT NULL,
    ut_user_nbr integer NOT NULL,
    last_mod_dt timestamp without time zone NOT NULL
);


ALTER TABLE aerodemo.ic_item_mast_rel OWNER TO jjs;

--
-- Name: COLUMN ic_item_mast_rel.item_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_item_mast_rel.item_nbr IS 'Product identifier, reference to item master (IC_ITEM_MAST.ITEM_NBR)';


--
-- Name: COLUMN ic_item_mast_rel.ut_user_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_item_mast_rel.ut_user_nbr IS 'Surrogate primary key for UT_USER';


--
-- Name: ic_item_mast_upd_queue; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.ic_item_mast_upd_queue (
    item_nbr integer NOT NULL,
    lead_tm_dy_new integer NOT NULL,
    ut_user_nbr_upd integer NOT NULL
);


ALTER TABLE aerodemo.ic_item_mast_upd_queue OWNER TO jjs;

--
-- Name: COLUMN ic_item_mast_upd_queue.item_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_item_mast_upd_queue.item_nbr IS 'Product identifier, reference to item master (IC_ITEM_MAST.ITEM_NBR)';


--
-- Name: na_indiv; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.na_indiv (
    indiv_nbr integer NOT NULL,
    sort_nm character varying(41) NOT NULL,
    first_nm character varying(20) NOT NULL,
    middle_init character varying(1),
    last_nm character varying(20) NOT NULL,
    salutation_cd character varying(4),
    ut_user_nbr integer NOT NULL,
    last_mod_dt timestamp without time zone NOT NULL,
    indiv_descr character varying(40),
    phn_nbr_dflt character varying(20),
    fax_nbr_dflt character varying(20),
    email_addr_dflt character varying(200)
);


ALTER TABLE aerodemo.na_indiv OWNER TO jjs;

--
-- Name: COLUMN na_indiv.indiv_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.na_indiv.indiv_nbr IS 'Surrogate primary key for INDIV_NBR';


--
-- Name: COLUMN na_indiv.middle_init; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.na_indiv.middle_init IS 'The first letter of an individual''s middle name, not the surname or given name.';


--
-- Name: COLUMN na_indiv.ut_user_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.na_indiv.ut_user_nbr IS 'Surrogate primary key for UT_USER';


--
-- Name: COLUMN na_indiv.phn_nbr_dflt; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.na_indiv.phn_nbr_dflt IS 'Default telephone number for this entity.';


--
-- Name: ic_item_mast_vw; Type: VIEW; Schema: aerodemo; Owner: jjs
--

CREATE VIEW aerodemo.ic_item_mast_vw AS
 SELECT iim.item_cd,
    iim.item_nbr,
    iim.item_descr,
    iim.stk_um,
    iim.sell_um,
    iim.std_cost,
    iim.list_price,
    iim.upc_cd,
    iim.ean,
    iim.qty_per_box,
    iim.box_per_ctn,
    iim.sls_qty_min,
    iim.sls_qty_incr,
    iim.replen_qty_min,
    iim.replen_qty_incr,
    iim.ic_category_nbr,
    ic.ic_category_nm,
    iim.non_stk_flg,
    iim.ser_nbr_reqr_flg,
    iim.mfr_ser_nbr_reqr_flg,
    iim.inspect_reqr_flg,
    iim.mfr_lot_ctrl_flg,
    iim.kit_flg,
    iim.price_chg_flg,
    iim.ut_user_nbr,
    iim.last_mod_dt,
    iim.sell_flg,
    iim.harmonized_cd,
    iim.plan_bucket_sz,
    iim.curr_cd,
    iim.reqr_mfr_flg,
    iim.shelf_life_dy,
    iim.lead_tm_dy,
    iim.indiv_nbr_buyer,
    buyer.sort_nm,
    iim.stat_id,
    iim.pick_scan_id,
    iim.intro_dt,
    iim.split_at_bin_flg,
    iim.label_nm_box,
    iim.ic_recv_rule_cd,
    iim.cycle_cnt_rule_cd,
    iim.fifo_dt_id,
    iim.replen_type_id,
    iim.item_nbr_primary,
    iim.item_nbr_supersede,
    iim.sched_qty_optimal,
    iim.img_image_set_hdr_nbr,
    iim.item_wght,
    iim.ctn_volume,
    iim.user_fld_1,
    iim.user_fld_2,
    iim.user_fld_3,
    iim.user_fld_4,
    iim.user_fld_5,
    iim.user_fld_6,
    iim.user_fld_7,
    iim.user_fld_8,
    iim.user_fld_9
   FROM aerodemo.ic_item_mast iim,
    aerodemo.ic_category ic,
    aerodemo.na_indiv buyer
  WHERE ((iim.ic_category_nbr = ic.ic_category_nbr) AND (iim.indiv_nbr_buyer = buyer.indiv_nbr));


ALTER TABLE aerodemo.ic_item_mast_vw OWNER TO jjs;

--
-- Name: ic_item_mfg_path; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.ic_item_mfg_path (
    item_nbr integer NOT NULL,
    mfg_path_cd character varying(16) NOT NULL,
    ut_user_nbr integer NOT NULL,
    last_mod_dt timestamp without time zone NOT NULL
);


ALTER TABLE aerodemo.ic_item_mfg_path OWNER TO jjs;

--
-- Name: COLUMN ic_item_mfg_path.item_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_item_mfg_path.item_nbr IS 'Product identifier, reference to item master (IC_ITEM_MAST.ITEM_NBR)';


--
-- Name: COLUMN ic_item_mfg_path.ut_user_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_item_mfg_path.ut_user_nbr IS 'Surrogate primary key for UT_USER';


--
-- Name: ic_item_narr; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.ic_item_narr (
    item_nbr integer NOT NULL,
    item_narr character varying(4000) NOT NULL,
    ut_user_nbr integer NOT NULL,
    last_mod_dt timestamp without time zone NOT NULL
);


ALTER TABLE aerodemo.ic_item_narr OWNER TO jjs;

--
-- Name: COLUMN ic_item_narr.item_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_item_narr.item_nbr IS 'Product identifier, reference to item master (IC_ITEM_MAST.ITEM_NBR)';


--
-- Name: COLUMN ic_item_narr.ut_user_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_item_narr.ut_user_nbr IS 'Surrogate primary key for UT_USER';


--
-- Name: ic_item_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.ic_item_nbr_seq
    START WITH 10201
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.ic_item_nbr_seq OWNER TO jjs;

--
-- Name: ic_item_operation_yield; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.ic_item_operation_yield (
    item_nbr integer NOT NULL,
    operation_cd character varying(16) NOT NULL,
    yield_pct numeric(5,2) NOT NULL,
    ut_user_nbr integer NOT NULL,
    last_mod_dt timestamp without time zone NOT NULL
);


ALTER TABLE aerodemo.ic_item_operation_yield OWNER TO jjs;

--
-- Name: COLUMN ic_item_operation_yield.item_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_item_operation_yield.item_nbr IS 'Product identifier, reference to item master (IC_ITEM_MAST.ITEM_NBR)';


--
-- Name: COLUMN ic_item_operation_yield.ut_user_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_item_operation_yield.ut_user_nbr IS 'Surrogate primary key for UT_USER';


--
-- Name: ic_item_price_matrix; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.ic_item_price_matrix (
    item_nbr integer NOT NULL,
    qty_ord numeric(13,5) NOT NULL,
    list_price numeric(17,6) NOT NULL,
    ut_user_nbr integer NOT NULL,
    last_mod_dt timestamp without time zone NOT NULL,
    curr_cd character varying(3) NOT NULL
);


ALTER TABLE aerodemo.ic_item_price_matrix OWNER TO jjs;

--
-- Name: COLUMN ic_item_price_matrix.item_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_item_price_matrix.item_nbr IS 'Product identifier, reference to item master (IC_ITEM_MAST.ITEM_NBR)';


--
-- Name: COLUMN ic_item_price_matrix.qty_ord; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_item_price_matrix.qty_ord IS 'The quantity ordered';


--
-- Name: COLUMN ic_item_price_matrix.ut_user_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_item_price_matrix.ut_user_nbr IS 'Surrogate primary key for UT_USER';


--
-- Name: COLUMN ic_item_price_matrix.curr_cd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_item_price_matrix.curr_cd IS 'The ANSI X.12 currency code associated with the unit cost.';


--
-- Name: ic_item_restrict_cust; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.ic_item_restrict_cust (
    item_nbr integer NOT NULL,
    org_nbr_cust integer NOT NULL,
    ut_user_nbr integer NOT NULL,
    last_mod_dt timestamp without time zone NOT NULL
);


ALTER TABLE aerodemo.ic_item_restrict_cust OWNER TO jjs;

--
-- Name: COLUMN ic_item_restrict_cust.item_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_item_restrict_cust.item_nbr IS 'Product identifier, reference to item master (IC_ITEM_MAST.ITEM_NBR)';


--
-- Name: COLUMN ic_item_restrict_cust.org_nbr_cust; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_item_restrict_cust.org_nbr_cust IS 'Reference to the customer (OE_CUST_MAST.ORG_NBR_CUST';


--
-- Name: COLUMN ic_item_restrict_cust.ut_user_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_item_restrict_cust.ut_user_nbr IS 'Surrogate primary key for UT_USER';


--
-- Name: ic_item_rev_lvl; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.ic_item_rev_lvl (
    item_nbr integer NOT NULL,
    rev_lvl character varying(5) NOT NULL,
    rev_lvl_eff_dt timestamp without time zone,
    ut_user_nbr integer NOT NULL,
    last_mod_dt timestamp without time zone NOT NULL
);


ALTER TABLE aerodemo.ic_item_rev_lvl OWNER TO jjs;

--
-- Name: COLUMN ic_item_rev_lvl.item_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_item_rev_lvl.item_nbr IS 'Product identifier, reference to item master (IC_ITEM_MAST.ITEM_NBR)';


--
-- Name: COLUMN ic_item_rev_lvl.rev_lvl; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_item_rev_lvl.rev_lvl IS 'The revision level of the part from the lot master or ic_multiple_cert_rev_lvl.';


--
-- Name: COLUMN ic_item_rev_lvl.ut_user_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_item_rev_lvl.ut_user_nbr IS 'Surrogate primary key for UT_USER';


--
-- Name: ic_item_rev_lvl_apply; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.ic_item_rev_lvl_apply (
    item_nbr integer NOT NULL,
    rev_lvl character varying(5) NOT NULL,
    rev_lvl_apply character varying(5) NOT NULL,
    ut_user_nbr integer NOT NULL,
    last_mod_dt timestamp without time zone NOT NULL
);


ALTER TABLE aerodemo.ic_item_rev_lvl_apply OWNER TO jjs;

--
-- Name: COLUMN ic_item_rev_lvl_apply.item_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_item_rev_lvl_apply.item_nbr IS 'Product identifier, reference to item master (IC_ITEM_MAST.ITEM_NBR)';


--
-- Name: COLUMN ic_item_rev_lvl_apply.rev_lvl; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_item_rev_lvl_apply.rev_lvl IS 'The revision level of the part from the lot master or ic_multiple_cert_rev_lvl.';


--
-- Name: COLUMN ic_item_rev_lvl_apply.ut_user_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_item_rev_lvl_apply.ut_user_nbr IS 'Surrogate primary key for UT_USER';


--
-- Name: ic_item_stat; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.ic_item_stat (
    item_nbr integer NOT NULL,
    abc_cd character varying(1),
    distinct_open_ord_cust_count integer,
    distinct_org_cust_qte integer,
    distinct_cust_open_order_count integer
);


ALTER TABLE aerodemo.ic_item_stat OWNER TO jjs;

--
-- Name: ic_item_vnd_cost_matrix; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.ic_item_vnd_cost_matrix (
    item_nbr integer NOT NULL,
    org_nbr_vnd integer NOT NULL,
    pkg_qty integer,
    qty_ord numeric(13,5) NOT NULL,
    unit_cost numeric(17,6) NOT NULL,
    unit_cost_curr_cd character varying(3) NOT NULL,
    ut_user_nbr integer NOT NULL,
    last_mod_dt timestamp without time zone NOT NULL
);


ALTER TABLE aerodemo.ic_item_vnd_cost_matrix OWNER TO jjs;

--
-- Name: COLUMN ic_item_vnd_cost_matrix.item_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_item_vnd_cost_matrix.item_nbr IS 'Product identifier, reference to item master (IC_ITEM_MAST.ITEM_NBR)';


--
-- Name: COLUMN ic_item_vnd_cost_matrix.org_nbr_vnd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_item_vnd_cost_matrix.org_nbr_vnd IS 'The organization number of the vendor from whom the inventory was purchased.';


--
-- Name: COLUMN ic_item_vnd_cost_matrix.qty_ord; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_item_vnd_cost_matrix.qty_ord IS 'The quantity ordered';


--
-- Name: COLUMN ic_item_vnd_cost_matrix.unit_cost; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_item_vnd_cost_matrix.unit_cost IS 'Cost per unit in the replenishment unit of measure and currency.';


--
-- Name: COLUMN ic_item_vnd_cost_matrix.ut_user_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_item_vnd_cost_matrix.ut_user_nbr IS 'Surrogate primary key for UT_USER';


--
-- Name: ic_kit_mast; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.ic_kit_mast (
    item_nbr integer NOT NULL,
    org_nbr_cust integer NOT NULL,
    aps_src_rule_set_nbr_dflt integer NOT NULL,
    facility_dflt character varying(16) NOT NULL,
    aps_sply_sub_pool_nbr_dflt integer NOT NULL,
    ut_user_nbr integer NOT NULL,
    last_mod_dt timestamp without time zone NOT NULL
);


ALTER TABLE aerodemo.ic_kit_mast OWNER TO jjs;

--
-- Name: COLUMN ic_kit_mast.item_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_kit_mast.item_nbr IS 'Product identifier, reference to item master (IC_ITEM_MAST.ITEM_NBR)';


--
-- Name: COLUMN ic_kit_mast.org_nbr_cust; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_kit_mast.org_nbr_cust IS 'Reference to the customer (OE_CUST_MAST.ORG_NBR_CUST';


--
-- Name: COLUMN ic_kit_mast.ut_user_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_kit_mast.ut_user_nbr IS 'Surrogate primary key for UT_USER';


--
-- Name: ic_lot_cost_hist_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.ic_lot_cost_hist_nbr_seq
    START WITH 12264
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.ic_lot_cost_hist_nbr_seq OWNER TO jjs;

--
-- Name: ic_lot_image; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.ic_lot_image (
    lot_nbr integer NOT NULL,
    img_image_set_hdr_nbr integer NOT NULL,
    cert_cd character varying(8) NOT NULL,
    qa_apprv_flg character varying(1) NOT NULL,
    CONSTRAINT ic_lot_image_qa_apprv_flg_check CHECK (((qa_apprv_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text])))
);


ALTER TABLE aerodemo.ic_lot_image OWNER TO jjs;

--
-- Name: ic_lot_mast_cert; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.ic_lot_mast_cert (
    lot_nbr integer NOT NULL,
    cert_cd character varying(8) NOT NULL,
    cert_rcpt_dt timestamp without time zone,
    ut_user_nbr integer,
    last_mod_dt timestamp without time zone,
    cert_stat_id character varying(1),
    CONSTRAINT sys_c0016271 CHECK ((ut_user_nbr IS NOT NULL)),
    CONSTRAINT sys_c0016272 CHECK ((last_mod_dt IS NOT NULL))
);


ALTER TABLE aerodemo.ic_lot_mast_cert OWNER TO jjs;

--
-- Name: ic_sply_tree_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.ic_sply_tree_nbr_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.ic_sply_tree_nbr_seq OWNER TO jjs;

--
-- Name: ic_summary_dat_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.ic_summary_dat_nbr_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.ic_summary_dat_nbr_seq OWNER TO jjs;

--
-- Name: ic_summary_dat_plan_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.ic_summary_dat_plan_nbr_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.ic_summary_dat_plan_nbr_seq OWNER TO jjs;

--
-- Name: ic_trans_gl_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.ic_trans_gl_nbr_seq
    START WITH 10184476
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE aerodemo.ic_trans_gl_nbr_seq OWNER TO jjs;

--
-- Name: ic_trans_hist_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.ic_trans_hist_nbr_seq
    START WITH 17608931
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.ic_trans_hist_nbr_seq OWNER TO jjs;

--
-- Name: ic_trans_pend_hdr_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.ic_trans_pend_hdr_nbr_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.ic_trans_pend_hdr_nbr_seq OWNER TO jjs;

--
-- Name: ic_trans_pend_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.ic_trans_pend_nbr_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.ic_trans_pend_nbr_seq OWNER TO jjs;

--
-- Name: ic_um; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.ic_um (
    um_id character varying(3) NOT NULL,
    um_id_descr character varying(30),
    um_family character varying(8),
    ut_user_nbr integer,
    last_mod_dt date,
    um_precision numeric(1,0)
);


ALTER TABLE aerodemo.ic_um OWNER TO jjs;

--
-- Name: ic_um_cnvt; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.ic_um_cnvt (
    um_id_from character varying(3) NOT NULL,
    um_id_to character varying(3) NOT NULL,
    um_cnvt_fact numeric(13,5),
    ut_user_nbr integer,
    last_mod_dt date
);


ALTER TABLE aerodemo.ic_um_cnvt OWNER TO jjs;

--
-- Name: ic_um_cnvt_item; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.ic_um_cnvt_item (
    item_nbr integer NOT NULL,
    um_id_from character varying(3) NOT NULL,
    um_id_to character varying(3) NOT NULL,
    um_cnvt_fact_item numeric(13,5) NOT NULL,
    ut_user_nbr integer NOT NULL,
    last_mod_dt timestamp without time zone NOT NULL
);


ALTER TABLE aerodemo.ic_um_cnvt_item OWNER TO jjs;

--
-- Name: COLUMN ic_um_cnvt_item.item_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_um_cnvt_item.item_nbr IS 'Product identifier, reference to item master (IC_ITEM_MAST.ITEM_NBR)';


--
-- Name: COLUMN ic_um_cnvt_item.ut_user_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_um_cnvt_item.ut_user_nbr IS 'Surrogate primary key for UT_USER';


--
-- Name: ic_vnd_onhand; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.ic_vnd_onhand (
    ic_vnd_onhand_nbr integer NOT NULL,
    item_nbr integer,
    item_cd_vnd character varying(50) NOT NULL,
    org_nbr_vnd integer NOT NULL,
    load_dt timestamp without time zone NOT NULL,
    qty_on_hand numeric(13,5) NOT NULL,
    stk_um character varying(3) NOT NULL,
    unit_price numeric(17,6)
);


ALTER TABLE aerodemo.ic_vnd_onhand OWNER TO jjs;

--
-- Name: COLUMN ic_vnd_onhand.item_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_vnd_onhand.item_nbr IS 'Product identifier, reference to item master (IC_ITEM_MAST.ITEM_NBR)';


--
-- Name: COLUMN ic_vnd_onhand.org_nbr_vnd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_vnd_onhand.org_nbr_vnd IS 'The organization number of the vendor from whom the inventory was purchased.';


--
-- Name: COLUMN ic_vnd_onhand.qty_on_hand; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_vnd_onhand.qty_on_hand IS 'Quantity on Hand in stock keeping unit of measure.';


--
-- Name: COLUMN ic_vnd_onhand.stk_um; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ic_vnd_onhand.stk_um IS 'ANSI X.12 stock keeping unit of measure.';


--
-- Name: ic_vnd_onhand_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.ic_vnd_onhand_nbr_seq
    START WITH 15384653
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.ic_vnd_onhand_nbr_seq OWNER TO jjs;

--
-- Name: ic_whse_zone_grp_dtl_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.ic_whse_zone_grp_dtl_nbr_seq
    START WITH 23
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.ic_whse_zone_grp_dtl_nbr_seq OWNER TO jjs;

--
-- Name: ic_whse_zone_grp_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.ic_whse_zone_grp_nbr_seq
    START WITH 23
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.ic_whse_zone_grp_nbr_seq OWNER TO jjs;

--
-- Name: idl_ar_inv_dtl; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.idl_ar_inv_dtl (
    ar_inv_dtl_nbr integer,
    inv_cd character varying(16),
    ord_cd character varying(16),
    ord_type_cd character varying(3),
    org_cd_cust character varying(16),
    cust_po_cd character varying(30),
    term_cd character varying(8),
    ship_via_cd character varying(8),
    fob_cd character varying(8),
    curr_cd character varying(3),
    sales_terr_cd character varying(8),
    inv_line_nbr integer,
    ord_line_nbr integer,
    item_cd_ship character varying(32),
    item_cd_cust character varying(32),
    qty_ship numeric(17,5),
    unit_price_denom numeric(17,5),
    sell_um character varying(3),
    ship_from_facility character varying(8),
    inv_dt timestamp without time zone,
    ship_dt timestamp without time zone,
    rqst_dt timestamp without time zone,
    prom_dt timestamp without time zone
);


ALTER TABLE aerodemo.idl_ar_inv_dtl OWNER TO jjs;

--
-- Name: COLUMN idl_ar_inv_dtl.ar_inv_dtl_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.idl_ar_inv_dtl.ar_inv_dtl_nbr IS 'The surrogate primary key for this table.';


--
-- Name: COLUMN idl_ar_inv_dtl.inv_cd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.idl_ar_inv_dtl.inv_cd IS 'Foreign key back to the invoice header';


--
-- Name: COLUMN idl_ar_inv_dtl.ord_cd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.idl_ar_inv_dtl.ord_cd IS 'The order code generated by order entry for the order.  This will be the same for all lines on column an invoice.';


--
-- Name: COLUMN idl_ar_inv_dtl.ord_type_cd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.idl_ar_inv_dtl.ord_type_cd IS 'Identifier for the type of order, e.g. PHN - phone, EDI - X.12, FAX, MAIL, WEB, SOA - web service';


--
-- Name: COLUMN idl_ar_inv_dtl.org_cd_cust; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.idl_ar_inv_dtl.org_cd_cust IS 'Identifier for the customer that placed the order.';


--
-- Name: COLUMN idl_ar_inv_dtl.cust_po_cd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.idl_ar_inv_dtl.cust_po_cd IS 'The purchase order number for this line assigned by the customer.';


--
-- Name: COLUMN idl_ar_inv_dtl.term_cd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.idl_ar_inv_dtl.term_cd IS 'Payment terms code.';


--
-- Name: COLUMN idl_ar_inv_dtl.ship_via_cd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.idl_ar_inv_dtl.ship_via_cd IS 'The shipment method, identifies the carrier and priority.';


--
-- Name: COLUMN idl_ar_inv_dtl.fob_cd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.idl_ar_inv_dtl.fob_cd IS 'Free on Board code.  Identifies when the customer takes ownership of this inventory.';


--
-- Name: COLUMN idl_ar_inv_dtl.curr_cd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.idl_ar_inv_dtl.curr_cd IS 'The ANSI X.12 currency code associated with the unit cost.';


--
-- Name: COLUMN idl_ar_inv_dtl.sales_terr_cd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.idl_ar_inv_dtl.sales_terr_cd IS 'The sales territory that gets credit for this sale.';


--
-- Name: COLUMN idl_ar_inv_dtl.item_cd_cust; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.idl_ar_inv_dtl.item_cd_cust IS 'The part number the customer uses to identify this part.';


--
-- Name: COLUMN idl_ar_inv_dtl.qty_ship; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.idl_ar_inv_dtl.qty_ship IS 'the quantity shipped for this invoice line in the stock keeping unit of measure.';


--
-- Name: COLUMN idl_ar_inv_dtl.sell_um; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.idl_ar_inv_dtl.sell_um IS 'ANSI X.12 unit of measure associated with the quantity ordered.';


--
-- Name: COLUMN idl_ar_inv_dtl.ship_from_facility; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.idl_ar_inv_dtl.ship_from_facility IS 'The facility from which this order line should preferably be shipped.';


--
-- Name: COLUMN idl_ar_inv_dtl.rqst_dt; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.idl_ar_inv_dtl.rqst_dt IS 'The date the customer requests the item to be shipped.';


--
-- Name: COLUMN idl_ar_inv_dtl.prom_dt; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.idl_ar_inv_dtl.prom_dt IS 'The most recent promise date.';


--
-- Name: idl_ar_inv_dtl_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.idl_ar_inv_dtl_nbr_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.idl_ar_inv_dtl_nbr_seq OWNER TO jjs;

--
-- Name: idl_cust_mast; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.idl_cust_mast (
    idl_cust_mast_nbr character varying(9),
    org_cd_cust character varying(16),
    fcst_grp character varying(8),
    sls_terr_cd character varying(8),
    sls_grp character varying(8),
    salesman_cd character varying(8)
);


ALTER TABLE aerodemo.idl_cust_mast OWNER TO jjs;

--
-- Name: TABLE idl_cust_mast; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON TABLE aerodemo.idl_cust_mast IS 'System interface table for loading customer information.';


--
-- Name: COLUMN idl_cust_mast.org_cd_cust; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.idl_cust_mast.org_cd_cust IS 'Unique Code Identifying a Customer';


--
-- Name: COLUMN idl_cust_mast.fcst_grp; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.idl_cust_mast.fcst_grp IS 'The Group assigned to the Customer for Forecasting purposes';


--
-- Name: idl_cust_mast_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.idl_cust_mast_nbr_seq
    START WITH 21
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.idl_cust_mast_nbr_seq OWNER TO jjs;

--
-- Name: idl_fc_adj; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.idl_fc_adj (
    fc_item_mast_nbr integer,
    item_cd character varying(50) NOT NULL,
    fcst_grp character varying(8) NOT NULL,
    mnth_1_adj bigint,
    mnth_2_adj bigint,
    mnth_3_adj bigint,
    mnth_4_adj bigint,
    mnth_5_adj bigint,
    mnth_6_adj bigint,
    mnth_7_adj bigint,
    mnth_8_adj bigint,
    mnth_9_adj bigint,
    mnth_10_adj bigint,
    mnth_11_adj bigint,
    mnth_12_adj bigint,
    prod_line character varying(20),
    style character varying(20),
    color character varying(20),
    sz character varying(20),
    status_id character varying(10)
);


ALTER TABLE aerodemo.idl_fc_adj OWNER TO jjs;

--
-- Name: COLUMN idl_fc_adj.fc_item_mast_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.idl_fc_adj.fc_item_mast_nbr IS 'Surrogate primary key for FC_ITEM_MAST.';


--
-- Name: COLUMN idl_fc_adj.item_cd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.idl_fc_adj.item_cd IS 'Product Number - SKU';


--
-- Name: COLUMN idl_fc_adj.fcst_grp; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.idl_fc_adj.fcst_grp IS 'The Group assigned to the Customer for Forecasting purposes';


--
-- Name: idl_fc_fcst; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.idl_fc_fcst (
    idl_fc_fcst_nbr integer,
    fc_item_mast_nbr integer NOT NULL,
    fc_fcst_dt timestamp without time zone NOT NULL,
    adj_fcst bigint NOT NULL
);


ALTER TABLE aerodemo.idl_fc_fcst OWNER TO jjs;

--
-- Name: idl_ic_item_attr; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.idl_ic_item_attr (
    idl_ic_item_attr_nbr integer,
    item_cd character varying(50) NOT NULL,
    attr_1 character varying(20),
    attr_2 character varying(20),
    attr_3 character varying(20),
    attr_4 character varying(20),
    attr_5 character varying(20),
    attr_6 character varying(20),
    attr_7 character varying(20),
    attr_8 character varying(20),
    attr_9 character varying(20),
    attr_10 character varying(20)
);


ALTER TABLE aerodemo.idl_ic_item_attr OWNER TO jjs;

--
-- Name: TABLE idl_ic_item_attr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON TABLE aerodemo.idl_ic_item_attr IS 'System interface table defining product attributes. 

At least one attribute is required if a record is present, but each item master does not require an attribute. 

Related attributes should be kept in the same attribute "bucket".';


--
-- Name: COLUMN idl_ic_item_attr.idl_ic_item_attr_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.idl_ic_item_attr.idl_ic_item_attr_nbr IS 'Surrogate key for internal purposes.';


--
-- Name: COLUMN idl_ic_item_attr.item_cd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.idl_ic_item_attr.item_cd IS 'Product identifier.';


--
-- Name: COLUMN idl_ic_item_attr.attr_1; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.idl_ic_item_attr.attr_1 IS 'Attribute value.';


--
-- Name: COLUMN idl_ic_item_attr.attr_2; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.idl_ic_item_attr.attr_2 IS 'Attribute value.';


--
-- Name: COLUMN idl_ic_item_attr.attr_3; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.idl_ic_item_attr.attr_3 IS 'Attribute value.';


--
-- Name: COLUMN idl_ic_item_attr.attr_4; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.idl_ic_item_attr.attr_4 IS 'Attribute value.';


--
-- Name: COLUMN idl_ic_item_attr.attr_5; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.idl_ic_item_attr.attr_5 IS 'Attribute value.';


--
-- Name: COLUMN idl_ic_item_attr.attr_6; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.idl_ic_item_attr.attr_6 IS 'Attribute value.';


--
-- Name: COLUMN idl_ic_item_attr.attr_7; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.idl_ic_item_attr.attr_7 IS 'Attribute value.';


--
-- Name: COLUMN idl_ic_item_attr.attr_8; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.idl_ic_item_attr.attr_8 IS 'Attribute value.';


--
-- Name: COLUMN idl_ic_item_attr.attr_9; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.idl_ic_item_attr.attr_9 IS 'Attribute value.';


--
-- Name: COLUMN idl_ic_item_attr.attr_10; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.idl_ic_item_attr.attr_10 IS 'Attribute value.';


--
-- Name: idl_ic_item_attr_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.idl_ic_item_attr_nbr_seq
    START WITH 80401
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.idl_ic_item_attr_nbr_seq OWNER TO jjs;

--
-- Name: idl_ic_item_loc; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.idl_ic_item_loc (
    idl_ic_item_loc_nbr integer,
    item_cd character varying(50) NOT NULL,
    item_descr character varying(50),
    stk_um character varying(3),
    qty_on_hand bigint NOT NULL,
    facility character varying(16),
    sply_pool_cd character varying(20),
    bin_cd character varying(16),
    rcpt_dt timestamp without time zone,
    org_cd_vnd character varying(16),
    org_cd_mfr character varying(16),
    rcpt_dt_txt character varying(16)
);


ALTER TABLE aerodemo.idl_ic_item_loc OWNER TO jjs;

--
-- Name: TABLE idl_ic_item_loc; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON TABLE aerodemo.idl_ic_item_loc IS 'Interface table for onhand inventory quanities and location.';


--
-- Name: COLUMN idl_ic_item_loc.idl_ic_item_loc_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.idl_ic_item_loc.idl_ic_item_loc_nbr IS 'Surrogate key for internal purposes.';


--
-- Name: COLUMN idl_ic_item_loc.item_cd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.idl_ic_item_loc.item_cd IS 'Product Number - SKU';


--
-- Name: COLUMN idl_ic_item_loc.item_descr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.idl_ic_item_loc.item_descr IS 'Description of the product';


--
-- Name: COLUMN idl_ic_item_loc.stk_um; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.idl_ic_item_loc.stk_um IS 'Stock Keeping Unit of Measure';


--
-- Name: COLUMN idl_ic_item_loc.qty_on_hand; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.idl_ic_item_loc.qty_on_hand IS 'Quantity on Hand in stock keeping unit of measure.';


--
-- Name: COLUMN idl_ic_item_loc.facility; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.idl_ic_item_loc.facility IS 'The facility (e.g. warehouse) in which this inventory is located.';


--
-- Name: COLUMN idl_ic_item_loc.sply_pool_cd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.idl_ic_item_loc.sply_pool_cd IS 'The supply pool associated with this inventory.';


--
-- Name: COLUMN idl_ic_item_loc.bin_cd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.idl_ic_item_loc.bin_cd IS 'The identifier for the location within the facility for this inventory.';


--
-- Name: COLUMN idl_ic_item_loc.rcpt_dt; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.idl_ic_item_loc.rcpt_dt IS 'The date this inventory was received.';


--
-- Name: COLUMN idl_ic_item_loc.org_cd_vnd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.idl_ic_item_loc.org_cd_vnd IS 'Identifies the organization from which this inventory was purchased.';


--
-- Name: COLUMN idl_ic_item_loc.org_cd_mfr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.idl_ic_item_loc.org_cd_mfr IS 'Identifies the orgranization that manufactured the inventory.';


--
-- Name: idl_ic_item_loc_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.idl_ic_item_loc_nbr_seq
    START WITH 66581
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.idl_ic_item_loc_nbr_seq OWNER TO jjs;

--
-- Name: idl_ic_item_mast; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.idl_ic_item_mast (
    idl_ic_item_mast_nbr integer,
    item_cd character varying(50) NOT NULL,
    item_descr character varying(50),
    stk_um character varying(3) NOT NULL,
    std_cost bigint,
    ic_category_nm character varying(16),
    intro_dt timestamp without time zone,
    list_price numeric(17,6)
);


ALTER TABLE aerodemo.idl_ic_item_mast OWNER TO jjs;

--
-- Name: TABLE idl_ic_item_mast; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON TABLE aerodemo.idl_ic_item_mast IS 'Interface table for minimal product definition.';


--
-- Name: COLUMN idl_ic_item_mast.idl_ic_item_mast_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.idl_ic_item_mast.idl_ic_item_mast_nbr IS 'Surrogate key for internal purposes.';


--
-- Name: COLUMN idl_ic_item_mast.item_cd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.idl_ic_item_mast.item_cd IS 'Product identifier.';


--
-- Name: COLUMN idl_ic_item_mast.item_descr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.idl_ic_item_mast.item_descr IS 'Description of product.';


--
-- Name: COLUMN idl_ic_item_mast.stk_um; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.idl_ic_item_mast.stk_um IS 'ANSI X.12 stock keeping unit of measure.';


--
-- Name: COLUMN idl_ic_item_mast.std_cost; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.idl_ic_item_mast.std_cost IS 'Standard cost in base currency for the stock keeping unit of measure.';


--
-- Name: COLUMN idl_ic_item_mast.ic_category_nm; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.idl_ic_item_mast.ic_category_nm IS 'The category associated with this product.';


--
-- Name: COLUMN idl_ic_item_mast.intro_dt; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.idl_ic_item_mast.intro_dt IS 'Introduction date.  The date the item became active.';


--
-- Name: idl_ic_item_mast_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.idl_ic_item_mast_nbr_seq
    START WITH 62961
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.idl_ic_item_mast_nbr_seq OWNER TO jjs;

--
-- Name: idl_mfr_mfg_cap; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.idl_mfr_mfg_cap (
    idl_mfr_mfg_cap_nbr integer,
    org_cd_mfr character varying(16) NOT NULL,
    daily_cap bigint NOT NULL,
    ic_category_nm character varying(16) NOT NULL
);


ALTER TABLE aerodemo.idl_mfr_mfg_cap OWNER TO jjs;

--
-- Name: TABLE idl_mfr_mfg_cap; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON TABLE aerodemo.idl_mfr_mfg_cap IS 'Interface table for manufacturing capacity constraints.';


--
-- Name: COLUMN idl_mfr_mfg_cap.idl_mfr_mfg_cap_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.idl_mfr_mfg_cap.idl_mfr_mfg_cap_nbr IS 'Surrogate key for internal purposes.';


--
-- Name: COLUMN idl_mfr_mfg_cap.org_cd_mfr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.idl_mfr_mfg_cap.org_cd_mfr IS 'Identifier for the manufacturer.';


--
-- Name: COLUMN idl_mfr_mfg_cap.daily_cap; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.idl_mfr_mfg_cap.daily_cap IS 'Daily capacity of this manufacturer for this product category.';


--
-- Name: COLUMN idl_mfr_mfg_cap.ic_category_nm; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.idl_mfr_mfg_cap.ic_category_nm IS 'The category associated with the capacity for this manufacturer.';


--
-- Name: idl_mfr_mfg_cap_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.idl_mfr_mfg_cap_nbr_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.idl_mfr_mfg_cap_nbr_seq OWNER TO jjs;

--
-- Name: idl_oe_ord_dtl; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.idl_oe_ord_dtl (
    idl_oe_ord_dtl_nbr character varying(9),
    ord_cd character varying(20) NOT NULL,
    ord_dt timestamp without time zone,
    ord_type_cd character varying(8),
    org_cd_cust character varying(16) NOT NULL,
    cust_po_cd character varying(30),
    term_cd character varying(10),
    ship_via_cd character varying(8),
    fob_cd character varying(16),
    curr_cd character varying(3),
    sales_terr_cd character varying(8),
    line_nbr character varying(5),
    item_cd character varying(50) NOT NULL,
    item_cd_cust character varying(50),
    qty_ord bigint NOT NULL,
    sell_um character varying(3),
    rqst_dt timestamp without time zone,
    prom_dt timestamp without time zone,
    ship_from_facility character varying(16),
    ord_dt_text character varying(16),
    rqst_dt_text character varying(16),
    prom_dt_text character varying(16)
);


ALTER TABLE aerodemo.idl_oe_ord_dtl OWNER TO jjs;

--
-- Name: TABLE idl_oe_ord_dtl; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON TABLE aerodemo.idl_oe_ord_dtl IS 'Interface table for customer order lines.';


--
-- Name: COLUMN idl_oe_ord_dtl.idl_oe_ord_dtl_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.idl_oe_ord_dtl.idl_oe_ord_dtl_nbr IS 'Surrogate key for internal purposes.';


--
-- Name: COLUMN idl_oe_ord_dtl.ord_cd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.idl_oe_ord_dtl.ord_cd IS 'The sales order identifier for all lines on a particular sales order.';


--
-- Name: COLUMN idl_oe_ord_dtl.ord_dt; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.idl_oe_ord_dtl.ord_dt IS 'The date the order was placed.  May differ for every line.';


--
-- Name: COLUMN idl_oe_ord_dtl.ord_type_cd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.idl_oe_ord_dtl.ord_type_cd IS 'Identifier for the type of order, e.g. PHN - phone, EDI - X.12, FAX, MAIL, WEB, SOA - web service';


--
-- Name: COLUMN idl_oe_ord_dtl.org_cd_cust; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.idl_oe_ord_dtl.org_cd_cust IS 'Identifier for the customer that placed the order.';


--
-- Name: COLUMN idl_oe_ord_dtl.cust_po_cd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.idl_oe_ord_dtl.cust_po_cd IS 'The purchase order number for this line assigned by the customer.';


--
-- Name: COLUMN idl_oe_ord_dtl.term_cd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.idl_oe_ord_dtl.term_cd IS 'Payment terms code.';


--
-- Name: COLUMN idl_oe_ord_dtl.ship_via_cd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.idl_oe_ord_dtl.ship_via_cd IS 'The shipment method, identifies the carrier and priority.';


--
-- Name: COLUMN idl_oe_ord_dtl.fob_cd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.idl_oe_ord_dtl.fob_cd IS 'Free on Board code.  Identifies when the customer takes ownership of this inventory.';


--
-- Name: COLUMN idl_oe_ord_dtl.curr_cd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.idl_oe_ord_dtl.curr_cd IS 'The X.12 currency associated with the price of this line.';


--
-- Name: COLUMN idl_oe_ord_dtl.sales_terr_cd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.idl_oe_ord_dtl.sales_terr_cd IS 'The sales territory that gets credit for this sale.';


--
-- Name: COLUMN idl_oe_ord_dtl.line_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.idl_oe_ord_dtl.line_nbr IS 'The line number on the sales order.';


--
-- Name: COLUMN idl_oe_ord_dtl.item_cd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.idl_oe_ord_dtl.item_cd IS 'The primary product code of the selling institution for this part.';


--
-- Name: COLUMN idl_oe_ord_dtl.item_cd_cust; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.idl_oe_ord_dtl.item_cd_cust IS 'The part number the customer uses to identify this part.';


--
-- Name: COLUMN idl_oe_ord_dtl.qty_ord; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.idl_oe_ord_dtl.qty_ord IS 'The quantity ordered';


--
-- Name: COLUMN idl_oe_ord_dtl.sell_um; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.idl_oe_ord_dtl.sell_um IS 'ANSI X.12 unit of measure associated with the quantity ordered.';


--
-- Name: COLUMN idl_oe_ord_dtl.rqst_dt; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.idl_oe_ord_dtl.rqst_dt IS 'The date the customer requests the item to be shipped.';


--
-- Name: COLUMN idl_oe_ord_dtl.prom_dt; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.idl_oe_ord_dtl.prom_dt IS 'The most recent promise date.';


--
-- Name: COLUMN idl_oe_ord_dtl.ship_from_facility; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.idl_oe_ord_dtl.ship_from_facility IS 'The facility from which this order line should preferably be shipped.';


--
-- Name: idl_oe_ord_dtl_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.idl_oe_ord_dtl_nbr_seq
    START WITH 9901
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.idl_oe_ord_dtl_nbr_seq OWNER TO jjs;

--
-- Name: idl_po_ord_dtl; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.idl_po_ord_dtl (
    idl_po_ord_dtl_nbr integer,
    po_cd character varying(20) NOT NULL,
    curr_cd character varying(3),
    po_dt timestamp without time zone,
    org_cd_vnd character varying(16) NOT NULL,
    po_line_nbr character varying(5),
    item_cd character varying(50) NOT NULL,
    replen_um character varying(3),
    unit_cost numeric(17,6),
    replen_qty bigint,
    replen_curr_est_dt timestamp without time zone,
    delivery_facility character varying(16),
    delivery_sply_pool_cd character varying(20),
    recv_qty bigint,
    open_qty bigint,
    replen_curr_est_dt_txt character varying(16),
    po_dt_txt character varying(16)
);


ALTER TABLE aerodemo.idl_po_ord_dtl OWNER TO jjs;

--
-- Name: TABLE idl_po_ord_dtl; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON TABLE aerodemo.idl_po_ord_dtl IS 'Interface table for purchase orders to vendors, not to be used for purchase orders from customers.';


--
-- Name: COLUMN idl_po_ord_dtl.idl_po_ord_dtl_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.idl_po_ord_dtl.idl_po_ord_dtl_nbr IS 'Surrogate key for internal purposes.';


--
-- Name: COLUMN idl_po_ord_dtl.po_cd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.idl_po_ord_dtl.po_cd IS 'Legacy purchase order code, identifies the purchase order.';


--
-- Name: COLUMN idl_po_ord_dtl.curr_cd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.idl_po_ord_dtl.curr_cd IS 'The ANSI X.12 currency code associated with the unit cost.';


--
-- Name: COLUMN idl_po_ord_dtl.po_dt; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.idl_po_ord_dtl.po_dt IS 'The date the purchase order was created.';


--
-- Name: COLUMN idl_po_ord_dtl.org_cd_vnd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.idl_po_ord_dtl.org_cd_vnd IS 'Identifies the organization from which this is being purchased.';


--
-- Name: COLUMN idl_po_ord_dtl.po_line_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.idl_po_ord_dtl.po_line_nbr IS 'Identifier for the line on the purchase order.';


--
-- Name: COLUMN idl_po_ord_dtl.item_cd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.idl_po_ord_dtl.item_cd IS 'The part identifier.';


--
-- Name: COLUMN idl_po_ord_dtl.replen_um; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.idl_po_ord_dtl.replen_um IS 'ANSI X.12 unit of measure.';


--
-- Name: COLUMN idl_po_ord_dtl.unit_cost; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.idl_po_ord_dtl.unit_cost IS 'Cost per unit in the replenishment unit of measure and currency.';


--
-- Name: COLUMN idl_po_ord_dtl.replen_qty; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.idl_po_ord_dtl.replen_qty IS 'Replenishment quantity in the replenishment unit of measure.';


--
-- Name: COLUMN idl_po_ord_dtl.replen_curr_est_dt; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.idl_po_ord_dtl.replen_curr_est_dt IS 'Current estimated availability date of the schedule.';


--
-- Name: COLUMN idl_po_ord_dtl.delivery_facility; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.idl_po_ord_dtl.delivery_facility IS 'Identifier for  the facility to which the goods are to be delivered.';


--
-- Name: COLUMN idl_po_ord_dtl.delivery_sply_pool_cd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.idl_po_ord_dtl.delivery_sply_pool_cd IS 'Identifier for the supply pool which is to be replenished.';


--
-- Name: idl_po_ord_dtl_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.idl_po_ord_dtl_nbr_seq
    START WITH 33181
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.idl_po_ord_dtl_nbr_seq OWNER TO jjs;

--
-- Name: idl_so_hist_dtl; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.idl_so_hist_dtl (
    sales_order_number character varying(16),
    customer_number character varying(16),
    salesperson_code character varying(16),
    item_cd character varying(50),
    qty_ordered bigint,
    unit_price numeric(17,6),
    avg_cost bigint,
    prod_line character varying(5),
    style character varying(20),
    color character varying(10),
    sz character varying(10),
    order_dt timestamp without time zone,
    start_ship_dt timestamp without time zone
);


ALTER TABLE aerodemo.idl_so_hist_dtl OWNER TO jjs;

--
-- Name: COLUMN idl_so_hist_dtl.item_cd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.idl_so_hist_dtl.item_cd IS 'The item code at the time the order was invoiced.';


--
-- Name: img_image; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.img_image (
    img_image_nbr integer NOT NULL,
    img_image_path character varying(255),
    img_image_file_nm character varying(128),
    image_descr character varying(60)
);


ALTER TABLE aerodemo.img_image OWNER TO jjs;

--
-- Name: img_image_set_dtl; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.img_image_set_dtl (
    img_image_set_hdr_nbr integer NOT NULL,
    img_image_nbr integer NOT NULL,
    img_image_set_dtl_descr character varying(255)
);


ALTER TABLE aerodemo.img_image_set_dtl OWNER TO jjs;

--
-- Name: img_image_set_dtl_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.img_image_set_dtl_nbr_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.img_image_set_dtl_nbr_seq OWNER TO jjs;

--
-- Name: img_image_set_hdr; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.img_image_set_hdr (
    img_image_set_hdr_nbr integer NOT NULL,
    img_image_set_descr character varying(255),
    scan_set_flg character varying(1) NOT NULL,
    CONSTRAINT img_image_set_hdr_scan_set_flg_check CHECK (((scan_set_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text])))
);


ALTER TABLE aerodemo.img_image_set_hdr OWNER TO jjs;

--
-- Name: img_image_set_hdr_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.img_image_set_hdr_nbr_seq
    START WITH 1865
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.img_image_set_hdr_nbr_seq OWNER TO jjs;

--
-- Name: img_scan_batch; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.img_scan_batch (
    img_scan_batch_nbr integer NOT NULL,
    scan_device_type_id character varying(20),
    img_capture_tm date,
    indiv_nbr_capture integer,
    img_image_set_hdr_nbr integer
);


ALTER TABLE aerodemo.img_scan_batch OWNER TO jjs;

--
-- Name: img_scan_batch_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.img_scan_batch_nbr_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.img_scan_batch_nbr_seq OWNER TO jjs;

--
-- Name: indiv_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.indiv_nbr_seq
    START WITH 37699
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.indiv_nbr_seq OWNER TO jjs;

--
-- Name: inv_cd_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.inv_cd_seq
    START WITH 343423
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE aerodemo.inv_cd_seq OWNER TO jjs;

--
-- Name: inv_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.inv_nbr_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.inv_nbr_seq OWNER TO jjs;

--
-- Name: item_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.item_nbr_seq
    START WITH 80000000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE aerodemo.item_nbr_seq OWNER TO jjs;

--
-- Name: item_tmp2; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.item_tmp2 (
    item_cd character varying(50)
);


ALTER TABLE aerodemo.item_tmp2 OWNER TO jjs;

--
-- Name: vq_qte_dtl; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.vq_qte_dtl (
    vq_qte_dtl_nbr integer NOT NULL,
    vq_qte_hdr_nbr integer NOT NULL,
    item_nbr_qte integer,
    item_cd_qte character varying(50) NOT NULL,
    item_cd_vnd character varying(50) NOT NULL,
    qte_um character varying(3) NOT NULL,
    qte_qty numeric(13,5) NOT NULL,
    qte_qty_stk_um numeric(13,5) NOT NULL,
    qte_cost numeric(17,6),
    qte_cost_denom numeric(17,6),
    qte_cost_stk_um numeric(17,6),
    qte_cost_denom_stk_um numeric(17,6),
    org_nbr_mfr_rqst integer,
    rev_lvl character varying(5),
    rqst_dt timestamp without time zone NOT NULL,
    lead_tm_wk_prom smallint,
    prom_dt timestamp without time zone,
    vq_lost_cd character varying(8),
    ut_user_nbr integer NOT NULL,
    last_mod_dt timestamp without time zone NOT NULL
);


ALTER TABLE aerodemo.vq_qte_dtl OWNER TO jjs;

--
-- Name: COLUMN vq_qte_dtl.rev_lvl; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.vq_qte_dtl.rev_lvl IS 'The revision level of the part from the lot master or ic_multiple_cert_rev_lvl.';


--
-- Name: COLUMN vq_qte_dtl.rqst_dt; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.vq_qte_dtl.rqst_dt IS 'The date the customer requests the item to be shipped.';


--
-- Name: COLUMN vq_qte_dtl.prom_dt; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.vq_qte_dtl.prom_dt IS 'The most recent promise date.';


--
-- Name: COLUMN vq_qte_dtl.ut_user_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.vq_qte_dtl.ut_user_nbr IS 'Surrogate primary key for UT_USER';


--
-- Name: vq_qte_hdr; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.vq_qte_hdr (
    vq_qte_hdr_nbr integer NOT NULL,
    vq_qte_cd character varying(20) NOT NULL,
    org_nbr_vnd integer NOT NULL,
    vq_qte_dt timestamp without time zone NOT NULL,
    curr_cd_qte character varying(9) NOT NULL,
    indiv_nm_spoken_to character varying(40),
    indiv_phn_nbr character varying(20),
    indiv_fax_nbr character varying(20),
    indiv_email_addr character varying(40),
    vq_qte_eff_dt timestamp without time zone NOT NULL,
    vq_qte_exp_dt timestamp without time zone NOT NULL,
    vnd_qte_ref_cd character varying(20),
    vq_qte_indiv_nbr integer NOT NULL,
    ut_user_nbr integer NOT NULL,
    last_mod_dt timestamp without time zone NOT NULL,
    transmit_flg character varying(1) DEFAULT 'N'::character varying NOT NULL,
    CONSTRAINT sys_c0016055 CHECK (((transmit_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0018562 CHECK (((transmit_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text])))
);


ALTER TABLE aerodemo.vq_qte_hdr OWNER TO jjs;

--
-- Name: COLUMN vq_qte_hdr.org_nbr_vnd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.vq_qte_hdr.org_nbr_vnd IS 'The organization number of the vendor from whom the inventory was purchased.';


--
-- Name: COLUMN vq_qte_hdr.ut_user_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.vq_qte_hdr.ut_user_nbr IS 'Surrogate primary key for UT_USER';


--
-- Name: vq_qte_vw; Type: VIEW; Schema: aerodemo; Owner: jjs
--

CREATE VIEW aerodemo.vq_qte_vw AS
 SELECT vqh.vq_qte_hdr_nbr,
    vqh.vq_qte_cd,
    vqh.org_nbr_vnd,
    vqh.vq_qte_dt,
    no.org_cd,
    no.org_nm,
    vqh.curr_cd_qte,
    vqh.indiv_nm_spoken_to,
    vqh.indiv_phn_nbr,
    vqh.indiv_fax_nbr,
    vqh.indiv_email_addr,
    vqh.vq_qte_eff_dt,
    vqh.vq_qte_exp_dt,
    vqh.vnd_qte_ref_cd,
    vqh.vq_qte_indiv_nbr,
    vqh.transmit_flg,
    vqd.vq_qte_dtl_nbr,
    vqd.item_nbr_qte,
    vqd.item_cd_qte,
    vqd.item_cd_vnd,
    vqd.qte_um,
    vqd.qte_qty,
    vqd.qte_qty_stk_um,
    vqd.qte_cost,
    vqd.qte_cost_denom,
    vqd.qte_cost_stk_um,
    vqd.qte_cost_denom_stk_um,
    vqd.org_nbr_mfr_rqst,
    vqd.rev_lvl,
    vqd.rqst_dt,
    vqd.lead_tm_wk_prom,
    vqd.prom_dt,
    vqd.vq_lost_cd
   FROM aerodemo.vq_qte_hdr vqh,
    aerodemo.vq_qte_dtl vqd,
    aerodemo.na_org no
  WHERE ((vqh.vq_qte_hdr_nbr = vqd.vq_qte_hdr_nbr) AND (vqh.org_nbr_vnd = no.org_nbr));


ALTER TABLE aerodemo.vq_qte_vw OWNER TO jjs;

--
-- Name: item_vnd_lead_time; Type: VIEW; Schema: aerodemo; Owner: jjs
--

CREATE VIEW aerodemo.item_vnd_lead_time AS
 SELECT vq_qte_vw.item_cd_qte,
    vq_qte_vw.vq_qte_dt,
    vq_qte_vw.vq_qte_eff_dt,
    max(vq_qte_vw.vq_qte_exp_dt) AS max_qte_exp_dt,
    ((max(vq_qte_vw.vq_qte_exp_dt) - vq_qte_vw.vq_qte_eff_dt) / (7)::double precision) AS lead_tm_wks
   FROM aerodemo.vq_qte_vw
  GROUP BY vq_qte_vw.org_nbr_vnd, vq_qte_vw.item_cd_qte, vq_qte_vw.vq_qte_eff_dt, vq_qte_vw.vq_qte_dt;


ALTER TABLE aerodemo.item_vnd_lead_time OWNER TO jjs;

--
-- Name: jhi_authority; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.jhi_authority (
    name character varying(50) NOT NULL
);


ALTER TABLE aerodemo.jhi_authority OWNER TO jjs;

--
-- Name: jhi_persistent_audit_event; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.jhi_persistent_audit_event (
    event_id numeric(38,0) NOT NULL,
    principal character varying(50) NOT NULL,
    event_date timestamp without time zone,
    event_type character varying(255)
);


ALTER TABLE aerodemo.jhi_persistent_audit_event OWNER TO jjs;

--
-- Name: jhi_user; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.jhi_user (
    id numeric(38,0) NOT NULL,
    login character varying(50) NOT NULL,
    password_hash character varying(60) NOT NULL,
    first_name character varying(50),
    last_name character varying(50),
    email character varying(191),
    image_url character varying(256),
    activated smallint NOT NULL,
    lang_key character varying(10),
    activation_key character varying(20),
    reset_key character varying(20),
    created_by character varying(50) NOT NULL,
    created_date timestamp without time zone,
    reset_date timestamp without time zone,
    last_modified_by character varying(50),
    last_modified_date timestamp without time zone
);


ALTER TABLE aerodemo.jhi_user OWNER TO jjs;

--
-- Name: jhi_user_authority; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.jhi_user_authority (
    user_id numeric(38,0) NOT NULL,
    authority_name character varying(50) NOT NULL
);


ALTER TABLE aerodemo.jhi_user_authority OWNER TO jjs;

--
-- Name: jit_trans_batch_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.jit_trans_batch_nbr_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.jit_trans_batch_nbr_seq OWNER TO jjs;

--
-- Name: jit_transaction_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.jit_transaction_nbr_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.jit_transaction_nbr_seq OWNER TO jjs;

--
-- Name: job_log; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.job_log (
    job_log_id numeric(9,0) NOT NULL,
    job_token character varying(64),
    process_name character varying(128),
    thread_name character varying(128),
    module_name character varying(64),
    status_msg character varying(256),
    start_ts timestamp(6) without time zone,
    end_ts timestamp(6) without time zone,
    elapsed_millis numeric(9,0),
    ignore_flg character varying(1) DEFAULT 'N'::character varying NOT NULL,
    classname character varying(255),
    trace_level numeric(2,0),
    abort_stack_trace text,
    msg_lvl numeric(1,0),
    CONSTRAINT job_log_ignore_flg_check CHECK (((ignore_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text])))
);


ALTER TABLE aerodemo.job_log OWNER TO jjs;

--
-- Name: job_log_vw; Type: VIEW; Schema: aerodemo; Owner: jjs
--

CREATE VIEW aerodemo.job_log_vw AS
 SELECT job_log.job_log_id,
    job_log.process_name,
    job_log.thread_name,
    job_log.status_msg,
    job_log.start_ts,
    job_log.end_ts,
    job_log.ignore_flg,
    job_log.module_name,
    job_log.classname,
    (job_log.end_ts - job_log.start_ts) AS elapsed_millis
   FROM aerodemo.job_log;


ALTER TABLE aerodemo.job_log_vw OWNER TO jjs;

--
-- Name: job_msg; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.job_msg (
    job_msg_id numeric(9,0) NOT NULL,
    job_log_id numeric(9,0) NOT NULL,
    job_step_id numeric(9,0),
    log_msg_id character varying(8) NOT NULL,
    log_msg character varying(256),
    log_msg_clob text,
    log_msg_ts timestamp(6) without time zone,
    elapsed_time_milliseconds numeric(9,0),
    log_seq_nbr numeric(18,0) NOT NULL,
    caller_name character varying(100),
    line_nbr numeric(5,0),
    call_stack text,
    log_level numeric(2,0)
);


ALTER TABLE aerodemo.job_msg OWNER TO jjs;

--
-- Name: job_msg_id_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.job_msg_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE aerodemo.job_msg_id_seq OWNER TO jjs;

--
-- Name: job_step; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.job_step (
    job_step_id numeric(9,0) NOT NULL,
    job_log_id numeric(9,0),
    step_name character varying(64),
    classname character varying(256),
    step_info character varying(2000),
    start_ts timestamp(6) without time zone,
    end_ts timestamp(6) without time zone,
    tracefile_name character varying(255),
    stack_trace character varying(4000),
    sid numeric(8,0),
    serial_nbr numeric(8,0),
    instance_name character varying(16)
);


ALTER TABLE aerodemo.job_step OWNER TO jjs;

--
-- Name: job_step_id_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.job_step_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE aerodemo.job_step_id_seq OWNER TO jjs;

--
-- Name: job_step_tracefile; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.job_step_tracefile (
    job_step_id numeric(9,0) NOT NULL,
    tracefile_data text
);


ALTER TABLE aerodemo.job_step_tracefile OWNER TO jjs;

--
-- Name: job_step_tracefile_json; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.job_step_tracefile_json (
    job_step_id numeric(9,0) NOT NULL,
    tracefile_jsoh text
);


ALTER TABLE aerodemo.job_step_tracefile_json OWNER TO jjs;

--
-- Name: job_step_vw; Type: VIEW; Schema: aerodemo; Owner: jjs
--

CREATE VIEW aerodemo.job_step_vw AS
 SELECT job_step.job_step_id,
    job_step.job_log_id,
    job_step.step_name,
    job_step.classname,
    job_step.step_info,
    job_step.start_ts,
    job_step.end_ts,
    (job_step.end_ts - job_step.start_ts) AS elapsed_millis
   FROM aerodemo.job_step;


ALTER TABLE aerodemo.job_step_vw OWNER TO jjs;

--
-- Name: lot_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.lot_nbr_seq
    START WITH 1020307
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.lot_nbr_seq OWNER TO jjs;

--
-- Name: missing_items; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.missing_items (
    item_nbr integer NOT NULL,
    item_cd character varying(50) NOT NULL
);


ALTER TABLE aerodemo.missing_items OWNER TO jjs;

--
-- Name: COLUMN missing_items.item_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.missing_items.item_nbr IS 'Product identifier, reference to item master (IC_ITEM_MAST.ITEM_NBR)';


--
-- Name: COLUMN missing_items.item_cd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.missing_items.item_cd IS 'Product Number - SKU';


--
-- Name: na_addr_tax_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.na_addr_tax_nbr_seq
    START WITH 15960
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.na_addr_tax_nbr_seq OWNER TO jjs;

--
-- Name: na_category_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.na_category_nbr_seq
    START WITH 112
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.na_category_nbr_seq OWNER TO jjs;

--
-- Name: na_indiv_email_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.na_indiv_email_nbr_seq
    START WITH 1770
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.na_indiv_email_nbr_seq OWNER TO jjs;

--
-- Name: na_indiv_phn_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.na_indiv_phn_nbr_seq
    START WITH 19368
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.na_indiv_phn_nbr_seq OWNER TO jjs;

--
-- Name: na_org_addr; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.na_org_addr (
    addr_nbr integer NOT NULL,
    org_nbr integer NOT NULL,
    addr_type_id character varying(4) NOT NULL,
    addr_1 character varying(30) NOT NULL,
    addr_2 character varying(30),
    addr_3 character varying(30),
    city character varying(25),
    state_cd character varying(5),
    cntry_cd character varying(3),
    addr_cd character varying(8) NOT NULL,
    addr_descr character varying(60),
    role_nm character varying(30),
    pick_prty smallint,
    pick_prty_past_due_mult smallint,
    gl_tax_grp_nbr integer,
    ut_user_nbr integer NOT NULL,
    last_mod_dt timestamp without time zone NOT NULL,
    postal_cd character varying(10),
    addr_active_id character varying(1) NOT NULL,
    aps_src_rule_set_nbr integer,
    calendar character varying(6) NOT NULL,
    phn_nbr_dflt character varying(20),
    fax_nbr_dflt character varying(20),
    indiv_nbr_contact_dflt integer
);


ALTER TABLE aerodemo.na_org_addr OWNER TO jjs;

--
-- Name: COLUMN na_org_addr.org_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.na_org_addr.org_nbr IS 'Surrogate primary key for ORG_NBR';


--
-- Name: COLUMN na_org_addr.ut_user_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.na_org_addr.ut_user_nbr IS 'Surrogate primary key for UT_USER';


--
-- Name: COLUMN na_org_addr.calendar; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.na_org_addr.calendar IS 'The name of the calendar to be used for this entity.';


--
-- Name: COLUMN na_org_addr.phn_nbr_dflt; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.na_org_addr.phn_nbr_dflt IS 'Default telephone number for this entity.';


--
-- Name: na_org_attr_mast_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.na_org_attr_mast_nbr_seq
    START WITH 205
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.na_org_attr_mast_nbr_seq OWNER TO jjs;

--
-- Name: na_org_dept_indiv_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.na_org_dept_indiv_nbr_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.na_org_dept_indiv_nbr_seq OWNER TO jjs;

--
-- Name: na_org_dept_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.na_org_dept_nbr_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.na_org_dept_nbr_seq OWNER TO jjs;

--
-- Name: na_org_indiv; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.na_org_indiv (
    org_nbr integer NOT NULL,
    indiv_nbr integer NOT NULL,
    ut_user_nbr integer NOT NULL,
    last_mod_dt timestamp without time zone NOT NULL
);


ALTER TABLE aerodemo.na_org_indiv OWNER TO jjs;

--
-- Name: COLUMN na_org_indiv.org_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.na_org_indiv.org_nbr IS 'Surrogate primary key for ORG_NBR';


--
-- Name: COLUMN na_org_indiv.indiv_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.na_org_indiv.indiv_nbr IS 'Surrogate primary key for INDIV_NBR';


--
-- Name: COLUMN na_org_indiv.ut_user_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.na_org_indiv.ut_user_nbr IS 'Surrogate primary key for UT_USER';


--
-- Name: na_org_phn_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.na_org_phn_nbr_seq
    START WITH 9832
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.na_org_phn_nbr_seq OWNER TO jjs;

--
-- Name: note_nbr_ref_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.note_nbr_ref_seq
    START WITH 132861
    INCREMENT BY 1
    MINVALUE 20594
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.note_nbr_ref_seq OWNER TO jjs;

--
-- Name: note_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.note_nbr_seq
    START WITH 35270293
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.note_nbr_seq OWNER TO jjs;

--
-- Name: oe_alloc_onhand_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.oe_alloc_onhand_nbr_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.oe_alloc_onhand_nbr_seq OWNER TO jjs;

--
-- Name: oe_alloc_replen_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.oe_alloc_replen_nbr_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.oe_alloc_replen_nbr_seq OWNER TO jjs;

--
-- Name: oe_contract_item; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.oe_contract_item (
    org_nbr_cust integer NOT NULL,
    contract_cd character varying(8) NOT NULL,
    item_cd_cust character varying(50) NOT NULL,
    item_nbr integer NOT NULL,
    item_nbr_supersede integer,
    eff_dt_beg timestamp without time zone,
    eff_dt_end timestamp without time zone,
    ut_user_nbr integer NOT NULL,
    last_mod_dt timestamp without time zone NOT NULL,
    tot_contract_qty integer,
    note_nbr_ref integer NOT NULL,
    use_contract_item_cert character varying(1) NOT NULL,
    supersession_stat_id character varying(1) NOT NULL,
    supersession_est_eff_dt timestamp without time zone,
    CONSTRAINT oci_check_supersession_stat_id CHECK (((supersession_stat_id)::text = ANY (ARRAY[('S'::character varying)::text, ('N'::character varying)::text, ('R'::character varying)::text]))),
    CONSTRAINT sys_c0015432 CHECK (((use_contract_item_cert)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text])))
);


ALTER TABLE aerodemo.oe_contract_item OWNER TO jjs;

--
-- Name: COLUMN oe_contract_item.org_nbr_cust; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.oe_contract_item.org_nbr_cust IS 'Reference to the customer (OE_CUST_MAST.ORG_NBR_CUST)';


--
-- Name: COLUMN oe_contract_item.contract_cd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.oe_contract_item.contract_cd IS 'The contract code, from the order detail line under which the goods were purchased.';


--
-- Name: COLUMN oe_contract_item.item_cd_cust; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.oe_contract_item.item_cd_cust IS 'The part number the customer uses to identify this part.';


--
-- Name: COLUMN oe_contract_item.item_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.oe_contract_item.item_nbr IS 'Product identifier, reference to item master (IC_ITEM_MAST.ITEM_NBR)';


--
-- Name: COLUMN oe_contract_item.ut_user_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.oe_contract_item.ut_user_nbr IS 'Surrogate primary key for UT_USER';


--
-- Name: oe_contract_item_log; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.oe_contract_item_log (
    org_nbr_cust integer NOT NULL,
    contract_cd character varying(8) NOT NULL,
    item_cd_cust character varying(50) NOT NULL,
    item_nbr integer NOT NULL,
    item_nbr_supersede integer,
    eff_dt_beg timestamp without time zone,
    eff_dt_end timestamp without time zone,
    tot_contract_qty integer,
    ut_user_nbr_mod integer NOT NULL,
    mod_dt timestamp without time zone NOT NULL
);


ALTER TABLE aerodemo.oe_contract_item_log OWNER TO jjs;

--
-- Name: COLUMN oe_contract_item_log.org_nbr_cust; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.oe_contract_item_log.org_nbr_cust IS 'Reference to the customer (OE_CUST_MAST.ORG_NBR_CUST)';


--
-- Name: COLUMN oe_contract_item_log.contract_cd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.oe_contract_item_log.contract_cd IS 'The contract code, from the order detail line under which the goods were purchased.';


--
-- Name: COLUMN oe_contract_item_log.item_cd_cust; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.oe_contract_item_log.item_cd_cust IS 'The part number the customer uses to identify this part.';


--
-- Name: COLUMN oe_contract_item_log.item_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.oe_contract_item_log.item_nbr IS 'Product identifier, reference to item master (IC_ITEM_MAST.ITEM_NBR)';


--
-- Name: oe_contract_price_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.oe_contract_price_nbr_seq
    START WITH 167703
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.oe_contract_price_nbr_seq OWNER TO jjs;

--
-- Name: oe_cust_mast_cert; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.oe_cust_mast_cert (
    org_nbr_cust integer NOT NULL,
    cert_cd character varying(8) NOT NULL,
    ut_user_nbr integer NOT NULL,
    last_mod_dt timestamp without time zone NOT NULL
);


ALTER TABLE aerodemo.oe_cust_mast_cert OWNER TO jjs;

--
-- Name: COLUMN oe_cust_mast_cert.org_nbr_cust; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.oe_cust_mast_cert.org_nbr_cust IS 'Reference to the customer (OE_CUST_MAST.ORG_NBR_CUST)';


--
-- Name: COLUMN oe_cust_mast_cert.ut_user_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.oe_cust_mast_cert.ut_user_nbr IS 'Surrogate primary key for UT_USER';


--
-- Name: oe_cust_mast_id_vw; Type: VIEW; Schema: aerodemo; Owner: jjs
--

CREATE VIEW aerodemo.oe_cust_mast_id_vw AS
 SELECT no.org_nbr,
    no.org_cd,
    no.org_nm,
    ocm.fcst_grp
   FROM aerodemo.oe_cust_mast ocm,
    aerodemo.na_org no
  WHERE (no.org_nbr = ocm.org_nbr_cust);


ALTER TABLE aerodemo.oe_cust_mast_id_vw OWNER TO jjs;

--
-- Name: oe_cust_mfr; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.oe_cust_mfr (
    item_nbr integer NOT NULL,
    org_nbr_cust integer NOT NULL,
    org_nbr_mfr integer NOT NULL,
    eff_dt_beg timestamp without time zone,
    eff_dt_end timestamp without time zone,
    mfr_restrict_id character varying(1) NOT NULL,
    CONSTRAINT sys_c0015496 CHECK (((mfr_restrict_id)::text = ANY (ARRAY[('I'::character varying)::text, ('E'::character varying)::text]))),
    CONSTRAINT sys_c0016374 CHECK (((mfr_restrict_id)::text = ANY (ARRAY[('I'::character varying)::text, ('E'::character varying)::text])))
);


ALTER TABLE aerodemo.oe_cust_mfr OWNER TO jjs;

--
-- Name: COLUMN oe_cust_mfr.item_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.oe_cust_mfr.item_nbr IS 'Product identifier, reference to item master (IC_ITEM_MAST.ITEM_NBR)';


--
-- Name: COLUMN oe_cust_mfr.org_nbr_cust; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.oe_cust_mfr.org_nbr_cust IS 'Reference to the customer (OE_CUST_MAST.ORG_NBR_CUST)';


--
-- Name: COLUMN oe_cust_mfr.org_nbr_mfr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.oe_cust_mfr.org_nbr_mfr IS 'The organization number of the manufacturer, copied from the lot master (ic_lot_mast).';


--
-- Name: oe_cust_mfr_vw; Type: VIEW; Schema: aerodemo; Owner: jjs
--

CREATE VIEW aerodemo.oe_cust_mfr_vw AS
 SELECT ocm.item_nbr,
    iim.item_cd,
    ocm.org_nbr_cust,
    cust.org_cd AS org_cd_cust,
    ocm.org_nbr_mfr,
    mfr.org_cd AS org_cd_mfr,
    ocm.eff_dt_beg,
    ocm.eff_dt_end,
    ocm.mfr_restrict_id
   FROM aerodemo.oe_cust_mfr ocm,
    aerodemo.ic_item_mast iim,
    aerodemo.na_org mfr,
    aerodemo.na_org cust
  WHERE ((ocm.item_nbr = iim.item_nbr) AND (ocm.org_nbr_cust = cust.org_nbr) AND (ocm.org_nbr_mfr = mfr.org_nbr));


ALTER TABLE aerodemo.oe_cust_mfr_vw OWNER TO jjs;

--
-- Name: oe_cust_mfr_vw2; Type: VIEW; Schema: aerodemo; Owner: jjs
--

CREATE VIEW aerodemo.oe_cust_mfr_vw2 AS
 SELECT ocm.item_nbr,
    grp.plan_grp_nbr,
    iim.item_cd,
    ocm.org_nbr_cust,
    ocm.org_nbr_mfr,
    ocm.eff_dt_beg,
    ocm.eff_dt_end,
    ocm.mfr_restrict_id
   FROM aerodemo.oe_cust_mfr ocm,
    aerodemo.ic_item_mast iim,
    aerodemo.aps_plan_grp grp
  WHERE ((ocm.item_nbr = iim.item_nbr) AND (ocm.item_nbr = grp.item_nbr));


ALTER TABLE aerodemo.oe_cust_mfr_vw2 OWNER TO jjs;

--
-- Name: oe_hold_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.oe_hold_nbr_seq
    START WITH 213642
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.oe_hold_nbr_seq OWNER TO jjs;

--
-- Name: oe_hold_rel_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.oe_hold_rel_nbr_seq
    START WITH 43512
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.oe_hold_rel_nbr_seq OWNER TO jjs;

--
-- Name: oe_ord_dtl_hist_fcst_grp; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.oe_ord_dtl_hist_fcst_grp (
    oe_ord_hdr_nbr integer NOT NULL,
    ord_dt timestamp without time zone NOT NULL,
    ord_stat_id character varying(1) NOT NULL,
    org_nbr_cust integer NOT NULL,
    org_cd_cust character varying(15) NOT NULL,
    curr_cd character varying(3) NOT NULL,
    ord_type_cd character varying(8) NOT NULL,
    ord_cd character varying(20) NOT NULL,
    item_nbr_rqst integer NOT NULL,
    item_nbr_ord integer NOT NULL,
    qty_ord numeric(15,5) NOT NULL,
    qty_ord_stk_um numeric(15,5) NOT NULL,
    sell_um character varying(3) NOT NULL,
    rqst_dt timestamp without time zone NOT NULL,
    unit_price_sell_um numeric(17,6),
    unit_price_denom_sell_um numeric(17,6),
    unit_price_stk_um numeric(17,6),
    unit_price_denom_stk_um numeric(17,6),
    item_cd_cust character varying(50),
    aps_src_rule_set_nbr integer NOT NULL,
    org_nbr_mfr_rqst integer,
    lot_not_expire_before_dt timestamp without time zone,
    lot_manufacture_after_dt timestamp without time zone,
    cntry_cd_origin character varying(3),
    rev_lvl character varying(5),
    qty_ship numeric(15,5),
    qty_ship_stk_um numeric(15,5),
    qty_alloc numeric(13,5),
    qty_alloc_stk_um numeric(13,5),
    oe_ord_dtl_nbr integer NOT NULL,
    fcst_grp character varying(8) NOT NULL
);


ALTER TABLE aerodemo.oe_ord_dtl_hist_fcst_grp OWNER TO jjs;

--
-- Name: oe_item_hist_fcst_grp; Type: VIEW; Schema: aerodemo; Owner: jjs
--

CREATE VIEW aerodemo.oe_item_hist_fcst_grp AS
 SELECT h.item_nbr_rqst,
    iim.item_cd,
    date_trunc('month'::text, h.ord_dt) AS ord_dt_mm,
    sum(h.qty_ord) AS qty_ord_sum,
    h.fcst_grp
   FROM aerodemo.oe_ord_dtl_hist_fcst_grp h,
    aerodemo.ic_item_mast iim
  WHERE (h.item_nbr_rqst = iim.item_nbr)
  GROUP BY h.item_nbr_rqst, iim.item_cd, (date_trunc('month'::text, h.ord_dt)), h.fcst_grp;


ALTER TABLE aerodemo.oe_item_hist_fcst_grp OWNER TO jjs;

--
-- Name: oe_ord_dtl_cert; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.oe_ord_dtl_cert (
    oe_ord_dtl_nbr integer NOT NULL,
    cert_cd character varying(8) NOT NULL,
    ut_user_nbr integer NOT NULL,
    last_mod_dt timestamp without time zone NOT NULL
);


ALTER TABLE aerodemo.oe_ord_dtl_cert OWNER TO jjs;

--
-- Name: COLUMN oe_ord_dtl_cert.oe_ord_dtl_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.oe_ord_dtl_cert.oe_ord_dtl_nbr IS 'A foreign key back to the order detail.';


--
-- Name: COLUMN oe_ord_dtl_cert.ut_user_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.oe_ord_dtl_cert.ut_user_nbr IS 'Surrogate primary key for UT_USER';


--
-- Name: oe_ord_dtl_hist; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.oe_ord_dtl_hist (
    oe_ord_hdr_nbr integer NOT NULL,
    ord_dt timestamp without time zone NOT NULL,
    ord_stat_id character varying(1) NOT NULL,
    org_nbr_cust integer NOT NULL,
    org_cd_cust character varying(15) NOT NULL,
    cust_po_cd character varying(30),
    cust_po_dt timestamp without time zone,
    fob_cd character varying(8),
    curr_cd character varying(3) NOT NULL,
    trd_flg character varying(1) NOT NULL,
    ord_type_cd character varying(8) NOT NULL,
    ord_cd character varying(20) NOT NULL,
    sales_terr_cd character varying(8) NOT NULL,
    transmit_flg character varying(1) NOT NULL,
    line_nbr smallint NOT NULL,
    cust_line_cd character varying(5),
    item_nbr_rqst integer NOT NULL,
    item_nbr_ord integer NOT NULL,
    qty_ord numeric(15,5) NOT NULL,
    qty_ord_stk_um numeric(15,5) NOT NULL,
    sell_um character varying(3) NOT NULL,
    rqst_dt timestamp without time zone NOT NULL,
    ship_to_addr_nbr integer NOT NULL,
    prom_dt_orig timestamp without time zone NOT NULL,
    prom_dt_curr timestamp without time zone NOT NULL,
    unit_price_sell_um numeric(17,6),
    unit_price_denom_sell_um numeric(17,6),
    unit_price_stk_um numeric(17,6),
    unit_price_denom_stk_um numeric(17,6),
    item_cd_cust character varying(50),
    aps_src_rule_set_nbr integer NOT NULL,
    org_nbr_mfr_rqst integer,
    lot_not_expire_before_dt timestamp without time zone,
    lot_manufacture_after_dt timestamp without time zone,
    cntry_cd_origin character varying(3),
    rev_lvl character varying(5),
    ship_via_cd character varying(8) NOT NULL,
    contract_cd character varying(8),
    cust_bin_cd character varying(40),
    qty_ship numeric(15,5),
    qty_ship_stk_um numeric(15,5),
    qty_alloc numeric(13,5),
    qty_alloc_stk_um numeric(13,5),
    part_mismatch_reason_cd character varying(8),
    cust_ref character varying(40),
    ship_from_facility character varying(16) NOT NULL,
    ship_cmplt_flg character varying(1) NOT NULL,
    hot_flg character varying(1) NOT NULL,
    ship_line_pct smallint,
    cancel_cd character varying(8),
    cancel_dt timestamp without time zone,
    oe_ord_dtl_nbr integer NOT NULL
);


ALTER TABLE aerodemo.oe_ord_dtl_hist OWNER TO jjs;

--
-- Name: oe_ord_dtl_hist_fcst_grp_vw; Type: VIEW; Schema: aerodemo; Owner: jjs
--

CREATE VIEW aerodemo.oe_ord_dtl_hist_fcst_grp_vw AS
 SELECT ooh.oe_ord_hdr_nbr,
    ooh.ord_dt,
    ooh.ord_stat_id,
    ooh.org_nbr_cust,
    no.org_cd AS org_cd_cust,
    iim.item_cd,
    ocm.fcst_grp,
    ooh.curr_cd,
    ooh.ord_type_cd,
    ooh.ord_cd,
    ood.item_nbr_ord,
    ood.qty_ord_stk_um,
    ood.rqst_dt,
    to_char(ood.rqst_dt, 'YYYY-MM'::text) AS rqst_mnth,
    ood.prom_dt_orig,
    ood.unit_price_sell_um,
    ood.unit_price_stk_um,
    ood.unit_price_denom_sell_um,
    ood.unit_price_denom_stk_um,
    ood.item_cd_cust,
    ood.sell_um,
    ood.aps_src_rule_set_nbr,
    ood.org_nbr_mfr_rqst,
    ood.lot_not_expire_before_dt,
    ood.lot_manufacture_after_dt,
    ood.cntry_cd_origin,
    ood.rev_lvl,
    ood.qty_ship,
    ood.item_nbr_rqst,
    ood.qty_ord
   FROM aerodemo.oe_ord_dtl ood,
    aerodemo.oe_ord_hdr ooh,
    aerodemo.na_org no,
    aerodemo.oe_cust_mast ocm,
    aerodemo.ic_item_mast iim
  WHERE ((ood.oe_ord_hdr_nbr = ooh.oe_ord_hdr_nbr) AND (no.org_nbr = ooh.org_nbr_cust) AND (no.org_nbr = ooh.org_nbr_cust) AND (iim.item_nbr = ood.item_nbr_ord));


ALTER TABLE aerodemo.oe_ord_dtl_hist_fcst_grp_vw OWNER TO jjs;

--
-- Name: oe_ord_dtl_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.oe_ord_dtl_nbr_seq
    START WITH 1912276
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.oe_ord_dtl_nbr_seq OWNER TO jjs;

--
-- Name: oe_ord_hdr_dtl_vw; Type: VIEW; Schema: aerodemo; Owner: jjs
--

CREATE VIEW aerodemo.oe_ord_hdr_dtl_vw AS
 SELECT ooh.oe_ord_hdr_nbr,
    ooh.ord_dt,
    ooh.ord_stat_id,
    ooh.org_nbr_cust,
    ooh.bill_to_addr_nbr,
    ooh.ship_to_addr_nbr_dflt,
    ooh.cust_po_cd,
    ooh.cust_po_dt,
    ooh.rqst_dt_dflt,
    ooh.cancel_dt AS cancel_dt_hdr,
    ooh.term_cd,
    ooh.ship_via_cd_dflt,
    ooh.fob_cd,
    ooh.curr_cd,
    ooh.ut_user_nbr_cancel,
    ooh.cancel_cd,
    ooh.ord_prty,
    ooh.sell_indiv_nbr,
    ooh.trd_flg,
    ooh.ut_user_nbr AS ut_user_nbr_hdr,
    ooh.last_mod_dt AS last_mod_dt_hdr,
    ooh.ship_pct_line,
    ooh.ship_pct_dollar,
    ooh.next_line_nbr,
    ooh.org_nm_cust,
    ooh.ord_type_cd,
    ooh.ord_cd,
    ooh.buyer_email_addr,
    ooh.indiv_nm_buyer,
    ooh.buyer_phn_nbr,
    ooh.sales_terr_cd,
    ooh.buyer_fax_nbr,
    ooh.transmit_flg,
    ooh.wh_ship_prty_nbr_dflt,
    ooh.payment_method_cd_dflt,
    ood.line_nbr,
    ood.item_nbr_rqst,
    ood.qty_ord,
    ood.sell_um,
    ood.rqst_dt,
    ood.ship_to_addr_nbr,
    ood.prom_dt_orig,
    ood.tie_cd,
    ood.line_stat_id,
    ood.item_cd_cust,
    ood.pkg_qty,
    ood.pick_prty_cust,
    ood.pick_prty_rqst,
    ood.pick_prty_past_due_mult,
    ood.ut_user_nbr AS ut_user_nbr_dtl,
    ood.last_mod_dt AS last_mod_dt_dtl,
    ood.ship_via_cd,
    ood.cust_bin_cd,
    ood.cust_line_cd,
    ood.org_nbr_mfr_rqst,
    ood.contract_cd,
    ood.qty_ship,
    ood.item_nbr_ord,
    ood.aps_src_rule_set_nbr,
    ood.cancel_cd AS cancel_cd_dtl,
    ood.cancel_dt AS line_cancel_dt,
    ood.ut_user_nbr_cancel AS ut_user_cancel_dtl,
    ood.lot_not_expire_before_dt,
    ood.lot_manufacture_after_dt,
    ood.cntry_cd_origin,
    ood.qty_ord_stk_um,
    ood.rev_lvl,
    ood.unit_price_stk_um,
    ood.unit_price_denom_stk_um,
    ood.qty_ship_stk_um,
    ood.part_mismatch_reason_cd,
    ood.unit_price_sell_um,
    ood.unit_price_denom_sell_um,
    ood.cust_ref,
    ood.qty_alloc,
    ood.qty_alloc_stk_um,
    ood.prom_dt_curr,
    ood.ship_from_facility,
    ood.ship_cmplt_flg,
    ood.hot_flg,
    ood.ship_line_pct,
    ood.oe_close_reason_cd,
    ood.close_tm,
    ood.ut_user_nbr_close,
    ood.auto_close_line_pct,
    ood.max_shipments_per_line,
    ood.wh_ship_prty_nbr,
    ood.payment_method_cd
   FROM aerodemo.oe_ord_hdr ooh,
    aerodemo.oe_ord_dtl ood
  WHERE (ooh.oe_ord_hdr_nbr = ood.oe_ord_hdr_nbr);


ALTER TABLE aerodemo.oe_ord_hdr_dtl_vw OWNER TO jjs;

--
-- Name: oe_ord_hdr_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.oe_ord_hdr_nbr_seq
    START WITH 638564
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.oe_ord_hdr_nbr_seq OWNER TO jjs;

--
-- Name: oe_pick_dtl_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.oe_pick_dtl_nbr_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.oe_pick_dtl_nbr_seq OWNER TO jjs;

--
-- Name: oe_pick_hdr_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.oe_pick_hdr_nbr_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.oe_pick_hdr_nbr_seq OWNER TO jjs;

--
-- Name: oe_pick_run_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.oe_pick_run_nbr_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.oe_pick_run_nbr_seq OWNER TO jjs;

--
-- Name: ord_cd_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.ord_cd_seq
    START WITH 292423
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.ord_cd_seq OWNER TO jjs;

--
-- Name: org_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.org_nbr_seq
    START WITH 32997
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.org_nbr_seq OWNER TO jjs;

--
-- Name: plan_grp_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.plan_grp_nbr_seq
    START WITH 348381
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.plan_grp_nbr_seq OWNER TO jjs;

--
-- Name: plan_po; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.plan_po (
    plan_po_nbr integer NOT NULL,
    avail_type_cd character varying(1) NOT NULL,
    item_nbr integer NOT NULL,
    whse_id character varying(8) NOT NULL,
    whse_area character varying(18) NOT NULL,
    item_cd character varying(50) NOT NULL,
    mfr_cd character varying(8) NOT NULL,
    vndr_cd character varying(8) NOT NULL,
    unit_cost numeric(17,6),
    unit_cost_curr_cd character varying(3),
    unit_cost_denom numeric(18,6),
    unit_cost_curr_cd_denom character varying(3),
    avail_dt timestamp without time zone NOT NULL,
    gross_avail_qty bigint NOT NULL,
    ic_sply_tree_nbr integer NOT NULL,
    po_line_dtl_nbr integer
);


ALTER TABLE aerodemo.plan_po OWNER TO jjs;

--
-- Name: COLUMN plan_po.item_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.plan_po.item_nbr IS 'Product identifier, reference to item master (IC_ITEM_MAST.ITEM_NBR)';


--
-- Name: COLUMN plan_po.item_cd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.plan_po.item_cd IS 'Product Number - SKU';


--
-- Name: COLUMN plan_po.unit_cost; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.plan_po.unit_cost IS 'Cost per unit in the replenishment unit of measure and currency.';


--
-- Name: po_cd_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.po_cd_seq
    START WITH 95622
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.po_cd_seq OWNER TO jjs;

--
-- Name: po_line_multiple_cert; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.po_line_multiple_cert (
    po_line_hdr_nbr integer NOT NULL,
    item_nbr integer NOT NULL,
    ut_user_nbr integer NOT NULL,
    last_mod_dt timestamp without time zone NOT NULL
);


ALTER TABLE aerodemo.po_line_multiple_cert OWNER TO jjs;

--
-- Name: COLUMN po_line_multiple_cert.item_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.po_line_multiple_cert.item_nbr IS 'Product identifier, reference to item master (IC_ITEM_MAST.ITEM_NBR)';


--
-- Name: COLUMN po_line_multiple_cert.ut_user_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.po_line_multiple_cert.ut_user_nbr IS 'Surrogate primary key for UT_USER';


--
-- Name: po_line_cert; Type: VIEW; Schema: aerodemo; Owner: jjs
--

CREATE VIEW aerodemo.po_line_cert AS
 SELECT plmc.po_line_hdr_nbr,
    plmc.item_nbr
   FROM aerodemo.po_line_multiple_cert plmc,
    aerodemo.po_line_hdr plh
  WHERE ((plmc.po_line_hdr_nbr = plh.po_line_hdr_nbr) AND ((plh.line_stat_id)::text = 'O'::text));


ALTER TABLE aerodemo.po_line_cert OWNER TO jjs;

--
-- Name: COLUMN po_line_cert.item_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.po_line_cert.item_nbr IS 'Product identifier, reference to item master (IC_ITEM_MAST.ITEM_NBR)';


--
-- Name: po_line_dtl_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.po_line_dtl_seq
    START WITH 386906
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.po_line_dtl_seq OWNER TO jjs;

--
-- Name: po_line_hdr_cert; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.po_line_hdr_cert (
    po_line_hdr_nbr integer NOT NULL,
    cert_cd character varying(8) NOT NULL,
    ut_user_nbr integer NOT NULL,
    last_mod_dt timestamp without time zone NOT NULL
);


ALTER TABLE aerodemo.po_line_hdr_cert OWNER TO jjs;

--
-- Name: COLUMN po_line_hdr_cert.ut_user_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.po_line_hdr_cert.ut_user_nbr IS 'Surrogate primary key for UT_USER';


--
-- Name: po_line_hdr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.po_line_hdr_seq
    START WITH 352150
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.po_line_hdr_seq OWNER TO jjs;

--
-- Name: po_mfr_mast; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.po_mfr_mast (
    org_nbr_mfr integer NOT NULL,
    stat_id character varying(1) NOT NULL,
    intro_dt timestamp without time zone NOT NULL,
    ut_user_nbr integer NOT NULL,
    last_mod_dt timestamp without time zone NOT NULL,
    mail_to_addr_nbr_dflt integer,
    bill_to_addr_nbr_dflt integer,
    mfr_cage_cd character varying(10)
);


ALTER TABLE aerodemo.po_mfr_mast OWNER TO jjs;

--
-- Name: COLUMN po_mfr_mast.org_nbr_mfr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.po_mfr_mast.org_nbr_mfr IS 'The organization number of the manufacturer, copied from the lot master (ic_lot_mast).';


--
-- Name: COLUMN po_mfr_mast.intro_dt; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.po_mfr_mast.intro_dt IS 'Introduction date.';


--
-- Name: COLUMN po_mfr_mast.ut_user_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.po_mfr_mast.ut_user_nbr IS 'Surrogate primary key for UT_USER';


--
-- Name: COLUMN po_mfr_mast.bill_to_addr_nbr_dflt; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.po_mfr_mast.bill_to_addr_nbr_dflt IS 'Identifies the default bill to address for the customer.';


--
-- Name: po_mfr_mast_vw; Type: VIEW; Schema: aerodemo; Owner: jjs
--

CREATE VIEW aerodemo.po_mfr_mast_vw AS
 SELECT pmm.org_nbr_mfr,
    no.org_cd,
    no.org_nm,
    pmm.stat_id,
    pmm.intro_dt,
    pmm.mail_to_addr_nbr_dflt,
    pmm.bill_to_addr_nbr_dflt,
    pmm.mfr_cage_cd
   FROM aerodemo.po_mfr_mast pmm,
    aerodemo.na_org no
  WHERE (pmm.org_nbr_mfr = no.org_nbr);


ALTER TABLE aerodemo.po_mfr_mast_vw OWNER TO jjs;

--
-- Name: po_ord_hdr_auth_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.po_ord_hdr_auth_nbr_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.po_ord_hdr_auth_nbr_seq OWNER TO jjs;

--
-- Name: po_ord_hdr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.po_ord_hdr_seq
    START WITH 154255
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.po_ord_hdr_seq OWNER TO jjs;

--
-- Name: po_requisition; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.po_requisition (
    item_nbr integer NOT NULL,
    need_by_dt timestamp without time zone NOT NULL,
    need_qty numeric(17,5) NOT NULL,
    facility character varying(16) NOT NULL
);


ALTER TABLE aerodemo.po_requisition OWNER TO jjs;

--
-- Name: po_resched; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.po_resched (
    po_line_dtl_nbr integer,
    resched_dt timestamp without time zone,
    resched_qty numeric(13,5),
    org_nbr_vnd integer,
    prd_dt timestamp without time zone
);


ALTER TABLE aerodemo.po_resched OWNER TO jjs;

--
-- Name: COLUMN po_resched.org_nbr_vnd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.po_resched.org_nbr_vnd IS 'The organization number of the vendor from whom the inventory was purchased.';


--
-- Name: po_resched_bak; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.po_resched_bak (
    po_line_dtl_nbr integer,
    resched_dt timestamp without time zone,
    resched_qty numeric(13,5),
    org_nbr_vnd integer,
    prd_dt timestamp without time zone
);


ALTER TABLE aerodemo.po_resched_bak OWNER TO jjs;

--
-- Name: po_std_note_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.po_std_note_nbr_seq
    START WITH 21
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.po_std_note_nbr_seq OWNER TO jjs;

--
-- Name: po_unplanned_rcpt; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.po_unplanned_rcpt (
    po_unplanned_rcpt_nbr integer NOT NULL,
    item_nbr integer NOT NULL,
    rcpt_dt timestamp without time zone NOT NULL,
    org_nbr_vnd integer,
    qty_recv numeric(15,5) NOT NULL,
    lot_um character varying(3),
    mfr_lot_cd character varying(20),
    mfr_dt timestamp without time zone,
    org_nbr_mfr integer,
    rev_lvl character varying(5),
    po_ord_hdr_nbr integer,
    po_line_hdr_nbr integer,
    ut_user_nbr integer NOT NULL,
    last_mod_dt timestamp without time zone NOT NULL,
    rcpt_stat_id character varying(1) NOT NULL,
    processed_dt timestamp without time zone,
    bin_nbr integer,
    aps_sply_sub_pool_nbr integer NOT NULL,
    facility character varying(16) NOT NULL,
    qty_recv_stk_um numeric(13,5) NOT NULL,
    expire_dt timestamp without time zone,
    lot_nbr integer,
    cntry_cd_origin character varying(3),
    item_cd_vnd character varying(50),
    unit_cost_denom_replen_um numeric(17,6),
    unit_cost_replen_um numeric(17,6),
    unit_cost_stk_um numeric(17,6),
    unit_cost_denom_stk_um numeric(17,6),
    rcpt_comm character varying(200),
    CONSTRAINT sys_c0015722 CHECK (((rcpt_stat_id)::text = ANY (ARRAY[('O'::character varying)::text, ('C'::character varying)::text])))
);


ALTER TABLE aerodemo.po_unplanned_rcpt OWNER TO jjs;

--
-- Name: COLUMN po_unplanned_rcpt.item_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.po_unplanned_rcpt.item_nbr IS 'Product identifier, reference to item master (IC_ITEM_MAST.ITEM_NBR)';


--
-- Name: COLUMN po_unplanned_rcpt.rcpt_dt; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.po_unplanned_rcpt.rcpt_dt IS 'The date this inventory was received.';


--
-- Name: COLUMN po_unplanned_rcpt.org_nbr_vnd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.po_unplanned_rcpt.org_nbr_vnd IS 'The organization number of the vendor from whom the inventory was purchased.';


--
-- Name: COLUMN po_unplanned_rcpt.mfr_lot_cd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.po_unplanned_rcpt.mfr_lot_cd IS 'The manufacturer lot code from the lot master.';


--
-- Name: COLUMN po_unplanned_rcpt.org_nbr_mfr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.po_unplanned_rcpt.org_nbr_mfr IS 'The organization number of the manufacturer, copied from the lot master (ic_lot_mast).';


--
-- Name: COLUMN po_unplanned_rcpt.rev_lvl; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.po_unplanned_rcpt.rev_lvl IS 'The revision level of a SKU required to satisfy sourcing in advanced planning.';


--
-- Name: COLUMN po_unplanned_rcpt.ut_user_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.po_unplanned_rcpt.ut_user_nbr IS 'Surrogate primary key for UT_USER';


--
-- Name: COLUMN po_unplanned_rcpt.aps_sply_sub_pool_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.po_unplanned_rcpt.aps_sply_sub_pool_nbr IS 'a foreign key back to the primary key for the supply sub pool';


--
-- Name: COLUMN po_unplanned_rcpt.facility; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.po_unplanned_rcpt.facility IS 'The facility associated with this record.  ';


--
-- Name: COLUMN po_unplanned_rcpt.lot_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.po_unplanned_rcpt.lot_nbr IS 'The lot which was shipped, a foreign key back to the primary surrogate key in ic_lot_mast.';


--
-- Name: COLUMN po_unplanned_rcpt.unit_cost_stk_um; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.po_unplanned_rcpt.unit_cost_stk_um IS 'cost per unit in the base currency for the stock keeping unit of measure';


--
-- Name: COLUMN po_unplanned_rcpt.unit_cost_denom_stk_um; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.po_unplanned_rcpt.unit_cost_denom_stk_um IS 'cost per unit in the base currency for the stock keeping unit of measure';


--
-- Name: po_unplanned_rcpt_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.po_unplanned_rcpt_nbr_seq
    START WITH 88754
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.po_unplanned_rcpt_nbr_seq OWNER TO jjs;

--
-- Name: po_vnd_mast; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.po_vnd_mast (
    org_nbr_vnd integer NOT NULL,
    buy_indiv_nbr integer,
    ut_user_nbr integer NOT NULL,
    last_mod_dt timestamp without time zone NOT NULL,
    trd_flg character varying(1) NOT NULL,
    trd_gl_acct character varying(20),
    intro_dt timestamp without time zone NOT NULL,
    mail_to_addr_nbr_dflt integer NOT NULL,
    bill_to_addr_nbr_dflt integer,
    term_cd_dflt character varying(10) NOT NULL,
    ship_via_cd_dflt character varying(8) NOT NULL,
    fob_cd_dflt character varying(8) NOT NULL,
    curr_cd_dflt character varying(3) NOT NULL,
    replen_allow_flg character varying(1) NOT NULL,
    receive_allow_flg character varying(1) NOT NULL,
    stat_id character varying(1) NOT NULL,
    alloc_slip_dy integer,
    indiv_nbr_vnd_contact integer,
    work_order_rpt_nm character varying(255),
    vnd_ein_cd character varying(20),
    CONSTRAINT pvm_check_stat_id CHECK (((stat_id)::text = ANY (ARRAY[('S'::character varying)::text, ('A'::character varying)::text, ('I'::character varying)::text]))),
    CONSTRAINT sys_c0016168 CHECK (((trd_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0016169 CHECK (((replen_allow_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0016170 CHECK (((receive_allow_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text])))
);


ALTER TABLE aerodemo.po_vnd_mast OWNER TO jjs;

--
-- Name: COLUMN po_vnd_mast.org_nbr_vnd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.po_vnd_mast.org_nbr_vnd IS 'The organization number of the vendor from whom the inventory was purchased.';


--
-- Name: COLUMN po_vnd_mast.ut_user_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.po_vnd_mast.ut_user_nbr IS 'Surrogate primary key for UT_USER';


--
-- Name: COLUMN po_vnd_mast.trd_gl_acct; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.po_vnd_mast.trd_gl_acct IS 'The General Ledger account to be used to track the due/from due/to amount for the customer if the customer is a trading customer.';


--
-- Name: COLUMN po_vnd_mast.intro_dt; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.po_vnd_mast.intro_dt IS 'Introduction date.  The date the item became active.';


--
-- Name: COLUMN po_vnd_mast.bill_to_addr_nbr_dflt; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.po_vnd_mast.bill_to_addr_nbr_dflt IS 'Identifies the default bill to address for the customer.';


--
-- Name: COLUMN po_vnd_mast.term_cd_dflt; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.po_vnd_mast.term_cd_dflt IS 'The default payment terms for the customer, used as a default when creating customer orders.';


--
-- Name: COLUMN po_vnd_mast.ship_via_cd_dflt; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.po_vnd_mast.ship_via_cd_dflt IS 'Identifier for default mechanism for shipping to this customer.';


--
-- Name: COLUMN po_vnd_mast.curr_cd_dflt; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.po_vnd_mast.curr_cd_dflt IS 'The default currency code that the customer will use when placing orders.';


--
-- Name: po_vnd_set_dtl; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.po_vnd_set_dtl (
    po_vnd_set_hdr_nbr integer NOT NULL,
    org_nbr_vnd integer NOT NULL,
    ut_user_nbr integer NOT NULL,
    last_mod_dt timestamp without time zone NOT NULL
);


ALTER TABLE aerodemo.po_vnd_set_dtl OWNER TO jjs;

--
-- Name: COLUMN po_vnd_set_dtl.org_nbr_vnd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.po_vnd_set_dtl.org_nbr_vnd IS 'The organization number of the vendor from whom the inventory was purchased.';


--
-- Name: COLUMN po_vnd_set_dtl.ut_user_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.po_vnd_set_dtl.ut_user_nbr IS 'Surrogate primary key for UT_USER';


--
-- Name: po_vnd_set_hdr; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.po_vnd_set_hdr (
    po_vnd_set_hdr_nbr integer NOT NULL,
    po_vnd_set_hdr_cd character varying(20) NOT NULL,
    po_vnd_set_hdr_descr character varying(60),
    ut_user_nbr integer NOT NULL,
    last_mod_dt timestamp without time zone NOT NULL
);


ALTER TABLE aerodemo.po_vnd_set_hdr OWNER TO jjs;

--
-- Name: COLUMN po_vnd_set_hdr.ut_user_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.po_vnd_set_hdr.ut_user_nbr IS 'Surrogate primary key for UT_USER';


--
-- Name: po_vnd_set_hdr_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.po_vnd_set_hdr_nbr_seq
    START WITH 61
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.po_vnd_set_hdr_nbr_seq OWNER TO jjs;

--
-- Name: pos_dtl; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.pos_dtl (
    pos_dtl_nbr integer NOT NULL,
    pos_hdr_nbr integer NOT NULL,
    box_cd character varying(20) NOT NULL,
    qty_ship numeric(13,5) NOT NULL,
    qty_ship_stk_um numeric(13,5) NOT NULL,
    item_nbr_ship integer NOT NULL,
    lot_nbr integer NOT NULL,
    facility character varying(16) NOT NULL,
    aps_sply_sub_pool_nbr integer NOT NULL,
    unit_price_denom_sell_um numeric(17,6) NOT NULL,
    unit_price_sell_um numeric(17,6) NOT NULL,
    unit_price_denom_stk_um numeric(17,6) NOT NULL,
    unit_price_stk_um numeric(17,6) NOT NULL,
    contract_cd character varying(8),
    cust_bin_cd character varying(40),
    ut_user_nbr integer NOT NULL,
    last_mod_dt timestamp without time zone NOT NULL,
    item_cd_cust character varying(50),
    oe_ord_dtl_nbr integer,
    oe_ord_line_nbr integer
);


ALTER TABLE aerodemo.pos_dtl OWNER TO jjs;

--
-- Name: COLUMN pos_dtl.qty_ship; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.pos_dtl.qty_ship IS 'the quantity shipped for this invoice line in the stock keeping unit of measure.';


--
-- Name: COLUMN pos_dtl.lot_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.pos_dtl.lot_nbr IS 'The lot which was shipped, a foreign key back to the primary surrogate key in ic_lot_mast.';


--
-- Name: COLUMN pos_dtl.facility; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.pos_dtl.facility IS 'the facility from which the inventory was shipped.';


--
-- Name: COLUMN pos_dtl.aps_sply_sub_pool_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.pos_dtl.aps_sply_sub_pool_nbr IS 'a foreign key back to the primary key for the supply sub pool';


--
-- Name: COLUMN pos_dtl.contract_cd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.pos_dtl.contract_cd IS 'The contract code, from the order detail line under which the goods were purchased.';


--
-- Name: COLUMN pos_dtl.cust_bin_cd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.pos_dtl.cust_bin_cd IS 'The customer bin for which the inventory was destined.';


--
-- Name: COLUMN pos_dtl.ut_user_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.pos_dtl.ut_user_nbr IS 'Surrogate primary key for UT_USER';


--
-- Name: COLUMN pos_dtl.item_cd_cust; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.pos_dtl.item_cd_cust IS 'The part number the customer uses to identify this part.';


--
-- Name: COLUMN pos_dtl.oe_ord_dtl_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.pos_dtl.oe_ord_dtl_nbr IS 'A foreign key back to the order detail.';


--
-- Name: pos_dtl_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.pos_dtl_nbr_seq
    START WITH 85165
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.pos_dtl_nbr_seq OWNER TO jjs;

--
-- Name: pos_hdr_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.pos_hdr_nbr_seq
    START WITH 20119
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE aerodemo.pos_hdr_nbr_seq OWNER TO jjs;

--
-- Name: qa_cust_rtrn; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.qa_cust_rtrn (
    qa_cust_rtrn_nbr integer NOT NULL,
    oe_ord_hdr_nbr integer,
    oe_ord_dtl_nbr integer,
    item_nbr integer NOT NULL,
    org_nbr_mfr integer,
    mfr_lot_cd character varying(20) NOT NULL,
    rtrn_reason_cd character varying(5),
    dt_init timestamp without time zone NOT NULL,
    org_nbr_cust integer,
    lot_nbr integer,
    org_nbr_vnd integer,
    disp_cd character varying(3),
    dt_closed timestamp without time zone,
    ut_user_nbr_init integer,
    qty_rtrn_from_cust integer,
    qty_rtrn_to_vnd integer,
    bad_lot_flg character varying(1) NOT NULL,
    reject_cd character varying(8),
    CONSTRAINT sys_c0015728 CHECK (((bad_lot_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text])))
);


ALTER TABLE aerodemo.qa_cust_rtrn OWNER TO jjs;

--
-- Name: COLUMN qa_cust_rtrn.oe_ord_dtl_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.qa_cust_rtrn.oe_ord_dtl_nbr IS 'A foreign key back to the order detail.';


--
-- Name: COLUMN qa_cust_rtrn.item_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.qa_cust_rtrn.item_nbr IS 'Product identifier, reference to item master (IC_ITEM_MAST.ITEM_NBR)';


--
-- Name: COLUMN qa_cust_rtrn.org_nbr_mfr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.qa_cust_rtrn.org_nbr_mfr IS 'The organization number of the manufacturer, copied from the lot master (ic_lot_mast).';


--
-- Name: COLUMN qa_cust_rtrn.mfr_lot_cd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.qa_cust_rtrn.mfr_lot_cd IS 'The manufacturer lot code from the lot master.';


--
-- Name: COLUMN qa_cust_rtrn.org_nbr_cust; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.qa_cust_rtrn.org_nbr_cust IS 'Reference to the customer (OE_CUST_MAST.ORG_NBR_CUST';


--
-- Name: COLUMN qa_cust_rtrn.lot_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.qa_cust_rtrn.lot_nbr IS 'The lot which was shipped, a foreign key back to the primary surrogate key in ic_lot_mast.';


--
-- Name: COLUMN qa_cust_rtrn.org_nbr_vnd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.qa_cust_rtrn.org_nbr_vnd IS 'The organization number of the vendor from whom the inventory was purchased.';


--
-- Name: qa_cust_rtrn_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.qa_cust_rtrn_nbr_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.qa_cust_rtrn_nbr_seq OWNER TO jjs;

--
-- Name: qa_log_run_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.qa_log_run_nbr_seq
    START WITH 113382
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.qa_log_run_nbr_seq OWNER TO jjs;

--
-- Name: qa_mfr_apprv; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.qa_mfr_apprv (
    qa_proj_cd character varying(16) NOT NULL,
    item_nbr integer NOT NULL,
    org_nbr_mfr integer NOT NULL,
    mfr_restrict_id character varying(1) NOT NULL,
    CONSTRAINT sys_c0015735 CHECK (((mfr_restrict_id)::text = ANY (ARRAY[('E'::character varying)::text, ('I'::character varying)::text])))
);


ALTER TABLE aerodemo.qa_mfr_apprv OWNER TO jjs;

--
-- Name: COLUMN qa_mfr_apprv.item_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.qa_mfr_apprv.item_nbr IS 'Product identifier, reference to item master (IC_ITEM_MAST.ITEM_NBR)';


--
-- Name: COLUMN qa_mfr_apprv.org_nbr_mfr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.qa_mfr_apprv.org_nbr_mfr IS 'The organization number of the manufacturer, copied from the lot master (ic_lot_mast).';


--
-- Name: qa_tst_rslt; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.qa_tst_rslt (
    qa_tst_rslt_nbr integer NOT NULL,
    qa_proj_cd character varying(16) NOT NULL,
    qa_tst_cd character varying(16) NOT NULL,
    org_nbr_mfr integer NOT NULL,
    org_nbr_vnd integer NOT NULL,
    item_nbr integer NOT NULL,
    tst_rslt character varying(1),
    qty_on_hand numeric(15,5),
    sample_size integer,
    sample_size_um character varying(3),
    mfr_lot_cd character varying(20),
    org_nbr_cust integer,
    lot_nbr integer NOT NULL,
    recv_indicator character varying(1),
    ic_attr_nbr integer NOT NULL,
    attr_val character varying(20) NOT NULL,
    test_lab character varying(5),
    sent_to_tst_facility_dt timestamp without time zone,
    recv_from_tst_facility_dt timestamp without time zone,
    tst_invoiced_flg character varying(1) NOT NULL,
    test_cost numeric(7,2),
    qa_tst_ste_cd character varying(16),
    plan_nbr integer,
    plan_line_nbr smallint,
    rcpt_cnt integer,
    cycle_cnt integer,
    skip_flg character varying(1) NOT NULL,
    tst_cre_dt timestamp without time zone NOT NULL,
    CONSTRAINT sys_c0015750 CHECK (((tst_invoiced_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT sys_c0015751 CHECK (((skip_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text])))
);


ALTER TABLE aerodemo.qa_tst_rslt OWNER TO jjs;

--
-- Name: COLUMN qa_tst_rslt.org_nbr_mfr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.qa_tst_rslt.org_nbr_mfr IS 'The organization number of the manufacturer, copied from the lot master (ic_lot_mast).';


--
-- Name: COLUMN qa_tst_rslt.org_nbr_vnd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.qa_tst_rslt.org_nbr_vnd IS 'The organization number of the vendor from whom the inventory was purchased.';


--
-- Name: COLUMN qa_tst_rslt.item_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.qa_tst_rslt.item_nbr IS 'Product identifier, reference to item master (IC_ITEM_MAST.ITEM_NBR)';


--
-- Name: COLUMN qa_tst_rslt.qty_on_hand; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.qa_tst_rslt.qty_on_hand IS 'Quantity on Hand in stock keeping unit of measure.';


--
-- Name: COLUMN qa_tst_rslt.mfr_lot_cd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.qa_tst_rslt.mfr_lot_cd IS 'The manufacturer lot code from the lot master.';


--
-- Name: COLUMN qa_tst_rslt.org_nbr_cust; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.qa_tst_rslt.org_nbr_cust IS 'Reference to the customer (OE_CUST_MAST.ORG_NBR_CUST';


--
-- Name: COLUMN qa_tst_rslt.lot_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.qa_tst_rslt.lot_nbr IS 'The lot which was shipped, a foreign key back to the primary surrogate key in ic_lot_mast.';


--
-- Name: COLUMN qa_tst_rslt.ic_attr_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.qa_tst_rslt.ic_attr_nbr IS 'Surrogate primary key for IC_ATTR_NBR';


--
-- Name: COLUMN qa_tst_rslt.attr_val; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.qa_tst_rslt.attr_val IS 'Attribute value.';


--
-- Name: qa_tst_rslt_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.qa_tst_rslt_nbr_seq
    START WITH 245927
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.qa_tst_rslt_nbr_seq OWNER TO jjs;

--
-- Name: qa_tst_ste_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.qa_tst_ste_nbr_seq
    START WITH 8455
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.qa_tst_ste_nbr_seq OWNER TO jjs;

--
-- Name: rma_cd_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.rma_cd_seq
    START WITH 4670
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE aerodemo.rma_cd_seq OWNER TO jjs;

--
-- Name: sales_call_dtl_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.sales_call_dtl_nbr_seq
    START WITH 61
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.sales_call_dtl_nbr_seq OWNER TO jjs;

--
-- Name: sales_call_hdr_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.sales_call_hdr_nbr_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.sales_call_hdr_nbr_seq OWNER TO jjs;

--
-- Name: sales_lead_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.sales_lead_nbr_seq
    START WITH 101
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.sales_lead_nbr_seq OWNER TO jjs;

--
-- Name: scenario_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.scenario_nbr_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.scenario_nbr_seq OWNER TO jjs;

--
-- Name: season_start_dates; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.season_start_dates (
    season character varying(10) NOT NULL,
    start_dt timestamp without time zone
);


ALTER TABLE aerodemo.season_start_dates OWNER TO jjs;

--
-- Name: sequence_generator; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.sequence_generator
    START WITH 3050
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.sequence_generator OWNER TO jjs;

--
-- Name: service_rqst; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.service_rqst (
    service_rqst_cd character varying(20) NOT NULL,
    service_rqst_descr character varying(60) NOT NULL,
    classname character varying(255) NOT NULL,
    pipe_nm character varying(255),
    validate_flg character varying(1) DEFAULT 'Y'::character varying NOT NULL,
    CONSTRAINT sys_c0016413 CHECK (((validate_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text])))
);


ALTER TABLE aerodemo.service_rqst OWNER TO jjs;

--
-- Name: service_rqst_log_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.service_rqst_log_nbr_seq
    START WITH 3696946
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.service_rqst_log_nbr_seq OWNER TO jjs;

--
-- Name: service_rqst_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.service_rqst_nbr_seq
    START WITH 1070125
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.service_rqst_nbr_seq OWNER TO jjs;

--
-- Name: service_rqst_parms; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.service_rqst_parms (
    service_rqst_cd character varying(20) NOT NULL,
    parm_nm character varying(30) NOT NULL,
    parm_data_type character varying(10) NOT NULL,
    parm_nm_descr character varying(60) NOT NULL,
    CONSTRAINT sys_c0016137 CHECK (((parm_data_type)::text = ANY (ARRAY[('NUMBER'::character varying)::text, ('VARCHAR2'::character varying)::text, ('DATE'::character varying)::text])))
);


ALTER TABLE aerodemo.service_rqst_parms OWNER TO jjs;

--
-- Name: ship_notify_log_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.ship_notify_log_seq
    START WITH 5917
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.ship_notify_log_seq OWNER TO jjs;

--
-- Name: sq_qte_dtl; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.sq_qte_dtl (
    sq_qte_dtl_nbr integer NOT NULL,
    sq_qte_hdr_nbr integer NOT NULL,
    item_nbr_qte integer,
    item_cd_qte character varying(50) NOT NULL,
    item_cd_cust character varying(50) NOT NULL,
    qte_um character varying(3) NOT NULL,
    qte_qty numeric(13,5) NOT NULL,
    qte_qty_stk_um numeric(13,5) NOT NULL,
    qte_price numeric(17,6),
    qte_price_denom numeric(17,6),
    qte_price_stk_um numeric(17,6),
    qte_price_denom_stk_um numeric(17,6),
    org_nbr_mfr_rqst integer,
    rqst_dt timestamp without time zone,
    lead_tm_wk_prom smallint,
    prom_dt timestamp without time zone,
    sq_lost_cd character varying(8),
    oe_ord_dtl_nbr integer,
    rev_lvl character varying(5),
    qte_price_basis_id character varying(1),
    qte_price_basis_key character varying(20),
    qte_price_basis_cost numeric(17,6),
    ut_user_nbr integer NOT NULL,
    last_mod_dt timestamp without time zone NOT NULL
);


ALTER TABLE aerodemo.sq_qte_dtl OWNER TO jjs;

--
-- Name: COLUMN sq_qte_dtl.item_cd_cust; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.sq_qte_dtl.item_cd_cust IS 'The part number the customer uses to identify this part.';


--
-- Name: COLUMN sq_qte_dtl.rqst_dt; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.sq_qte_dtl.rqst_dt IS 'The date the customer requests the item to be shipped.';


--
-- Name: COLUMN sq_qte_dtl.prom_dt; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.sq_qte_dtl.prom_dt IS 'The most recent promise date.';


--
-- Name: COLUMN sq_qte_dtl.oe_ord_dtl_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.sq_qte_dtl.oe_ord_dtl_nbr IS 'A foreign key back to the order detail.';


--
-- Name: COLUMN sq_qte_dtl.rev_lvl; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.sq_qte_dtl.rev_lvl IS 'The revision level of a SKU required to satisfy sourcing in advanced planning.';


--
-- Name: COLUMN sq_qte_dtl.ut_user_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.sq_qte_dtl.ut_user_nbr IS 'Surrogate primary key for UT_USER';


--
-- Name: sq_qte_dtl_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.sq_qte_dtl_nbr_seq
    START WITH 1744709
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.sq_qte_dtl_nbr_seq OWNER TO jjs;

--
-- Name: sq_qte_hdr; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.sq_qte_hdr (
    sq_qte_hdr_nbr integer NOT NULL,
    sq_qte_cd character varying(20) NOT NULL,
    org_nbr_cust integer NOT NULL,
    sq_qte_dt timestamp without time zone NOT NULL,
    curr_cd_qte character varying(9) NOT NULL,
    indiv_nm_spoken_to character varying(40),
    indiv_phn_nbr character varying(20),
    indiv_fax_nbr character varying(20),
    indiv_email_addr character varying(40),
    sq_qte_eff_dt timestamp without time zone NOT NULL,
    sq_qte_exp_dt timestamp without time zone NOT NULL,
    cust_qte_ref_cd character varying(20),
    sq_qte_indiv_nbr integer NOT NULL,
    ut_user_nbr integer NOT NULL,
    last_mod_dt timestamp without time zone NOT NULL,
    transmit_flg character varying(1) DEFAULT 'N'::character varying NOT NULL,
    org_nm_cust character varying(60) NOT NULL,
    CONSTRAINT sys_c0016317 CHECK (((transmit_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text])))
);


ALTER TABLE aerodemo.sq_qte_hdr OWNER TO jjs;

--
-- Name: sq_qte_hdr_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.sq_qte_hdr_nbr_seq
    START WITH 494601
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.sq_qte_hdr_nbr_seq OWNER TO jjs;

--
-- Name: sq_qte_vw; Type: VIEW; Schema: aerodemo; Owner: jjs
--

CREATE VIEW aerodemo.sq_qte_vw AS
 SELECT h.sq_qte_hdr_nbr,
    h.sq_qte_cd,
    h.org_nbr_cust,
    h.curr_cd_qte,
    h.indiv_nm_spoken_to,
    h.indiv_phn_nbr,
    h.indiv_fax_nbr,
    h.indiv_email_addr,
    h.sq_qte_eff_dt,
    h.sq_qte_exp_dt,
    h.cust_qte_ref_cd,
    h.sq_qte_indiv_nbr,
    h.ut_user_nbr AS ut_user_nbr_hdr,
    h.last_mod_dt AS last_mod_dt_hdr,
    h.transmit_flg,
    h.org_nm_cust,
    dtl.sq_qte_dtl_nbr,
    dtl.item_nbr_qte,
    dtl.item_cd_qte,
    dtl.item_cd_cust,
    dtl.qte_um,
    dtl.qte_qty,
    dtl.qte_qty_stk_um,
    dtl.qte_price,
    dtl.qte_price_denom,
    dtl.qte_price_stk_um,
    dtl.qte_price_denom_stk_um,
    dtl.org_nbr_mfr_rqst,
    dtl.rqst_dt,
    dtl.lead_tm_wk_prom,
    dtl.prom_dt,
    dtl.sq_lost_cd,
    dtl.oe_ord_dtl_nbr,
    dtl.rev_lvl,
    dtl.qte_price_basis_id,
    dtl.qte_price_basis_key,
    dtl.qte_price_basis_cost,
    dtl.ut_user_nbr AS ut_user_nbr_dtl,
    dtl.last_mod_dt AS last_mod_dt_dtl
   FROM aerodemo.sq_qte_hdr h,
    aerodemo.sq_qte_dtl dtl
  WHERE (h.sq_qte_hdr_nbr = dtl.sq_qte_hdr_nbr);


ALTER TABLE aerodemo.sq_qte_vw OWNER TO jjs;

--
-- Name: sq_qte_vw_xl; Type: VIEW; Schema: aerodemo; Owner: jjs
--

CREATE VIEW aerodemo.sq_qte_vw_xl AS
 SELECT sq_qte_vw.sq_qte_hdr_nbr,
    sq_qte_vw.sq_qte_cd,
    sq_qte_vw.org_nbr_cust,
    sq_qte_vw.curr_cd_qte,
    sq_qte_vw.sq_qte_eff_dt,
    sq_qte_vw.sq_qte_exp_dt,
    sq_qte_vw.org_nm_cust,
    sq_qte_vw.item_nbr_qte,
    sq_qte_vw.item_cd_qte,
    sq_qte_vw.item_cd_cust,
    sq_qte_vw.qte_qty,
    sq_qte_vw.qte_price_stk_um,
    sq_qte_vw.org_nbr_mfr_rqst,
    sq_qte_vw.rqst_dt,
    sq_qte_vw.lead_tm_wk_prom,
    sq_qte_vw.prom_dt,
    sq_qte_vw.sq_lost_cd
   FROM aerodemo.sq_qte_vw;


ALTER TABLE aerodemo.sq_qte_vw_xl OWNER TO jjs;

--
-- Name: ss_adj; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.ss_adj (
    fc_item_mast_nbr integer NOT NULL,
    ss_adj bigint
);


ALTER TABLE aerodemo.ss_adj OWNER TO jjs;

--
-- Name: COLUMN ss_adj.fc_item_mast_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ss_adj.fc_item_mast_nbr IS 'Surrogate primary key for FC_ITEM_MAST.';


--
-- Name: ss_tmp; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.ss_tmp (
    fc_item_mast_nbr integer NOT NULL,
    ss_adj bigint
);


ALTER TABLE aerodemo.ss_tmp OWNER TO jjs;

--
-- Name: td_task_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.td_task_nbr_seq
    START WITH 21
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.td_task_nbr_seq OWNER TO jjs;

--
-- Name: tmp_fim; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.tmp_fim (
    fc_item_mast_nbr integer
);


ALTER TABLE aerodemo.tmp_fim OWNER TO jjs;

--
-- Name: tmp_item; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.tmp_item (
    item_nbr integer
);


ALTER TABLE aerodemo.tmp_item OWNER TO jjs;

--
-- Name: COLUMN tmp_item.item_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.tmp_item.item_nbr IS 'Product identifier, reference to item master (IC_ITEM_MAST.ITEM_NBR)';


--
-- Name: toad_lick; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.toad_lick (
    lick character varying(1)
);


ALTER TABLE aerodemo.toad_lick OWNER TO jjs;

--
-- Name: unbrako_ord_charge_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.unbrako_ord_charge_nbr_seq
    START WITH 83
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.unbrako_ord_charge_nbr_seq OWNER TO jjs;

--
-- Name: unbrako_ord_dtl_cert_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.unbrako_ord_dtl_cert_nbr_seq
    START WITH 635
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.unbrako_ord_dtl_cert_nbr_seq OWNER TO jjs;

--
-- Name: unbrako_ord_dtl_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.unbrako_ord_dtl_nbr_seq
    START WITH 20778
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.unbrako_ord_dtl_nbr_seq OWNER TO jjs;

--
-- Name: unbrako_ord_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.unbrako_ord_nbr_seq
    START WITH 4498
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.unbrako_ord_nbr_seq OWNER TO jjs;

--
-- Name: unbrako_trans_dtl_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.unbrako_trans_dtl_nbr_seq
    START WITH 181
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.unbrako_trans_dtl_nbr_seq OWNER TO jjs;

--
-- Name: unbrako_trans_hdr_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.unbrako_trans_hdr_nbr_seq
    START WITH 101
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.unbrako_trans_hdr_nbr_seq OWNER TO jjs;

--
-- Name: ut_cache; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.ut_cache (
    object_name character varying(32) NOT NULL,
    change_time timestamp without time zone,
    cache_change_nbr integer NOT NULL,
    class_name character varying(32)
);


ALTER TABLE aerodemo.ut_cache OWNER TO jjs;

--
-- Name: ut_data_src; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.ut_data_src (
    data_src_nm character varying(20) NOT NULL,
    data_src_url character varying(512),
    data_src_driver_nm character varying(128) NOT NULL,
    data_src_username character varying(20) NOT NULL,
    data_src_password character varying(20) NOT NULL
);


ALTER TABLE aerodemo.ut_data_src OWNER TO jjs;

--
-- Name: ut_etl; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.ut_etl (
    ut_etl_nbr integer NOT NULL,
    ut_etl_descr character varying(80) NOT NULL,
    trunc_flg character varying(1) NOT NULL,
    table_id character varying(8) NOT NULL,
    data_select_stmt character varying(4000) NOT NULL,
    data_insert_stmt character varying(4000) NOT NULL,
    data_src_nm_src character varying(20) NOT NULL,
    data_src_nm_dest character varying(20) NOT NULL,
    CONSTRAINT sys_c0016118 CHECK (((trunc_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text])))
);


ALTER TABLE aerodemo.ut_etl OWNER TO jjs;

--
-- Name: ut_etl_grp; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.ut_etl_grp (
    ut_etl_grp_cd character varying(20) NOT NULL,
    ut_etl_grp_descr character varying(60) NOT NULL
);


ALTER TABLE aerodemo.ut_etl_grp OWNER TO jjs;

--
-- Name: ut_etl_grp_dtl; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.ut_etl_grp_dtl (
    ut_etl_grp_cd character varying(20) NOT NULL,
    ut_etl_nbr integer NOT NULL
);


ALTER TABLE aerodemo.ut_etl_grp_dtl OWNER TO jjs;

--
-- Name: ut_facility; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.ut_facility (
    facility character varying(16) NOT NULL,
    primary_addr_nbr integer,
    ut_user_nbr integer NOT NULL,
    last_mod_dt timestamp without time zone NOT NULL,
    calendar character varying(6) NOT NULL,
    facility_stat_id character varying(1) NOT NULL,
    ut_facility_nbr integer NOT NULL,
    CONSTRAINT sys_c0015776 CHECK (((facility_stat_id)::text = ANY (ARRAY[('A'::character varying)::text, ('I'::character varying)::text])))
);


ALTER TABLE aerodemo.ut_facility OWNER TO jjs;

--
-- Name: COLUMN ut_facility.facility; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ut_facility.facility IS 'Natural Identifier for this facility';


--
-- Name: COLUMN ut_facility.ut_user_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ut_facility.ut_user_nbr IS 'Surrogate primary key for UT_USER';


--
-- Name: COLUMN ut_facility.calendar; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ut_facility.calendar IS 'The business calendar associated with this date.';


--
-- Name: ut_facility_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.ut_facility_nbr_seq
    START WITH 41
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.ut_facility_nbr_seq OWNER TO jjs;

--
-- Name: ut_form_tab_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.ut_form_tab_nbr_seq
    START WITH 81
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.ut_form_tab_nbr_seq OWNER TO jjs;

--
-- Name: ut_locale_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.ut_locale_nbr_seq
    START WITH 21
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.ut_locale_nbr_seq OWNER TO jjs;

--
-- Name: ut_note; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.ut_note (
    note_nbr integer NOT NULL,
    table_id character varying(8) NOT NULL,
    table_key integer NOT NULL,
    note character varying(2048),
    ut_user_nbr_enter integer NOT NULL,
    entry_dt timestamp without time zone NOT NULL,
    entry_tm character varying(5),
    ut_user_nbr_mod integer NOT NULL,
    action_dt timestamp without time zone,
    action_flg character varying(1) NOT NULL,
    last_mod_dt timestamp without time zone NOT NULL,
    last_mod_tm character varying(7),
    note_type_cd character varying(8)
);


ALTER TABLE aerodemo.ut_note OWNER TO jjs;

--
-- Name: ut_process_status; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.ut_process_status (
    ut_process_status_nbr integer NOT NULL,
    process_nm character varying(128) NOT NULL,
    thread_nm character varying(128) NOT NULL,
    process_run_nbr integer NOT NULL,
    status_msg character varying(2000) NOT NULL,
    status_id character varying(1) NOT NULL,
    status_ts timestamp without time zone NOT NULL
);


ALTER TABLE aerodemo.ut_process_status OWNER TO jjs;

--
-- Name: ut_query; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.ut_query (
    query_nm character varying(32) NOT NULL,
    table_id character varying(8),
    query_text character varying(4000)
);


ALTER TABLE aerodemo.ut_query OWNER TO jjs;

--
-- Name: ut_surrogate_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.ut_surrogate_seq
    START WITH 25621
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.ut_surrogate_seq OWNER TO jjs;

--
-- Name: ut_table; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.ut_table (
    table_id character varying(8) NOT NULL,
    table_name character varying(64) NOT NULL
);


ALTER TABLE aerodemo.ut_table OWNER TO jjs;

--
-- Name: ut_table_row_msg; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.ut_table_row_msg (
    table_id character varying(32),
    primary_key bigint,
    msg_id character varying(16),
    msg character varying(64)
);


ALTER TABLE aerodemo.ut_table_row_msg OWNER TO jjs;

--
-- Name: ut_table_rule; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.ut_table_rule (
    table_id character varying(8) NOT NULL,
    msg_id character varying(16) NOT NULL,
    sql_text character varying(4000) NOT NULL,
    msg_descr character varying(4000),
    query_nm character varying(32),
    rule_type character varying(8)
);


ALTER TABLE aerodemo.ut_table_rule OWNER TO jjs;

--
-- Name: ut_user; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.ut_user (
    org_nbr integer NOT NULL,
    ut_user_nbr integer NOT NULL,
    user_name character varying(15) NOT NULL,
    passwd character varying(10) NOT NULL,
    calendar character varying(6) NOT NULL,
    facility character varying(16),
    printer character varying(50),
    printer_label character varying(50),
    pick_rule_cd character varying(8),
    pack_station character varying(16),
    rf_passwd character varying(20),
    indiv_nbr integer NOT NULL,
    last_login_tm timestamp without time zone,
    show_tooltip_flg character varying(1) NOT NULL,
    user_stat_id character varying(1) NOT NULL,
    ldap_attr_val character varying(30),
    ldap_user_hash character varying(40),
    ldap_conn_expire_tm timestamp without time zone,
    CONSTRAINT sys_c0015794 CHECK (((show_tooltip_flg)::text = ANY (ARRAY[('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT uu_check_user_stat_id CHECK (((user_stat_id)::text = ANY (ARRAY[('A'::character varying)::text, ('I'::character varying)::text])))
);


ALTER TABLE aerodemo.ut_user OWNER TO jjs;

--
-- Name: COLUMN ut_user.org_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ut_user.org_nbr IS 'Surrogate primary key for ORG_NBR';


--
-- Name: COLUMN ut_user.ut_user_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ut_user.ut_user_nbr IS 'Surrogate primary key for UT_USER';


--
-- Name: COLUMN ut_user.passwd; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ut_user.passwd IS 'A password, may be encrypted or obfuscated.  Depending on options may be reversible.';


--
-- Name: COLUMN ut_user.calendar; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ut_user.calendar IS 'The name of the calendar to be used for this entity.';


--
-- Name: COLUMN ut_user.facility; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ut_user.facility IS 'The facility associated with this record.  ';


--
-- Name: COLUMN ut_user.indiv_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.ut_user.indiv_nbr IS 'Surrogate primary key for INDIV_NBR';


--
-- Name: ut_user_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.ut_user_nbr_seq
    START WITH 3106
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.ut_user_nbr_seq OWNER TO jjs;

--
-- Name: ut_user_role; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.ut_user_role (
    ut_user_nbr integer,
    role_nm character varying(8)
);


ALTER TABLE aerodemo.ut_user_role OWNER TO jjs;

--
-- Name: ut_web_session; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.ut_web_session (
    session_id character varying(255),
    user_name character varying(15)
);


ALTER TABLE aerodemo.ut_web_session OWNER TO jjs;

--
-- Name: vnd_rtrn_dtl_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.vnd_rtrn_dtl_nbr_seq
    START WITH 6062
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.vnd_rtrn_dtl_nbr_seq OWNER TO jjs;

--
-- Name: vnd_rtrn_hdr_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.vnd_rtrn_hdr_nbr_seq
    START WITH 5775
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.vnd_rtrn_hdr_nbr_seq OWNER TO jjs;

--
-- Name: vq_na_org; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.vq_na_org (
    org_nbr integer NOT NULL,
    org_nm character varying(60) NOT NULL,
    ut_user_nbr integer NOT NULL,
    last_mod_dt timestamp without time zone NOT NULL,
    org_web_site character varying(255),
    curr_cd_dflt character varying(3),
    org_cd character varying(15) NOT NULL,
    phn_nbr_dflt character varying(20),
    fax_nbr_dflt character varying(20),
    calendar character varying(6) NOT NULL,
    ut_locale_nbr integer
);


ALTER TABLE aerodemo.vq_na_org OWNER TO jjs;

--
-- Name: vq_qte_dtl_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.vq_qte_dtl_nbr_seq
    START WITH 1226927
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.vq_qte_dtl_nbr_seq OWNER TO jjs;

--
-- Name: vq_qte_hdr_dtl_vw; Type: VIEW; Schema: aerodemo; Owner: jjs
--

CREATE VIEW aerodemo.vq_qte_hdr_dtl_vw AS
 SELECT h.vq_qte_hdr_nbr,
    h.vq_qte_cd,
    h.org_nbr_vnd,
    v.org_cd,
    v.org_nm,
    h.vq_qte_dt,
    h.curr_cd_qte,
    h.indiv_nm_spoken_to,
    h.indiv_phn_nbr,
    h.indiv_fax_nbr,
    h.indiv_email_addr,
    h.vq_qte_eff_dt,
    h.vq_qte_exp_dt,
    h.vnd_qte_ref_cd,
    h.vq_qte_indiv_nbr,
    h.transmit_flg,
    d.vq_qte_dtl_nbr,
    d.item_nbr_qte,
    d.item_cd_qte,
    d.item_cd_vnd,
    d.qte_um,
    d.qte_qty,
    d.qte_qty_stk_um,
    d.qte_cost,
    d.qte_cost_denom,
    d.qte_cost_stk_um,
    d.qte_cost_denom_stk_um,
    d.org_nbr_mfr_rqst,
    d.rev_lvl,
    d.rqst_dt,
    d.lead_tm_wk_prom,
    d.prom_dt,
    d.vq_lost_cd,
    i.item_cd,
    i.item_descr
   FROM aerodemo.vq_qte_hdr h,
    aerodemo.vq_qte_dtl d,
    aerodemo.ic_item_mast i,
    aerodemo.na_org v
  WHERE ((h.vq_qte_hdr_nbr = d.vq_qte_hdr_nbr) AND (i.item_nbr = d.item_nbr_qte) AND (v.org_nbr = h.org_nbr_vnd));


ALTER TABLE aerodemo.vq_qte_hdr_dtl_vw OWNER TO jjs;

--
-- Name: vq_qte_hdr_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.vq_qte_hdr_nbr_seq
    START WITH 271315
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.vq_qte_hdr_nbr_seq OWNER TO jjs;

--
-- Name: vq_qte_multiple_cert; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.vq_qte_multiple_cert (
    vq_qte_dtl_nbr integer NOT NULL,
    item_nbr integer NOT NULL,
    ut_user_nbr integer NOT NULL,
    last_mod_dt timestamp without time zone NOT NULL
);


ALTER TABLE aerodemo.vq_qte_multiple_cert OWNER TO jjs;

--
-- Name: COLUMN vq_qte_multiple_cert.item_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.vq_qte_multiple_cert.item_nbr IS 'Product Identifier, reference to item master (IC_ITEM_MAST.ITEM_NBR)';


--
-- Name: COLUMN vq_qte_multiple_cert.ut_user_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.vq_qte_multiple_cert.ut_user_nbr IS 'Surrogate primary key for UT_USER';


--
-- Name: vq_qte_vw_xl; Type: VIEW; Schema: aerodemo; Owner: jjs
--

CREATE VIEW aerodemo.vq_qte_vw_xl AS
 SELECT vq_qte_vw.item_cd_qte,
    vq_qte_vw.org_nm,
    vq_qte_vw.vq_qte_eff_dt,
    vq_qte_vw.qte_qty_stk_um,
    vq_qte_vw.qte_cost,
    vq_qte_vw.qte_cost_stk_um,
    vq_qte_vw.qte_cost_denom,
    vq_qte_vw.vq_qte_dt,
    vq_qte_vw.vq_qte_cd,
    vq_qte_vw.rqst_dt,
    vq_qte_vw.prom_dt,
    vq_qte_vw.vq_qte_exp_dt,
    vq_qte_vw.qte_cost_denom_stk_um,
    vq_qte_vw.rev_lvl,
    vq_qte_vw.lead_tm_wk_prom,
    vq_qte_vw.vq_lost_cd,
    vq_qte_vw.item_nbr_qte
   FROM aerodemo.vq_qte_vw
  WHERE (vq_qte_vw.qte_cost IS NOT NULL)
  ORDER BY vq_qte_vw.item_cd_qte, vq_qte_vw.org_nm, vq_qte_vw.vq_qte_eff_dt, vq_qte_vw.qte_qty_stk_um;


ALTER TABLE aerodemo.vq_qte_vw_xl OWNER TO jjs;

--
-- Name: wank_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.wank_seq
    START WITH 521
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.wank_seq OWNER TO jjs;

--
-- Name: web_report; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.web_report (
    web_report_nbr integer NOT NULL,
    report_cd character varying(16) NOT NULL,
    report_descr character varying(60),
    xsql_file_nm character varying(255) NOT NULL,
    xsl_file_nm character varying(255),
    apex_app_nbr_src integer,
    apex_app_nbr_dest integer,
    apex_page_nbr integer
);


ALTER TABLE aerodemo.web_report OWNER TO jjs;

--
-- Name: wh_container_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.wh_container_nbr_seq
    START WITH 35741
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.wh_container_nbr_seq OWNER TO jjs;

--
-- Name: wh_cycle_cnt_batch_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.wh_cycle_cnt_batch_nbr_seq
    START WITH 50730
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.wh_cycle_cnt_batch_nbr_seq OWNER TO jjs;

--
-- Name: wh_cycle_cnt_rqst_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.wh_cycle_cnt_rqst_nbr_seq
    START WITH 204028
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.wh_cycle_cnt_rqst_nbr_seq OWNER TO jjs;

--
-- Name: wh_facility_trans_log_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.wh_facility_trans_log_nbr_seq
    START WITH 159452
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.wh_facility_trans_log_nbr_seq OWNER TO jjs;

--
-- Name: wh_facility_trans_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.wh_facility_trans_nbr_seq
    START WITH 155025
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.wh_facility_trans_nbr_seq OWNER TO jjs;

--
-- Name: wh_facility_trans_onhand; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.wh_facility_trans_onhand (
    wh_facility_trans_onhand_nbr integer NOT NULL,
    rqst_stat_id character varying(1) NOT NULL,
    facility_src character varying(16) NOT NULL,
    aps_sply_sub_pool_nbr_src integer NOT NULL,
    facility_dest character varying(16) NOT NULL,
    aps_sply_sub_pool_nbr_dest integer NOT NULL,
    qty_rqst numeric(13,5) NOT NULL,
    rqst_dt timestamp without time zone NOT NULL,
    lot_nbr integer NOT NULL,
    ut_user_nbr_rqst integer NOT NULL,
    ut_user_nbr_confirm integer,
    ut_user_nbr integer NOT NULL,
    last_mod_dt timestamp without time zone NOT NULL,
    box_cd character varying(20),
    avail_dt timestamp without time zone,
    CONSTRAINT wfto_check_rqst_stat_id CHECK (((rqst_stat_id)::text = ANY (ARRAY[('R'::character varying)::text, ('P'::character varying)::text, ('F'::character varying)::text])))
);


ALTER TABLE aerodemo.wh_facility_trans_onhand OWNER TO jjs;

--
-- Name: COLUMN wh_facility_trans_onhand.rqst_stat_id; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.wh_facility_trans_onhand.rqst_stat_id IS 'R - Requested,
	P - Planned. Only the Planned ones are looked at by Allocation,
	F - Firm. Ready to be Picked';


--
-- Name: COLUMN wh_facility_trans_onhand.rqst_dt; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.wh_facility_trans_onhand.rqst_dt IS 'The date the customer requests the item to be shipped.';


--
-- Name: COLUMN wh_facility_trans_onhand.lot_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.wh_facility_trans_onhand.lot_nbr IS 'The lot which was shipped, a foreign key back to the primary surrogate key in ic_lot_mast.';


--
-- Name: COLUMN wh_facility_trans_onhand.ut_user_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.wh_facility_trans_onhand.ut_user_nbr IS 'Surrogate primary key for UT_USER';


--
-- Name: wh_facility_trans_replen; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.wh_facility_trans_replen (
    wh_facility_trans_replen_nbr integer NOT NULL,
    rqst_stat_id character varying(1) NOT NULL,
    po_line_dtl_nbr integer NOT NULL,
    facility_dest character varying(16) NOT NULL,
    aps_sply_sub_pool_nbr_dest integer NOT NULL,
    qty_rqst numeric(13,5) NOT NULL,
    rqst_dt timestamp without time zone NOT NULL,
    ut_user_nbr_rqst integer NOT NULL,
    ut_user_nbr_confirm integer,
    ut_user_nbr integer NOT NULL,
    last_mod_dt timestamp without time zone NOT NULL,
    CONSTRAINT wftr_check_rqst_stat_id CHECK (((rqst_stat_id)::text = ANY (ARRAY[('R'::character varying)::text, ('P'::character varying)::text])))
);


ALTER TABLE aerodemo.wh_facility_trans_replen OWNER TO jjs;

--
-- Name: COLUMN wh_facility_trans_replen.rqst_stat_id; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.wh_facility_trans_replen.rqst_stat_id IS 'R - Requested,
 P - Planned. Only the Planned ones are converted into On-hand Requests
 upon receipt of the PO';


--
-- Name: COLUMN wh_facility_trans_replen.rqst_dt; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.wh_facility_trans_replen.rqst_dt IS 'The date the customer requests the item to be shipped.';


--
-- Name: COLUMN wh_facility_trans_replen.ut_user_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.wh_facility_trans_replen.ut_user_nbr IS 'Surrogate primary key for UT_USER';


--
-- Name: wh_facility_trans_ship_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.wh_facility_trans_ship_nbr_seq
    START WITH 29359
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.wh_facility_trans_ship_nbr_seq OWNER TO jjs;

--
-- Name: wh_pack_box_cd_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.wh_pack_box_cd_seq
    START WITH 286310
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.wh_pack_box_cd_seq OWNER TO jjs;

--
-- Name: wh_pick_batch_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.wh_pick_batch_nbr_seq
    START WITH 274886
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.wh_pick_batch_nbr_seq OWNER TO jjs;

--
-- Name: wh_pick_dtl_cop_rqst; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.wh_pick_dtl_cop_rqst (
    wh_pick_dtl_cop_rqst_nbr integer NOT NULL,
    wh_pick_batch_cop_nbr integer NOT NULL,
    ic_item_loc_nbr integer,
    box_cd character varying(20) NOT NULL,
    cop_pick_qty_rqst numeric(13,5) NOT NULL,
    cop_pick_qty_act numeric(13,5),
    oe_ord_dtl_nbr integer NOT NULL,
    aps_alloc_onhand_oo_nbr integer,
    wh_pick_dtl_cop_rqst_nbr_src integer,
    box_cnt integer,
    box_cd_dest character varying(20),
    pick_scan_cd character varying(20)
);


ALTER TABLE aerodemo.wh_pick_dtl_cop_rqst OWNER TO jjs;

--
-- Name: COLUMN wh_pick_dtl_cop_rqst.oe_ord_dtl_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.wh_pick_dtl_cop_rqst.oe_ord_dtl_nbr IS 'A foreign key back to the order detail.';


--
-- Name: wh_pick_dtl_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.wh_pick_dtl_nbr_seq
    START WITH 4207188
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.wh_pick_dtl_nbr_seq OWNER TO jjs;

--
-- Name: wh_pick_dtl_trans_rqst; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.wh_pick_dtl_trans_rqst (
    wh_pick_dtl_trans_rqst_nbr integer NOT NULL,
    wh_pick_batch_trans_nbr integer NOT NULL,
    ic_item_loc_nbr integer,
    box_cd character varying(20),
    trans_pick_qty_rqst numeric(13,5) NOT NULL,
    trans_pick_qty_act numeric(13,5),
    wh_facility_trans_onhand_nbr integer NOT NULL,
    wh_pick_dtl_trans_rqst_nbr_src integer,
    box_cd_dest character varying(20),
    box_cnt integer,
    pick_scan_cd character varying(20)
);


ALTER TABLE aerodemo.wh_pick_dtl_trans_rqst OWNER TO jjs;

--
-- Name: wh_pick_dtl_wo_rqst; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.wh_pick_dtl_wo_rqst (
    wh_pick_dtl_wo_rqst_nbr integer NOT NULL,
    wh_pick_batch_wo_nbr integer NOT NULL,
    ic_item_loc_nbr integer,
    wo_pick_qty_rqst numeric(13,5) NOT NULL,
    wo_dtl_nbr integer NOT NULL,
    wo_release_nbr integer NOT NULL,
    aps_alloc_onhand_wo_nbr integer,
    box_cd character varying(20),
    wo_pick_qty_act numeric(13,5),
    wh_pick_dtl_wo_rqst_nbr_src integer,
    pick_scan_cd character varying(20),
    box_cnt integer,
    box_cd_dest character varying(20)
);


ALTER TABLE aerodemo.wh_pick_dtl_wo_rqst OWNER TO jjs;

--
-- Name: wh_whse_zone_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.wh_whse_zone_nbr_seq
    START WITH 261
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.wh_whse_zone_nbr_seq OWNER TO jjs;

--
-- Name: wo_dtl_cert; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.wo_dtl_cert (
    wo_dtl_nbr integer NOT NULL,
    cert_cd character varying(8) NOT NULL
);


ALTER TABLE aerodemo.wo_dtl_cert OWNER TO jjs;

--
-- Name: wo_dtl_mfg_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.wo_dtl_mfg_nbr_seq
    START WITH 16441
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.wo_dtl_mfg_nbr_seq OWNER TO jjs;

--
-- Name: wo_dtl_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.wo_dtl_nbr_seq
    START WITH 446095
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.wo_dtl_nbr_seq OWNER TO jjs;

--
-- Name: wo_hdr_cert; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.wo_hdr_cert (
    wo_hdr_nbr integer NOT NULL,
    cert_cd character varying(8) NOT NULL,
    ut_user_nbr integer NOT NULL,
    last_mod_dt timestamp without time zone NOT NULL
);


ALTER TABLE aerodemo.wo_hdr_cert OWNER TO jjs;

--
-- Name: wo_hdr_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.wo_hdr_nbr_seq
    START WITH 52303
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.wo_hdr_nbr_seq OWNER TO jjs;

--
-- Name: wo_release; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.wo_release (
    wo_release_nbr integer NOT NULL,
    wo_hdr_nbr integer NOT NULL,
    qty_release integer NOT NULL,
    release_stat_id character varying(1) NOT NULL,
    qty_fill integer,
    ut_user_nbr integer NOT NULL,
    last_mod_dt timestamp without time zone NOT NULL,
    release_fill_dt timestamp without time zone NOT NULL
);


ALTER TABLE aerodemo.wo_release OWNER TO jjs;

--
-- Name: COLUMN wo_release.wo_release_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.wo_release.wo_release_nbr IS 'Surrogate primary key for WO_RELEASE_NBR';


--
-- Name: COLUMN wo_release.wo_hdr_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.wo_release.wo_hdr_nbr IS 'The surrogate primary key for WO_HDR.';


--
-- Name: COLUMN wo_release.ut_user_nbr; Type: COMMENT; Schema: aerodemo; Owner: jjs
--

COMMENT ON COLUMN aerodemo.wo_release.ut_user_nbr IS 'Surrogate primary key for UT_USER';


--
-- Name: wo_release_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.wo_release_nbr_seq
    START WITH 37285
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.wo_release_nbr_seq OWNER TO jjs;

--
-- Name: wo_unit_nbr_seq; Type: SEQUENCE; Schema: aerodemo; Owner: jjs
--

CREATE SEQUENCE aerodemo.wo_unit_nbr_seq
    START WITH 121164
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 20;


ALTER TABLE aerodemo.wo_unit_nbr_seq OWNER TO jjs;

--
-- Name: xx; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.xx (
    xy character varying(1),
    zx character varying(1)
);


ALTER TABLE aerodemo.xx OWNER TO jjs;

--
-- Name: z; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.z (
    item_nbr integer
);


ALTER TABLE aerodemo.z OWNER TO jjs;

--
-- Name: zz_item_nbr; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.zz_item_nbr (
    item_nbr integer NOT NULL
);


ALTER TABLE aerodemo.zz_item_nbr OWNER TO jjs;

--
-- Name: zz_row_count; Type: TABLE; Schema: aerodemo; Owner: jjs
--

CREATE TABLE aerodemo.zz_row_count (
    table_name character varying(64),
    row_count integer
);


ALTER TABLE aerodemo.zz_row_count OWNER TO jjs;

--
-- Name: app_ctl app_ctl_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.app_ctl
    ADD CONSTRAINT app_ctl_pkey PRIMARY KEY (property_nm);


--
-- Name: aps_alloc_oh_fc aps_alloc_oh_fc_aps_alloc_oh_fc_nbr_key; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.aps_alloc_oh_fc
    ADD CONSTRAINT aps_alloc_oh_fc_aps_alloc_oh_fc_nbr_key UNIQUE (aps_alloc_oh_fc_nbr);


--
-- Name: aps_alloc_oh_fc aps_alloc_oh_fc_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.aps_alloc_oh_fc
    ADD CONSTRAINT aps_alloc_oh_fc_pkey PRIMARY KEY (item_nbr, aps_alloc_oh_fc_nbr);


--
-- Name: aps_alloc_oh_oo aps_alloc_oh_oo_aps_alloc_oh_oo_nbr_key; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.aps_alloc_oh_oo
    ADD CONSTRAINT aps_alloc_oh_oo_aps_alloc_oh_oo_nbr_key UNIQUE (aps_alloc_oh_oo_nbr);


--
-- Name: aps_alloc_oh_oo aps_alloc_oh_oo_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.aps_alloc_oh_oo
    ADD CONSTRAINT aps_alloc_oh_oo_pkey PRIMARY KEY (item_nbr, aps_alloc_oh_oo_nbr);


--
-- Name: aps_alloc_onhand_fc aps_alloc_onhand_fc_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.aps_alloc_onhand_fc
    ADD CONSTRAINT aps_alloc_onhand_fc_pkey PRIMARY KEY (item_nbr_rqst, aps_alloc_onhand_fc_nbr);


--
-- Name: aps_alloc_onhand_oo aps_alloc_onhand_oo_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.aps_alloc_onhand_oo
    ADD CONSTRAINT aps_alloc_onhand_oo_pkey PRIMARY KEY (item_nbr_rqst, aps_alloc_onhand_oo_nbr);


--
-- Name: aps_alloc_onhand_ss aps_alloc_onhand_ss_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.aps_alloc_onhand_ss
    ADD CONSTRAINT aps_alloc_onhand_ss_pkey PRIMARY KEY (item_nbr_rqst, aps_alloc_onhand_ss_nbr);


--
-- Name: aps_alloc_onhand_wo aps_alloc_onhand_wo_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.aps_alloc_onhand_wo
    ADD CONSTRAINT aps_alloc_onhand_wo_pkey PRIMARY KEY (item_nbr_rqst, aps_alloc_onhand_wo_nbr);


--
-- Name: aps_alloc_po_ss aps_alloc_po_ss_aps_alloc_po_ss_nbr_key; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.aps_alloc_po_ss
    ADD CONSTRAINT aps_alloc_po_ss_aps_alloc_po_ss_nbr_key UNIQUE (aps_alloc_po_ss_nbr);


--
-- Name: aps_alloc_po_ss aps_alloc_po_ss_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.aps_alloc_po_ss
    ADD CONSTRAINT aps_alloc_po_ss_pkey PRIMARY KEY (item_nbr, aps_alloc_po_ss_nbr);


--
-- Name: aps_alloc_replen_fc aps_alloc_replen_fc_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.aps_alloc_replen_fc
    ADD CONSTRAINT aps_alloc_replen_fc_pkey PRIMARY KEY (item_nbr_rqst, aps_alloc_replen_fc_nbr);


--
-- Name: aps_alloc_replen_oo aps_alloc_replen_oo_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.aps_alloc_replen_oo
    ADD CONSTRAINT aps_alloc_replen_oo_pkey PRIMARY KEY (item_nbr_rqst, aps_alloc_replen_oo_nbr);


--
-- Name: aps_alloc_replen_ss aps_alloc_replen_ss_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.aps_alloc_replen_ss
    ADD CONSTRAINT aps_alloc_replen_ss_pkey PRIMARY KEY (item_nbr_rqst, aps_alloc_replen_ss_nbr);


--
-- Name: aps_alloc_replen_wo aps_alloc_replen_wo_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.aps_alloc_replen_wo
    ADD CONSTRAINT aps_alloc_replen_wo_pkey PRIMARY KEY (item_nbr_rqst, aps_alloc_replen_wo_nbr);


--
-- Name: aps_alloc_wo_fc aps_alloc_wo_fc_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.aps_alloc_wo_fc
    ADD CONSTRAINT aps_alloc_wo_fc_pkey PRIMARY KEY (item_nbr_rqst, aps_alloc_wo_fc_nbr);


--
-- Name: aps_alloc_wo_oo aps_alloc_wo_oo_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.aps_alloc_wo_oo
    ADD CONSTRAINT aps_alloc_wo_oo_pkey PRIMARY KEY (item_nbr_rqst, aps_alloc_wo_oo_nbr);


--
-- Name: aps_alloc_wo_ss aps_alloc_wo_ss_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.aps_alloc_wo_ss
    ADD CONSTRAINT aps_alloc_wo_ss_pkey PRIMARY KEY (item_nbr_rqst, aps_alloc_wo_ss_nbr);


--
-- Name: aps_alloc_wo_wo aps_alloc_wo_wo_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.aps_alloc_wo_wo
    ADD CONSTRAINT aps_alloc_wo_wo_pkey PRIMARY KEY (item_nbr_rqst, aps_alloc_wo_wo_nbr);


--
-- Name: aps_dispatch_queue aps_dispatch_queue_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.aps_dispatch_queue
    ADD CONSTRAINT aps_dispatch_queue_pkey PRIMARY KEY (item_nbr);


--
-- Name: aps_ideal_global_replen aps_ideal_global_replen_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.aps_ideal_global_replen
    ADD CONSTRAINT aps_ideal_global_replen_pkey PRIMARY KEY (item_nbr, replen_dt);


--
-- Name: aps_item_global_subst aps_item_global_subst_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.aps_item_global_subst
    ADD CONSTRAINT aps_item_global_subst_pkey PRIMARY KEY (item_nbr, item_nbr_subst);


--
-- Name: aps_item_log aps_item_log_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.aps_item_log
    ADD CONSTRAINT aps_item_log_pkey PRIMARY KEY (item_nbr);


--
-- Name: aps_item_replen_policy aps_item_replen_policy_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.aps_item_replen_policy
    ADD CONSTRAINT aps_item_replen_policy_pkey PRIMARY KEY (item_nbr, facility);


--
-- Name: aps_plan_grp aps_plan_grp_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.aps_plan_grp
    ADD CONSTRAINT aps_plan_grp_pkey PRIMARY KEY (item_nbr);


--
-- Name: aps_result_dtl_dmd aps_result_dtl_dmd_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.aps_result_dtl_dmd
    ADD CONSTRAINT aps_result_dtl_dmd_pkey PRIMARY KEY (aps_result_dtl_dmd_nbr);


--
-- Name: aps_sply_pool aps_sply_pool_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.aps_sply_pool
    ADD CONSTRAINT aps_sply_pool_pkey PRIMARY KEY (aps_sply_pool_cd);


--
-- Name: aps_sply_sub_pool aps_sply_sub_pool_aps_sply_pool_cd_aps_sply_sub_pool_cd_key; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.aps_sply_sub_pool
    ADD CONSTRAINT aps_sply_sub_pool_aps_sply_pool_cd_aps_sply_sub_pool_cd_key UNIQUE (aps_sply_pool_cd, aps_sply_sub_pool_cd);


--
-- Name: aps_sply_sub_pool aps_sply_sub_pool_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.aps_sply_sub_pool
    ADD CONSTRAINT aps_sply_sub_pool_pkey PRIMARY KEY (aps_sply_sub_pool_nbr);


--
-- Name: aps_src_rule aps_src_rule_aps_src_rule_set_nbr_aps_sply_sub_pool_nbr_fac_key; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.aps_src_rule
    ADD CONSTRAINT aps_src_rule_aps_src_rule_set_nbr_aps_sply_sub_pool_nbr_fac_key UNIQUE (aps_src_rule_set_nbr, aps_sply_sub_pool_nbr, facility, sply_type_id);


--
-- Name: aps_src_rule aps_src_rule_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.aps_src_rule
    ADD CONSTRAINT aps_src_rule_pkey PRIMARY KEY (aps_src_rule_nbr);


--
-- Name: aps_src_rule_primary aps_src_rule_primary_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.aps_src_rule_primary
    ADD CONSTRAINT aps_src_rule_primary_pkey PRIMARY KEY (aps_src_rule_set_nbr);


--
-- Name: aps_src_rule_set aps_src_rule_set_aps_src_rule_set_cd_key; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.aps_src_rule_set
    ADD CONSTRAINT aps_src_rule_set_aps_src_rule_set_cd_key UNIQUE (aps_src_rule_set_cd);


--
-- Name: aps_src_rule_set aps_src_rule_set_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.aps_src_rule_set
    ADD CONSTRAINT aps_src_rule_set_pkey PRIMARY KEY (aps_src_rule_set_nbr);


--
-- Name: ar_inv_dtl ar_inv_dtl_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ar_inv_dtl
    ADD CONSTRAINT ar_inv_dtl_pkey PRIMARY KEY (ar_inv_dtl_nbr);


--
-- Name: ar_inv_hdr ar_inv_hdr_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ar_inv_hdr
    ADD CONSTRAINT ar_inv_hdr_pkey PRIMARY KEY (inv_cd);


--
-- Name: ar_rma_dtl ar_rma_dtl_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ar_rma_dtl
    ADD CONSTRAINT ar_rma_dtl_pkey PRIMARY KEY (ar_rma_dtl_nbr);


--
-- Name: ar_rma_rcpt ar_rma_rcpt_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ar_rma_rcpt
    ADD CONSTRAINT ar_rma_rcpt_pkey PRIMARY KEY (ar_rma_rcpt_nbr);


--
-- Name: cal_calendar cal_calendar_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.cal_calendar
    ADD CONSTRAINT cal_calendar_pkey PRIMARY KEY (calendar);


--
-- Name: cal_dt cal_dt_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.cal_dt
    ADD CONSTRAINT cal_dt_pkey PRIMARY KEY (calendar, cal_dt);


--
-- Name: currency currency_pk; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.currency
    ADD CONSTRAINT currency_pk PRIMARY KEY (curr_cd);


--
-- Name: databasechangeloglock databasechangeloglock_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.databasechangeloglock
    ADD CONSTRAINT databasechangeloglock_pkey PRIMARY KEY (id);


--
-- Name: debug_table debug_table_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.debug_table
    ADD CONSTRAINT debug_table_pkey PRIMARY KEY (debug_nbr);


--
-- Name: fc_adj fc_adj_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.fc_adj
    ADD CONSTRAINT fc_adj_pkey PRIMARY KEY (fc_adj_nbr);


--
-- Name: fc_aggr_mast_attr fc_aggr_mast_attr_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.fc_aggr_mast_attr
    ADD CONSTRAINT fc_aggr_mast_attr_pkey PRIMARY KEY (fc_aggr_mast_nbr, ic_attr_nbr);


--
-- Name: fc_aggr_mast_dtl fc_aggr_mast_dtl_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.fc_aggr_mast_dtl
    ADD CONSTRAINT fc_aggr_mast_dtl_pkey PRIMARY KEY (fc_aggr_mast_nbr, fc_item_mast_nbr);


--
-- Name: fc_aggr_mast fc_aggr_mast_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.fc_aggr_mast
    ADD CONSTRAINT fc_aggr_mast_pkey PRIMARY KEY (fc_aggr_mast_nbr);


--
-- Name: fc_attr fc_attr_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.fc_attr
    ADD CONSTRAINT fc_attr_pkey PRIMARY KEY (fc_attr_nbr);


--
-- Name: fc_attr_val fc_attr_val_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.fc_attr_val
    ADD CONSTRAINT fc_attr_val_pkey PRIMARY KEY (fc_attr_nbr, attr_val);


--
-- Name: fc_build_rate_grp fc_build_rate_grp_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.fc_build_rate_grp
    ADD CONSTRAINT fc_build_rate_grp_pkey PRIMARY KEY (fc_build_rate_grp_cd);


--
-- Name: fc_build_rate fc_build_rate_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.fc_build_rate
    ADD CONSTRAINT fc_build_rate_pkey PRIMARY KEY (fc_build_rate_grp_cd, build_rate_eff_dt);


--
-- Name: fc_dtl_tmp fc_dtl_tmp_fc_item_mast_nbr_key; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.fc_dtl_tmp
    ADD CONSTRAINT fc_dtl_tmp_fc_item_mast_nbr_key UNIQUE (fc_item_mast_nbr);


--
-- Name: fc_dtl_tmp fc_dtl_tmp_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.fc_dtl_tmp
    ADD CONSTRAINT fc_dtl_tmp_pkey PRIMARY KEY (user_fld_1, user_fld_2, user_fld_3);


--
-- Name: fc_fcst_aggr fc_fcst_aggr_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.fc_fcst_aggr
    ADD CONSTRAINT fc_fcst_aggr_pkey PRIMARY KEY (fc_aggr_mast_nbr, fc_fcst_dt);


--
-- Name: fc_fcst fc_fcst_fc_item_mast_nbr_cycle_intvl_key; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.fc_fcst
    ADD CONSTRAINT fc_fcst_fc_item_mast_nbr_cycle_intvl_key UNIQUE (fc_item_mast_nbr, cycle, intvl);


--
-- Name: fc_fcst_mdl_grp_hdr fc_fcst_mdl_grp_hdr_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.fc_fcst_mdl_grp_hdr
    ADD CONSTRAINT fc_fcst_mdl_grp_hdr_pkey PRIMARY KEY (fcst_mdl_grp);


--
-- Name: fc_fcst_mdl_grp fc_fcst_mdl_grp_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.fc_fcst_mdl_grp
    ADD CONSTRAINT fc_fcst_mdl_grp_pkey PRIMARY KEY (fcst_mdl_grp, fcst_mdl_nbr);


--
-- Name: fc_fcst_mdl fc_fcst_mdl_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.fc_fcst_mdl
    ADD CONSTRAINT fc_fcst_mdl_pkey PRIMARY KEY (fc_fcst_mdl_nbr);


--
-- Name: fc_fcst fc_fcst_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.fc_fcst
    ADD CONSTRAINT fc_fcst_pkey PRIMARY KEY (fc_fcst_nbr);


--
-- Name: fc_fcst_prd fc_fcst_prd_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.fc_fcst_prd
    ADD CONSTRAINT fc_fcst_prd_pkey PRIMARY KEY (fc_item_mast_nbr, fc_fcst_dt);


--
-- Name: fc_hdr_tmp fc_hdr_tmp_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.fc_hdr_tmp
    ADD CONSTRAINT fc_hdr_tmp_pkey PRIMARY KEY (user_fld_1, user_fld_2);


--
-- Name: fc_hist fc_hist_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.fc_hist
    ADD CONSTRAINT fc_hist_pkey PRIMARY KEY (fc_item_mast_nbr, dmd_dt);


--
-- Name: fc_item_attr fc_item_attr_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.fc_item_attr
    ADD CONSTRAINT fc_item_attr_pkey PRIMARY KEY (fc_item_mast_nbr, fc_attr_nbr);


--
-- Name: fc_item_dflt fc_item_dflt_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.fc_item_dflt
    ADD CONSTRAINT fc_item_dflt_pkey PRIMARY KEY (fc_item_dflt_nbr);


--
-- Name: fc_item_fcst_mdl fc_item_fcst_mdl_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.fc_item_fcst_mdl
    ADD CONSTRAINT fc_item_fcst_mdl_pkey PRIMARY KEY (fc_item_fcst_mdl_nbr);


--
-- Name: fc_item_mast_dtl fc_item_mast_dtl_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.fc_item_mast_dtl
    ADD CONSTRAINT fc_item_mast_dtl_pkey PRIMARY KEY (fc_item_mast_nbr_src, fc_item_mast_nbr);


--
-- Name: fc_item_mast fc_item_mast_item_nbr_fcst_grp_org_nbr_cust_aps_src_rule_se_key; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.fc_item_mast
    ADD CONSTRAINT fc_item_mast_item_nbr_fcst_grp_org_nbr_cust_aps_src_rule_se_key UNIQUE (item_nbr, fcst_grp, org_nbr_cust, aps_src_rule_set_nbr);


--
-- Name: fc_item_mast fc_item_mast_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.fc_item_mast
    ADD CONSTRAINT fc_item_mast_pkey PRIMARY KEY (fc_item_mast_nbr);


--
-- Name: fc_queue fc_queue_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.fc_queue
    ADD CONSTRAINT fc_queue_pkey PRIMARY KEY (fc_item_mast_nbr);


--
-- Name: fcst_grp fcst_grp_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.fcst_grp
    ADD CONSTRAINT fcst_grp_pkey PRIMARY KEY (fcst_grp);


--
-- Name: ic_attr ic_attr_attr_nm_key; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_attr
    ADD CONSTRAINT ic_attr_attr_nm_key UNIQUE (attr_nm);


--
-- Name: ic_attr ic_attr_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_attr
    ADD CONSTRAINT ic_attr_pkey PRIMARY KEY (ic_attr_nbr);


--
-- Name: ic_attr_val ic_attr_val_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_attr_val
    ADD CONSTRAINT ic_attr_val_pkey PRIMARY KEY (ic_attr_nbr, attr_val);


--
-- Name: ic_bin ic_bin_bin_cd_facility_key; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_bin
    ADD CONSTRAINT ic_bin_bin_cd_facility_key UNIQUE (bin_cd, facility);


--
-- Name: ic_bin ic_bin_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_bin
    ADD CONSTRAINT ic_bin_pkey PRIMARY KEY (bin_nbr);


--
-- Name: ic_bom_cert ic_bom_cert_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_bom_cert
    ADD CONSTRAINT ic_bom_cert_pkey PRIMARY KEY (item_nbr, item_nbr_parent, cert_cd);


--
-- Name: ic_bom ic_bom_item_nbr_item_nbr_parent_key; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_bom
    ADD CONSTRAINT ic_bom_item_nbr_item_nbr_parent_key UNIQUE (item_nbr, item_nbr_parent);


--
-- Name: ic_category ic_category_ic_category_nm_key; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_category
    ADD CONSTRAINT ic_category_ic_category_nm_key UNIQUE (ic_category_nm);


--
-- Name: ic_category ic_category_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_category
    ADD CONSTRAINT ic_category_pkey PRIMARY KEY (ic_category_nbr);


--
-- Name: ic_cert_cd ic_cert_cd_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_cert_cd
    ADD CONSTRAINT ic_cert_cd_pkey PRIMARY KEY (cert_cd);


--
-- Name: ic_item_attr ic_item_attr_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_item_attr
    ADD CONSTRAINT ic_item_attr_pkey PRIMARY KEY (item_nbr, ic_attr_nbr);


--
-- Name: ic_item_cost ic_item_cost_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_item_cost
    ADD CONSTRAINT ic_item_cost_pkey PRIMARY KEY (item_nbr, cost_type_cd);


--
-- Name: ic_item_cust_subst ic_item_cust_subst_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_item_cust_subst
    ADD CONSTRAINT ic_item_cust_subst_pkey PRIMARY KEY (item_nbr, org_nbr_cust, item_nbr_subst);


--
-- Name: ic_item_loc_box ic_item_loc_box_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_item_loc_box
    ADD CONSTRAINT ic_item_loc_box_pkey PRIMARY KEY (box_cd);


--
-- Name: ic_item_loc ic_item_loc_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_item_loc
    ADD CONSTRAINT ic_item_loc_pkey PRIMARY KEY (ic_item_loc_nbr);


--
-- Name: ic_item_mast_cert ic_item_mast_cert_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_item_mast_cert
    ADD CONSTRAINT ic_item_mast_cert_pkey PRIMARY KEY (item_nbr, cert_cd);


--
-- Name: ic_item_mast_equiv ic_item_mast_equiv_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_item_mast_equiv
    ADD CONSTRAINT ic_item_mast_equiv_pkey PRIMARY KEY (item_nbr, item_nbr_equiv);


--
-- Name: ic_item_mast_equiv_ref ic_item_mast_equiv_ref_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_item_mast_equiv_ref
    ADD CONSTRAINT ic_item_mast_equiv_ref_pkey PRIMARY KEY (item_nbr, item_nbr_equiv);


--
-- Name: ic_item_mast ic_item_mast_item_cd_key; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_item_mast
    ADD CONSTRAINT ic_item_mast_item_cd_key UNIQUE (item_cd);


--
-- Name: ic_item_mast_nomen ic_item_mast_nomen_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_item_mast_nomen
    ADD CONSTRAINT ic_item_mast_nomen_pkey PRIMARY KEY (item_nbr, org_nbr_nomen, item_cd_nomen);


--
-- Name: ic_item_mast ic_item_mast_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_item_mast
    ADD CONSTRAINT ic_item_mast_pkey PRIMARY KEY (item_nbr);


--
-- Name: ic_item_mast_rel ic_item_mast_rel_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_item_mast_rel
    ADD CONSTRAINT ic_item_mast_rel_pkey PRIMARY KEY (item_nbr, item_nbr_rel);


--
-- Name: ic_item_mast_upd_queue ic_item_mast_upd_queue_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_item_mast_upd_queue
    ADD CONSTRAINT ic_item_mast_upd_queue_pkey PRIMARY KEY (item_nbr);


--
-- Name: ic_item_mfg_path ic_item_mfg_path_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_item_mfg_path
    ADD CONSTRAINT ic_item_mfg_path_pkey PRIMARY KEY (item_nbr);


--
-- Name: ic_item_narr ic_item_narr_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_item_narr
    ADD CONSTRAINT ic_item_narr_pkey PRIMARY KEY (item_nbr);


--
-- Name: ic_item_operation_yield ic_item_operation_yield_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_item_operation_yield
    ADD CONSTRAINT ic_item_operation_yield_pkey PRIMARY KEY (item_nbr, operation_cd);


--
-- Name: ic_item_price_matrix ic_item_price_matrix_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_item_price_matrix
    ADD CONSTRAINT ic_item_price_matrix_pkey PRIMARY KEY (item_nbr, qty_ord, curr_cd);


--
-- Name: ic_item_restrict_cust ic_item_restrict_cust_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_item_restrict_cust
    ADD CONSTRAINT ic_item_restrict_cust_pkey PRIMARY KEY (item_nbr, org_nbr_cust);


--
-- Name: ic_item_rev_lvl_apply ic_item_rev_lvl_apply_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_item_rev_lvl_apply
    ADD CONSTRAINT ic_item_rev_lvl_apply_pkey PRIMARY KEY (item_nbr, rev_lvl, rev_lvl_apply);


--
-- Name: ic_item_rev_lvl ic_item_rev_lvl_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_item_rev_lvl
    ADD CONSTRAINT ic_item_rev_lvl_pkey PRIMARY KEY (item_nbr, rev_lvl);


--
-- Name: ic_item_stat ic_item_stat_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_item_stat
    ADD CONSTRAINT ic_item_stat_pkey PRIMARY KEY (item_nbr);


--
-- Name: ic_item_vnd_cost_matrix ic_item_vnd_cost_matrix_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_item_vnd_cost_matrix
    ADD CONSTRAINT ic_item_vnd_cost_matrix_pkey PRIMARY KEY (item_nbr, org_nbr_vnd, qty_ord, unit_cost_curr_cd);


--
-- Name: ic_kit_mast ic_kit_mast_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_kit_mast
    ADD CONSTRAINT ic_kit_mast_pkey PRIMARY KEY (item_nbr);


--
-- Name: ic_lot_image ic_lot_image_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_lot_image
    ADD CONSTRAINT ic_lot_image_pkey PRIMARY KEY (lot_nbr, cert_cd, img_image_set_hdr_nbr);


--
-- Name: ic_lot_mast_cert ic_lot_mast_cert_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_lot_mast_cert
    ADD CONSTRAINT ic_lot_mast_cert_pkey PRIMARY KEY (lot_nbr, cert_cd);


--
-- Name: ic_lot_mast ic_lot_mast_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_lot_mast
    ADD CONSTRAINT ic_lot_mast_pkey PRIMARY KEY (lot_nbr);


--
-- Name: ic_multiple_cert ic_multiple_cert_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_multiple_cert
    ADD CONSTRAINT ic_multiple_cert_pkey PRIMARY KEY (lot_nbr, item_nbr);


--
-- Name: ic_um_cnvt_item ic_um_cnvt_item_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_um_cnvt_item
    ADD CONSTRAINT ic_um_cnvt_item_pkey PRIMARY KEY (item_nbr, um_id_from, um_id_to);


--
-- Name: ic_um_cnvt ic_um_cnvt_pk; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_um_cnvt
    ADD CONSTRAINT ic_um_cnvt_pk PRIMARY KEY (um_id_from, um_id_to);


--
-- Name: ic_um ic_um_pk; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_um
    ADD CONSTRAINT ic_um_pk PRIMARY KEY (um_id);


--
-- Name: ic_vnd_onhand ic_vnd_onhand_item_cd_vnd_org_nbr_vnd_load_dt_key; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_vnd_onhand
    ADD CONSTRAINT ic_vnd_onhand_item_cd_vnd_org_nbr_vnd_load_dt_key UNIQUE (item_cd_vnd, org_nbr_vnd, load_dt);


--
-- Name: ic_vnd_onhand ic_vnd_onhand_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_vnd_onhand
    ADD CONSTRAINT ic_vnd_onhand_pkey PRIMARY KEY (ic_vnd_onhand_nbr);


--
-- Name: img_image img_image_pk; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.img_image
    ADD CONSTRAINT img_image_pk PRIMARY KEY (img_image_nbr);


--
-- Name: img_image_set_dtl img_image_set_dtl_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.img_image_set_dtl
    ADD CONSTRAINT img_image_set_dtl_pkey PRIMARY KEY (img_image_set_hdr_nbr, img_image_nbr);


--
-- Name: img_image_set_hdr img_image_set_hdr_pk; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.img_image_set_hdr
    ADD CONSTRAINT img_image_set_hdr_pk PRIMARY KEY (img_image_set_hdr_nbr);


--
-- Name: img_scan_batch img_scan_batch_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.img_scan_batch
    ADD CONSTRAINT img_scan_batch_pkey PRIMARY KEY (img_scan_batch_nbr);


--
-- Name: jhi_authority jhi_authority_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.jhi_authority
    ADD CONSTRAINT jhi_authority_pkey PRIMARY KEY (name);


--
-- Name: jhi_persistent_audit_event jhi_persistent_audit_event_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.jhi_persistent_audit_event
    ADD CONSTRAINT jhi_persistent_audit_event_pkey PRIMARY KEY (event_id);


--
-- Name: jhi_user_authority jhi_user_authority_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.jhi_user_authority
    ADD CONSTRAINT jhi_user_authority_pkey PRIMARY KEY (user_id, authority_name);


--
-- Name: jhi_user jhi_user_email_key; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.jhi_user
    ADD CONSTRAINT jhi_user_email_key UNIQUE (email);


--
-- Name: jhi_user jhi_user_login_key; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.jhi_user
    ADD CONSTRAINT jhi_user_login_key UNIQUE (login);


--
-- Name: jhi_user jhi_user_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.jhi_user
    ADD CONSTRAINT jhi_user_pkey PRIMARY KEY (id);


--
-- Name: job_log job_log_pk; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.job_log
    ADD CONSTRAINT job_log_pk PRIMARY KEY (job_log_id);


--
-- Name: job_log job_log_token_uq; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.job_log
    ADD CONSTRAINT job_log_token_uq UNIQUE (job_token);


--
-- Name: job_msg job_msg_pk; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.job_msg
    ADD CONSTRAINT job_msg_pk PRIMARY KEY (job_log_id, log_seq_nbr);


--
-- Name: job_step job_step_pk; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.job_step
    ADD CONSTRAINT job_step_pk PRIMARY KEY (job_step_id);


--
-- Name: job_step_tracefile_json job_step_tracefile_json_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.job_step_tracefile_json
    ADD CONSTRAINT job_step_tracefile_json_pkey PRIMARY KEY (job_step_id);


--
-- Name: job_step_tracefile job_step_tracefile_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.job_step_tracefile
    ADD CONSTRAINT job_step_tracefile_pkey PRIMARY KEY (job_step_id);


--
-- Name: na_indiv na_indiv_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.na_indiv
    ADD CONSTRAINT na_indiv_pkey PRIMARY KEY (indiv_nbr);


--
-- Name: na_org_addr na_org_addr_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.na_org_addr
    ADD CONSTRAINT na_org_addr_pkey PRIMARY KEY (addr_nbr);


--
-- Name: na_org_indiv na_org_indiv_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.na_org_indiv
    ADD CONSTRAINT na_org_indiv_pkey PRIMARY KEY (org_nbr, indiv_nbr);


--
-- Name: na_org na_org_org_cd_key; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.na_org
    ADD CONSTRAINT na_org_org_cd_key UNIQUE (org_cd);


--
-- Name: na_org na_org_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.na_org
    ADD CONSTRAINT na_org_pkey PRIMARY KEY (org_nbr);


--
-- Name: oe_contract_item oe_contract_item_note_nbr_ref_key; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.oe_contract_item
    ADD CONSTRAINT oe_contract_item_note_nbr_ref_key UNIQUE (note_nbr_ref);


--
-- Name: oe_contract_item oe_contract_item_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.oe_contract_item
    ADD CONSTRAINT oe_contract_item_pkey PRIMARY KEY (item_cd_cust, contract_cd, org_nbr_cust);


--
-- Name: oe_cust_contract oe_cust_contract_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.oe_cust_contract
    ADD CONSTRAINT oe_cust_contract_pkey PRIMARY KEY (org_nbr_cust, contract_cd);


--
-- Name: oe_cust_mast_cert oe_cust_mast_cert_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.oe_cust_mast_cert
    ADD CONSTRAINT oe_cust_mast_cert_pkey PRIMARY KEY (org_nbr_cust, cert_cd);


--
-- Name: oe_cust_mast oe_cust_mast_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.oe_cust_mast
    ADD CONSTRAINT oe_cust_mast_pkey PRIMARY KEY (org_nbr_cust);


--
-- Name: oe_cust_mfr oe_cust_mfr_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.oe_cust_mfr
    ADD CONSTRAINT oe_cust_mfr_pkey PRIMARY KEY (item_nbr, org_nbr_cust, org_nbr_mfr);


--
-- Name: oe_ord_dtl_cert oe_ord_dtl_cert_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.oe_ord_dtl_cert
    ADD CONSTRAINT oe_ord_dtl_cert_pkey PRIMARY KEY (oe_ord_dtl_nbr, cert_cd);


--
-- Name: oe_ord_dtl_hist_fcst_grp oe_ord_dtl_hist_fcst_grp_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.oe_ord_dtl_hist_fcst_grp
    ADD CONSTRAINT oe_ord_dtl_hist_fcst_grp_pkey PRIMARY KEY (oe_ord_dtl_nbr);


--
-- Name: oe_ord_dtl oe_ord_dtl_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.oe_ord_dtl
    ADD CONSTRAINT oe_ord_dtl_pkey PRIMARY KEY (oe_ord_dtl_nbr);


--
-- Name: oe_ord_hdr oe_ord_hdr_ord_cd_key; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.oe_ord_hdr
    ADD CONSTRAINT oe_ord_hdr_ord_cd_key UNIQUE (ord_cd);


--
-- Name: oe_ord_hdr oe_ord_hdr_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.oe_ord_hdr
    ADD CONSTRAINT oe_ord_hdr_pkey PRIMARY KEY (oe_ord_hdr_nbr);


--
-- Name: plan_po plan_po_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.plan_po
    ADD CONSTRAINT plan_po_pkey PRIMARY KEY (plan_po_nbr);


--
-- Name: po_line_dtl po_line_dtl_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.po_line_dtl
    ADD CONSTRAINT po_line_dtl_pkey PRIMARY KEY (po_line_dtl_nbr);


--
-- Name: po_line_hdr_cert po_line_hdr_cert_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.po_line_hdr_cert
    ADD CONSTRAINT po_line_hdr_cert_pkey PRIMARY KEY (po_line_hdr_nbr, cert_cd);


--
-- Name: po_line_hdr po_line_hdr_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.po_line_hdr
    ADD CONSTRAINT po_line_hdr_pkey PRIMARY KEY (po_line_hdr_nbr);


--
-- Name: po_line_multiple_cert po_line_multiple_cert_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.po_line_multiple_cert
    ADD CONSTRAINT po_line_multiple_cert_pkey PRIMARY KEY (po_line_hdr_nbr, item_nbr);


--
-- Name: po_mfr_mast po_mfr_mast_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.po_mfr_mast
    ADD CONSTRAINT po_mfr_mast_pkey PRIMARY KEY (org_nbr_mfr);


--
-- Name: po_ord_hdr po_ord_hdr_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.po_ord_hdr
    ADD CONSTRAINT po_ord_hdr_pkey PRIMARY KEY (po_ord_hdr_nbr);


--
-- Name: po_ord_hdr po_ord_hdr_po_cd_key; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.po_ord_hdr
    ADD CONSTRAINT po_ord_hdr_po_cd_key UNIQUE (po_cd);


--
-- Name: po_requisition po_requisition_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.po_requisition
    ADD CONSTRAINT po_requisition_pkey PRIMARY KEY (item_nbr, facility, need_by_dt);


--
-- Name: po_unplanned_rcpt po_unplanned_rcpt_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.po_unplanned_rcpt
    ADD CONSTRAINT po_unplanned_rcpt_pkey PRIMARY KEY (po_unplanned_rcpt_nbr);


--
-- Name: po_vnd_mast po_vnd_mast_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.po_vnd_mast
    ADD CONSTRAINT po_vnd_mast_pkey PRIMARY KEY (org_nbr_vnd);


--
-- Name: po_vnd_set_hdr po_vnd_set_hdr_pk; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.po_vnd_set_hdr
    ADD CONSTRAINT po_vnd_set_hdr_pk PRIMARY KEY (po_vnd_set_hdr_nbr);


--
-- Name: pos_dtl pos_dtl_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.pos_dtl
    ADD CONSTRAINT pos_dtl_pkey PRIMARY KEY (pos_dtl_nbr);


--
-- Name: qa_cust_rtrn qa_cust_rtrn_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.qa_cust_rtrn
    ADD CONSTRAINT qa_cust_rtrn_pkey PRIMARY KEY (qa_cust_rtrn_nbr);


--
-- Name: qa_mfr_apprv qa_mfr_apprv_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.qa_mfr_apprv
    ADD CONSTRAINT qa_mfr_apprv_pkey PRIMARY KEY (qa_proj_cd, item_nbr, org_nbr_mfr, mfr_restrict_id);


--
-- Name: qa_tst_rslt qa_tst_rslt_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.qa_tst_rslt
    ADD CONSTRAINT qa_tst_rslt_pkey PRIMARY KEY (qa_tst_rslt_nbr);


--
-- Name: season_start_dates season_start_dates_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.season_start_dates
    ADD CONSTRAINT season_start_dates_pkey PRIMARY KEY (season);


--
-- Name: service_rqst_parms service_rqst_parms_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.service_rqst_parms
    ADD CONSTRAINT service_rqst_parms_pkey PRIMARY KEY (service_rqst_cd, parm_nm);


--
-- Name: service_rqst service_rqst_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.service_rqst
    ADD CONSTRAINT service_rqst_pkey PRIMARY KEY (service_rqst_cd);


--
-- Name: sq_qte_dtl sq_qte_dtl_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.sq_qte_dtl
    ADD CONSTRAINT sq_qte_dtl_pkey PRIMARY KEY (sq_qte_dtl_nbr);


--
-- Name: sq_qte_hdr sq_qte_hdr_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.sq_qte_hdr
    ADD CONSTRAINT sq_qte_hdr_pkey PRIMARY KEY (sq_qte_hdr_nbr);


--
-- Name: sq_qte_hdr sq_qte_hdr_sq_qte_cd_key; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.sq_qte_hdr
    ADD CONSTRAINT sq_qte_hdr_sq_qte_cd_key UNIQUE (sq_qte_cd);


--
-- Name: ut_cache ut_cache_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ut_cache
    ADD CONSTRAINT ut_cache_pkey PRIMARY KEY (object_name);


--
-- Name: ut_data_src ut_data_src_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ut_data_src
    ADD CONSTRAINT ut_data_src_pkey PRIMARY KEY (data_src_nm);


--
-- Name: ut_etl_grp_dtl ut_etl_grp_dtl_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ut_etl_grp_dtl
    ADD CONSTRAINT ut_etl_grp_dtl_pkey PRIMARY KEY (ut_etl_grp_cd, ut_etl_nbr);


--
-- Name: ut_etl_grp ut_etl_grp_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ut_etl_grp
    ADD CONSTRAINT ut_etl_grp_pkey PRIMARY KEY (ut_etl_grp_cd);


--
-- Name: ut_etl ut_etl_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ut_etl
    ADD CONSTRAINT ut_etl_pkey PRIMARY KEY (ut_etl_nbr);


--
-- Name: ut_facility ut_facility_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ut_facility
    ADD CONSTRAINT ut_facility_pkey PRIMARY KEY (facility);


--
-- Name: ut_facility ut_facility_ut_facility_nbr_key; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ut_facility
    ADD CONSTRAINT ut_facility_ut_facility_nbr_key UNIQUE (ut_facility_nbr);


--
-- Name: ut_process_status ut_process_status_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ut_process_status
    ADD CONSTRAINT ut_process_status_pkey PRIMARY KEY (ut_process_status_nbr);


--
-- Name: ut_process_status ut_process_status_process_nm_thread_nm_process_run_nbr_key; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ut_process_status
    ADD CONSTRAINT ut_process_status_process_nm_thread_nm_process_run_nbr_key UNIQUE (process_nm, thread_nm, process_run_nbr);


--
-- Name: ut_query ut_query_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ut_query
    ADD CONSTRAINT ut_query_pkey PRIMARY KEY (query_nm);


--
-- Name: ut_table ut_table_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ut_table
    ADD CONSTRAINT ut_table_pkey PRIMARY KEY (table_id);


--
-- Name: ut_table_rule ut_table_rule_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ut_table_rule
    ADD CONSTRAINT ut_table_rule_pkey PRIMARY KEY (table_id, msg_id, sql_text);


--
-- Name: ut_user ut_user_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ut_user
    ADD CONSTRAINT ut_user_pkey PRIMARY KEY (ut_user_nbr);


--
-- Name: ut_user ut_user_rf_passwd_key; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ut_user
    ADD CONSTRAINT ut_user_rf_passwd_key UNIQUE (rf_passwd);


--
-- Name: ut_user ut_user_user_name_key; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ut_user
    ADD CONSTRAINT ut_user_user_name_key UNIQUE (user_name);


--
-- Name: vq_qte_dtl vq_qte_dtl_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.vq_qte_dtl
    ADD CONSTRAINT vq_qte_dtl_pkey PRIMARY KEY (vq_qte_dtl_nbr);


--
-- Name: vq_qte_hdr vq_qte_hdr_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.vq_qte_hdr
    ADD CONSTRAINT vq_qte_hdr_pkey PRIMARY KEY (vq_qte_hdr_nbr);


--
-- Name: vq_qte_hdr vq_qte_hdr_vq_qte_cd_key; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.vq_qte_hdr
    ADD CONSTRAINT vq_qte_hdr_vq_qte_cd_key UNIQUE (vq_qte_cd);


--
-- Name: vq_qte_multiple_cert vq_qte_multiple_cert_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.vq_qte_multiple_cert
    ADD CONSTRAINT vq_qte_multiple_cert_pkey PRIMARY KEY (vq_qte_dtl_nbr, item_nbr);


--
-- Name: web_report web_report_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.web_report
    ADD CONSTRAINT web_report_pkey PRIMARY KEY (web_report_nbr);


--
-- Name: wh_facility_trans_onhand wh_facility_trans_onhand_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.wh_facility_trans_onhand
    ADD CONSTRAINT wh_facility_trans_onhand_pkey PRIMARY KEY (wh_facility_trans_onhand_nbr);


--
-- Name: wh_facility_trans_replen wh_facility_trans_replen_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.wh_facility_trans_replen
    ADD CONSTRAINT wh_facility_trans_replen_pkey PRIMARY KEY (wh_facility_trans_replen_nbr);


--
-- Name: wh_pick_dtl_wo_rqst wh_pick_dtl_wo_rqst_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.wh_pick_dtl_wo_rqst
    ADD CONSTRAINT wh_pick_dtl_wo_rqst_pkey PRIMARY KEY (wh_pick_dtl_wo_rqst_nbr);


--
-- Name: wo_dtl_cert wo_dtl_cert_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.wo_dtl_cert
    ADD CONSTRAINT wo_dtl_cert_pkey PRIMARY KEY (wo_dtl_nbr, cert_cd);


--
-- Name: wo_dtl wo_dtl_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.wo_dtl
    ADD CONSTRAINT wo_dtl_pkey PRIMARY KEY (wo_dtl_nbr);


--
-- Name: wo_hdr_cert wo_hdr_cert_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.wo_hdr_cert
    ADD CONSTRAINT wo_hdr_cert_pkey PRIMARY KEY (wo_hdr_nbr, cert_cd);


--
-- Name: wo_hdr wo_hdr_pkey; Type: CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.wo_hdr
    ADD CONSTRAINT wo_hdr_pkey PRIMARY KEY (wo_hdr_nbr);


--
-- Name: aps_alloc_onhand_fc_aps_alloc_onhand_fc_nbr; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE UNIQUE INDEX aps_alloc_onhand_fc_aps_alloc_onhand_fc_nbr ON aerodemo.aps_alloc_onhand_fc USING btree (aps_alloc_onhand_fc_nbr);


--
-- Name: aps_alloc_onhand_fc_fc_fcst_nbr; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX aps_alloc_onhand_fc_fc_fcst_nbr ON aerodemo.aps_alloc_onhand_fc USING btree (fc_fcst_nbr);


--
-- Name: aps_alloc_onhand_fc_item_nbr_rqst; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX aps_alloc_onhand_fc_item_nbr_rqst ON aerodemo.aps_alloc_onhand_fc USING btree (item_nbr_rqst);


--
-- Name: aps_alloc_po_ss_item_nbr_rqst; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX aps_alloc_po_ss_item_nbr_rqst ON aerodemo.aps_alloc_po_ss USING btree (item_nbr_rqst);


--
-- Name: aps_alloc_po_ss_po_line_dtl_nbr; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX aps_alloc_po_ss_po_line_dtl_nbr ON aerodemo.aps_alloc_po_ss USING btree (po_line_dtl_nbr);


--
-- Name: aps_item_global_subst_item_nbr_subst; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX aps_item_global_subst_item_nbr_subst ON aerodemo.aps_item_global_subst USING btree (item_nbr_subst);


--
-- Name: aps_plan_grp_plan_grp_nbr_item_nbr; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX aps_plan_grp_plan_grp_nbr_item_nbr ON aerodemo.aps_plan_grp USING btree (plan_grp_nbr, item_nbr);


--
-- Name: aps_result_dtl_dmd_item_nbr_rqst; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX aps_result_dtl_dmd_item_nbr_rqst ON aerodemo.aps_result_dtl_dmd USING btree (item_nbr_rqst);


--
-- Name: aps_result_dtl_sply_aps_result_dtl_dmd_nbr; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX aps_result_dtl_sply_aps_result_dtl_dmd_nbr ON aerodemo.aps_result_dtl_sply USING btree (aps_result_dtl_dmd_nbr);


--
-- Name: aps_rqst_queue_item_nbr; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX aps_rqst_queue_item_nbr ON aerodemo.aps_rqst_queue USING btree (item_nbr);


--
-- Name: aps_sply_sub_pool_aps_sply_pool_cd_aps_sply_sub_pool_cd; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE UNIQUE INDEX aps_sply_sub_pool_aps_sply_pool_cd_aps_sply_sub_pool_cd ON aerodemo.aps_sply_sub_pool USING btree (aps_sply_pool_cd, aps_sply_sub_pool_cd);


--
-- Name: aps_sply_sub_pool_sply_pool_type_id_avail_flg; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX aps_sply_sub_pool_sply_pool_type_id_avail_flg ON aerodemo.aps_sply_sub_pool USING btree (sply_pool_type_id, avail_flg);


--
-- Name: aps_src_rule_aps_src_rule_set_nbr_aps_sply_sub_pool_nbr_facilit; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE UNIQUE INDEX aps_src_rule_aps_src_rule_set_nbr_aps_sply_sub_pool_nbr_facilit ON aerodemo.aps_src_rule USING btree (aps_src_rule_set_nbr, aps_sply_sub_pool_nbr, facility, sply_type_id);


--
-- Name: ar_inv_dtl_bin_cd; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX ar_inv_dtl_bin_cd ON aerodemo.ar_inv_dtl USING btree (bin_cd);


--
-- Name: ar_inv_dtl_inv_cd; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX ar_inv_dtl_inv_cd ON aerodemo.ar_inv_dtl USING btree (inv_cd);


--
-- Name: ar_inv_dtl_item_cd; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX ar_inv_dtl_item_cd ON aerodemo.ar_inv_dtl USING btree (item_cd);


--
-- Name: ar_inv_dtl_item_nbr; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX ar_inv_dtl_item_nbr ON aerodemo.ar_inv_dtl USING btree (item_nbr);


--
-- Name: ar_inv_dtl_lot_nbr; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX ar_inv_dtl_lot_nbr ON aerodemo.ar_inv_dtl USING btree (lot_nbr);


--
-- Name: ar_inv_dtl_oe_ord_dtl_nbr; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX ar_inv_dtl_oe_ord_dtl_nbr ON aerodemo.ar_inv_dtl USING btree (oe_ord_dtl_nbr);


--
-- Name: ar_inv_hdr_ar_inv_batch_nbr; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX ar_inv_hdr_ar_inv_batch_nbr ON aerodemo.ar_inv_hdr USING btree (ar_inv_batch_nbr);


--
-- Name: ar_inv_hdr_ar_summary_inv_nbr; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX ar_inv_hdr_ar_summary_inv_nbr ON aerodemo.ar_inv_hdr USING btree (ar_summary_inv_nbr);


--
-- Name: ar_inv_hdr_bill_to_addr_nbr; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX ar_inv_hdr_bill_to_addr_nbr ON aerodemo.ar_inv_hdr USING btree (bill_to_addr_nbr);


--
-- Name: ar_inv_hdr_cust_po_cd; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX ar_inv_hdr_cust_po_cd ON aerodemo.ar_inv_hdr USING btree (cust_po_cd);


--
-- Name: ar_inv_hdr_inv_dt; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX ar_inv_hdr_inv_dt ON aerodemo.ar_inv_hdr USING btree (inv_dt);


--
-- Name: ar_inv_hdr_inv_stat_id; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX ar_inv_hdr_inv_stat_id ON aerodemo.ar_inv_hdr USING btree (inv_stat_id);


--
-- Name: ar_inv_hdr_oe_ord_hdr_nbr; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX ar_inv_hdr_oe_ord_hdr_nbr ON aerodemo.ar_inv_hdr USING btree (oe_ord_hdr_nbr);


--
-- Name: ar_inv_hdr_ord_cd; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX ar_inv_hdr_ord_cd ON aerodemo.ar_inv_hdr USING btree (ord_cd);


--
-- Name: ar_inv_hdr_org_nbr_cust; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX ar_inv_hdr_org_nbr_cust ON aerodemo.ar_inv_hdr USING btree (org_nbr_cust);


--
-- Name: ar_inv_hdr_ship_to_addr_nbr; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX ar_inv_hdr_ship_to_addr_nbr ON aerodemo.ar_inv_hdr USING btree (ship_to_addr_nbr);


--
-- Name: ar_rma_dtl_rma_cd; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX ar_rma_dtl_rma_cd ON aerodemo.ar_rma_dtl USING btree (rma_cd);


--
-- Name: ar_rma_rcpt_bin_nbr_stage; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX ar_rma_rcpt_bin_nbr_stage ON aerodemo.ar_rma_rcpt USING btree (bin_nbr_stage);


--
-- Name: fc_adj_fc_item_mast_nbr_effective_dt; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX fc_adj_fc_item_mast_nbr_effective_dt ON aerodemo.fc_adj USING btree (fc_item_mast_nbr, effective_dt);


--
-- Name: fc_aggr_mast_fcst_grp; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX fc_aggr_mast_fcst_grp ON aerodemo.fc_aggr_mast USING btree (fcst_grp);


--
-- Name: fc_fcst_fc_item_mast_nbr; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX fc_fcst_fc_item_mast_nbr ON aerodemo.fc_fcst USING btree (fc_item_mast_nbr);


--
-- Name: fc_fcst_fc_item_mast_nbr_cycle_intvl; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE UNIQUE INDEX fc_fcst_fc_item_mast_nbr_cycle_intvl ON aerodemo.fc_fcst USING btree (fc_item_mast_nbr, cycle, intvl);


--
-- Name: fc_hist_dist_fc_item_mast_nbr; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE UNIQUE INDEX fc_hist_dist_fc_item_mast_nbr ON aerodemo.fc_hist_dist USING btree (fc_item_mast_nbr);


--
-- Name: fc_item_attr_fc_attr_nbr_attr_val; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX fc_item_attr_fc_attr_nbr_attr_val ON aerodemo.fc_item_attr USING btree (fc_attr_nbr, attr_val);


--
-- Name: fc_item_fcst_mdl_fc_item_mast_nbr; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX fc_item_fcst_mdl_fc_item_mast_nbr ON aerodemo.fc_item_fcst_mdl USING btree (fc_item_mast_nbr);


--
-- Name: fc_item_mast_item_nbr; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX fc_item_mast_item_nbr ON aerodemo.fc_item_mast USING btree (item_nbr);


--
-- Name: fc_item_mast_item_nbr_fcst_grp_org_nbr_cust_aps_src_rule_set_nb; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE UNIQUE INDEX fc_item_mast_item_nbr_fcst_grp_org_nbr_cust_aps_src_rule_set_nb ON aerodemo.fc_item_mast USING btree (item_nbr, fcst_grp, org_nbr_cust, aps_src_rule_set_nbr);


--
-- Name: fc_item_mast_org_nbr_cust; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX fc_item_mast_org_nbr_cust ON aerodemo.fc_item_mast USING btree (org_nbr_cust);


--
-- Name: fim_attr_style_prod_size_color_cust_grp; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX fim_attr_style_prod_size_color_cust_grp ON aerodemo.fim_attr USING btree (style, prod_size, color, cust_grp);


--
-- Name: ic_bin_bin_cd_facility; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE UNIQUE INDEX ic_bin_bin_cd_facility ON aerodemo.ic_bin USING btree (bin_cd, facility);


--
-- Name: ic_bom_item_nbr_item_nbr_parent; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE UNIQUE INDEX ic_bom_item_nbr_item_nbr_parent ON aerodemo.ic_bom USING btree (item_nbr, item_nbr_parent);


--
-- Name: ic_bom_item_nbr_parent; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX ic_bom_item_nbr_parent ON aerodemo.ic_bom USING btree (item_nbr_parent);


--
-- Name: ic_item_cust_subst_item_nbr_subst; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX ic_item_cust_subst_item_nbr_subst ON aerodemo.ic_item_cust_subst USING btree (item_nbr_subst);


--
-- Name: ic_item_loc_aps_sply_sub_pool_nbr; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX ic_item_loc_aps_sply_sub_pool_nbr ON aerodemo.ic_item_loc USING btree (aps_sply_sub_pool_nbr);


--
-- Name: ic_item_loc_bin_nbr; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX ic_item_loc_bin_nbr ON aerodemo.ic_item_loc USING btree (bin_nbr);


--
-- Name: ic_item_loc_box_ic_item_loc_nbr; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX ic_item_loc_box_ic_item_loc_nbr ON aerodemo.ic_item_loc_box USING btree (ic_item_loc_nbr);


--
-- Name: ic_item_loc_box_ic_item_loc_nbr_box_cd_box_qty; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX ic_item_loc_box_ic_item_loc_nbr_box_cd_box_qty ON aerodemo.ic_item_loc_box USING btree (ic_item_loc_nbr, box_cd, box_qty);


--
-- Name: ic_item_loc_box_mfr_serial_cd; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX ic_item_loc_box_mfr_serial_cd ON aerodemo.ic_item_loc_box USING btree (mfr_serial_cd);


--
-- Name: ic_item_loc_box_serial_cd; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX ic_item_loc_box_serial_cd ON aerodemo.ic_item_loc_box USING btree (serial_cd);


--
-- Name: ic_item_loc_lot_nbr; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX ic_item_loc_lot_nbr ON aerodemo.ic_item_loc USING btree (lot_nbr);


--
-- Name: ic_item_loc_lot_nbr_ic_item_loc_nbr; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE UNIQUE INDEX ic_item_loc_lot_nbr_ic_item_loc_nbr ON aerodemo.ic_item_loc USING btree (lot_nbr, ic_item_loc_nbr);


--
-- Name: ic_item_mast_ean; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX ic_item_mast_ean ON aerodemo.ic_item_mast USING btree (ean);


--
-- Name: ic_item_mast_equiv_item_nbr_equiv; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX ic_item_mast_equiv_item_nbr_equiv ON aerodemo.ic_item_mast_equiv USING btree (item_nbr_equiv);


--
-- Name: ic_item_mast_equiv_item_nbr_equiv_item_nbr; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE UNIQUE INDEX ic_item_mast_equiv_item_nbr_equiv_item_nbr ON aerodemo.ic_item_mast_equiv USING btree (item_nbr_equiv, item_nbr);


--
-- Name: ic_item_mast_ic_category_nbr; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX ic_item_mast_ic_category_nbr ON aerodemo.ic_item_mast USING btree (ic_category_nbr);


--
-- Name: ic_item_mast_item_cd; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX ic_item_mast_item_cd ON aerodemo.ic_item_mast USING btree (translate(upper((item_cd)::text), '~!@#$%^&*()_+|\=-+/?><., %%ESCAPED_STRING%%'::text, ' '::text));


--
-- Name: ic_item_mast_item_nbr_supersede; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX ic_item_mast_item_nbr_supersede ON aerodemo.ic_item_mast USING btree (item_nbr_supersede);


--
-- Name: ic_item_mast_nomen_item_cd_nomen; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX ic_item_mast_nomen_item_cd_nomen ON aerodemo.ic_item_mast_nomen USING btree (translate(upper((item_cd_nomen)::text), '~!@#$%^&*()_+|\=-+/?><., %%ESCAPED_STRING%%'::text, ' '::text));


--
-- Name: ic_item_mast_nomen_item_cd_nomen_org_nbr_nomen; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX ic_item_mast_nomen_item_cd_nomen_org_nbr_nomen ON aerodemo.ic_item_mast_nomen USING btree (item_cd_nomen, org_nbr_nomen);


--
-- Name: ic_item_mast_upc_cd; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX ic_item_mast_upc_cd ON aerodemo.ic_item_mast USING btree (upc_cd);


--
-- Name: ic_item_mast_user_fld_1; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX ic_item_mast_user_fld_1 ON aerodemo.ic_item_mast USING btree (user_fld_1);


--
-- Name: ic_item_mast_user_fld_2; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX ic_item_mast_user_fld_2 ON aerodemo.ic_item_mast USING btree (user_fld_2);


--
-- Name: ic_item_mast_user_fld_3; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX ic_item_mast_user_fld_3 ON aerodemo.ic_item_mast USING btree (user_fld_3);


--
-- Name: ic_item_mast_user_fld_4; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX ic_item_mast_user_fld_4 ON aerodemo.ic_item_mast USING btree (user_fld_4);


--
-- Name: ic_item_mast_user_fld_5; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX ic_item_mast_user_fld_5 ON aerodemo.ic_item_mast USING btree (user_fld_5);


--
-- Name: ic_item_rev_lvl_apply_item_nbr_rev_lvl_apply; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX ic_item_rev_lvl_apply_item_nbr_rev_lvl_apply ON aerodemo.ic_item_rev_lvl_apply USING btree (item_nbr, rev_lvl_apply);


--
-- Name: ic_kit_mast_org_nbr_cust; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX ic_kit_mast_org_nbr_cust ON aerodemo.ic_kit_mast USING btree (org_nbr_cust);


--
-- Name: ic_lot_mast_item_nbr; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX ic_lot_mast_item_nbr ON aerodemo.ic_lot_mast USING btree (item_nbr);


--
-- Name: ic_lot_mast_item_nbr_qty_on_hand_flg_lot_nbr_rcpt_dt_mfr_date_e; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX ic_lot_mast_item_nbr_qty_on_hand_flg_lot_nbr_rcpt_dt_mfr_date_e ON aerodemo.ic_lot_mast USING btree (item_nbr, qty_on_hand_flg, lot_nbr, rcpt_dt, mfr_date, expire_dt, org_nbr_mfr, org_nbr_vnd, rev_lvl, cntry_cd_origin, lot_cost_um, lot_cost);


--
-- Name: ic_lot_mast_lot_nbr_qty_on_hand_flg; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE UNIQUE INDEX ic_lot_mast_lot_nbr_qty_on_hand_flg ON aerodemo.ic_lot_mast USING btree (lot_nbr, qty_on_hand_flg);


--
-- Name: ic_lot_mast_mfr_lot_cd; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX ic_lot_mast_mfr_lot_cd ON aerodemo.ic_lot_mast USING btree (mfr_lot_cd);


--
-- Name: ic_lot_mast_wo_hdr_nbr; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX ic_lot_mast_wo_hdr_nbr ON aerodemo.ic_lot_mast USING btree (wo_hdr_nbr);


--
-- Name: ic_multiple_cert_item_nbr; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX ic_multiple_cert_item_nbr ON aerodemo.ic_multiple_cert USING btree (item_nbr);


--
-- Name: ic_multiple_cert_lot_nbr; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX ic_multiple_cert_lot_nbr ON aerodemo.ic_multiple_cert USING btree (lot_nbr);


--
-- Name: ic_vnd_onhand_item_cd_vnd; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX ic_vnd_onhand_item_cd_vnd ON aerodemo.ic_vnd_onhand USING btree (item_cd_vnd);


--
-- Name: ic_vnd_onhand_item_cd_vnd_org_nbr_vnd_load_dt; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE UNIQUE INDEX ic_vnd_onhand_item_cd_vnd_org_nbr_vnd_load_dt ON aerodemo.ic_vnd_onhand USING btree (item_cd_vnd, org_nbr_vnd, load_dt);


--
-- Name: ic_vnd_onhand_item_cd_vnd_upper; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX ic_vnd_onhand_item_cd_vnd_upper ON aerodemo.ic_vnd_onhand USING btree (translate(upper((item_cd_vnd)::text), '~!@#$%^&*()_+|\=-+/?><., %%ESCAPED_STRING%%'::text, ' '::text));


--
-- Name: ic_vnd_onhand_org_nbr_vnd; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX ic_vnd_onhand_org_nbr_vnd ON aerodemo.ic_vnd_onhand USING btree (org_nbr_vnd);


--
-- Name: idl_cust_mast_org_cd_cust; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE UNIQUE INDEX idl_cust_mast_org_cd_cust ON aerodemo.idl_cust_mast USING btree (org_cd_cust);


--
-- Name: idl_fc_adj_fc_item_mast_nbr; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE UNIQUE INDEX idl_fc_adj_fc_item_mast_nbr ON aerodemo.idl_fc_adj USING btree (fc_item_mast_nbr);


--
-- Name: idl_ic_item_attr_item_cd; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX idl_ic_item_attr_item_cd ON aerodemo.idl_ic_item_attr USING btree (item_cd);


--
-- Name: idl_ic_item_mast_item_cd; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX idl_ic_item_mast_item_cd ON aerodemo.idl_ic_item_mast USING btree (item_cd);


--
-- Name: idl_oe_ord_dtl_ord_cd; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX idl_oe_ord_dtl_ord_cd ON aerodemo.idl_oe_ord_dtl USING btree (ord_cd);


--
-- Name: idl_so_hist_dtl_item_cd; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX idl_so_hist_dtl_item_cd ON aerodemo.idl_so_hist_dtl USING btree (item_cd);


--
-- Name: item_tmp2_item_cd; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE UNIQUE INDEX item_tmp2_item_cd ON aerodemo.item_tmp2 USING btree (item_cd);


--
-- Name: jhi_persistent_audit_event_principal_event_date; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX jhi_persistent_audit_event_principal_event_date ON aerodemo.jhi_persistent_audit_event USING btree (principal, event_date);


--
-- Name: na_org_indiv_indiv_nbr; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX na_org_indiv_indiv_nbr ON aerodemo.na_org_indiv USING btree (indiv_nbr);


--
-- Name: na_org_org_nbr_org_cd; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX na_org_org_nbr_org_cd ON aerodemo.na_org USING btree (org_nbr, org_cd);


--
-- Name: na_org_org_nm; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX na_org_org_nm ON aerodemo.na_org USING btree (org_nm);


--
-- Name: oe_contract_item_item_nbr; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX oe_contract_item_item_nbr ON aerodemo.oe_contract_item USING btree (item_nbr);


--
-- Name: oe_contract_item_log_item_nbr; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX oe_contract_item_log_item_nbr ON aerodemo.oe_contract_item_log USING btree (item_nbr);


--
-- Name: oe_contract_item_log_org_nbr_cust_contract_cd_item_cd_cust; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX oe_contract_item_log_org_nbr_cust_contract_cd_item_cd_cust ON aerodemo.oe_contract_item_log USING btree (org_nbr_cust, contract_cd, item_cd_cust);


--
-- Name: oe_contract_item_org_nbr_cust; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX oe_contract_item_org_nbr_cust ON aerodemo.oe_contract_item USING btree (org_nbr_cust);


--
-- Name: oe_cust_mast_org_nbr_cust_cust_alloc_prty_contract_cust_flg; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX oe_cust_mast_org_nbr_cust_cust_alloc_prty_contract_cust_flg ON aerodemo.oe_cust_mast USING btree (org_nbr_cust, cust_alloc_prty, contract_cust_flg);


--
-- Name: oe_cust_mfr_item_nbr; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX oe_cust_mfr_item_nbr ON aerodemo.oe_cust_mfr USING btree (item_nbr);


--
-- Name: oe_cust_mfr_org_nbr_cust; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX oe_cust_mfr_org_nbr_cust ON aerodemo.oe_cust_mfr USING btree (org_nbr_cust);


--
-- Name: oe_cust_mfr_org_nbr_mfr; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX oe_cust_mfr_org_nbr_mfr ON aerodemo.oe_cust_mfr USING btree (org_nbr_mfr);


--
-- Name: oe_ord_dtl_item_cd_cust; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX oe_ord_dtl_item_cd_cust ON aerodemo.oe_ord_dtl USING btree (item_cd_cust);


--
-- Name: oe_ord_dtl_item_nbr_ord_line_stat_id; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX oe_ord_dtl_item_nbr_ord_line_stat_id ON aerodemo.oe_ord_dtl USING btree (item_nbr_ord, line_stat_id);


--
-- Name: oe_ord_dtl_item_nbr_rqst; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX oe_ord_dtl_item_nbr_rqst ON aerodemo.oe_ord_dtl USING btree (item_nbr_rqst);


--
-- Name: oe_ord_dtl_line_stat_id_item_nbr_ord_oe_ord_dtl_nbr; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE UNIQUE INDEX oe_ord_dtl_line_stat_id_item_nbr_ord_oe_ord_dtl_nbr ON aerodemo.oe_ord_dtl USING btree (line_stat_id, item_nbr_ord, oe_ord_dtl_nbr);


--
-- Name: oe_ord_dtl_oe_ord_hdr_nbr; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX oe_ord_dtl_oe_ord_hdr_nbr ON aerodemo.oe_ord_dtl USING btree (oe_ord_hdr_nbr);


--
-- Name: oe_ord_dtl_oe_ord_hdr_nbr_line_nbr; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE UNIQUE INDEX oe_ord_dtl_oe_ord_hdr_nbr_line_nbr ON aerodemo.oe_ord_dtl USING btree (oe_ord_hdr_nbr, line_nbr);


--
-- Name: oe_ord_dtl_prom_dt_curr; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX oe_ord_dtl_prom_dt_curr ON aerodemo.oe_ord_dtl USING btree (prom_dt_curr);


--
-- Name: oe_ord_hdr_cust_po_cd_org_nbr_cust; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX oe_ord_hdr_cust_po_cd_org_nbr_cust ON aerodemo.oe_ord_hdr USING btree (cust_po_cd, org_nbr_cust);


--
-- Name: oe_ord_hdr_ord_dt; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX oe_ord_hdr_ord_dt ON aerodemo.oe_ord_hdr USING btree (ord_dt);


--
-- Name: oe_ord_hdr_org_nbr_cust; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX oe_ord_hdr_org_nbr_cust ON aerodemo.oe_ord_hdr USING btree (org_nbr_cust);


--
-- Name: po_line_dtl_po_line_hdr_nbr; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX po_line_dtl_po_line_hdr_nbr ON aerodemo.po_line_dtl USING btree (po_line_hdr_nbr);


--
-- Name: po_line_dtl_replen_curr_est_dt; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX po_line_dtl_replen_curr_est_dt ON aerodemo.po_line_dtl USING btree (replen_curr_est_dt);


--
-- Name: po_line_hdr_enter_dt; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX po_line_hdr_enter_dt ON aerodemo.po_line_hdr USING btree (enter_dt);


--
-- Name: po_line_hdr_item_nbr_line_stat_id; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX po_line_hdr_item_nbr_line_stat_id ON aerodemo.po_line_hdr USING btree (item_nbr, line_stat_id);


--
-- Name: po_line_hdr_po_ord_hdr_nbr; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX po_line_hdr_po_ord_hdr_nbr ON aerodemo.po_line_hdr USING btree (po_ord_hdr_nbr);


--
-- Name: po_line_hdr_po_ord_hdr_nbr_po_line_nbr; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE UNIQUE INDEX po_line_hdr_po_ord_hdr_nbr_po_line_nbr ON aerodemo.po_line_hdr USING btree (po_ord_hdr_nbr, po_line_nbr);


--
-- Name: po_line_multiple_cert_item_nbr; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX po_line_multiple_cert_item_nbr ON aerodemo.po_line_multiple_cert USING btree (item_nbr);


--
-- Name: po_line_multiple_cert_item_nbr_po_line_hdr_nbr; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE UNIQUE INDEX po_line_multiple_cert_item_nbr_po_line_hdr_nbr ON aerodemo.po_line_multiple_cert USING btree (item_nbr, po_line_hdr_nbr);


--
-- Name: po_line_multiple_cert_po_line_hdr_nbr; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX po_line_multiple_cert_po_line_hdr_nbr ON aerodemo.po_line_multiple_cert USING btree (po_line_hdr_nbr);


--
-- Name: po_ord_hdr_ord_stat_id; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX po_ord_hdr_ord_stat_id ON aerodemo.po_ord_hdr USING btree (ord_stat_id);


--
-- Name: po_ord_hdr_po_dt; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX po_ord_hdr_po_dt ON aerodemo.po_ord_hdr USING btree (po_dt);


--
-- Name: po_resched_org_nbr_vnd; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX po_resched_org_nbr_vnd ON aerodemo.po_resched USING btree (org_nbr_vnd);


--
-- Name: po_resched_po_line_dtl_nbr; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX po_resched_po_line_dtl_nbr ON aerodemo.po_resched USING btree (po_line_dtl_nbr);


--
-- Name: po_unplanned_rcpt_bin_nbr; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX po_unplanned_rcpt_bin_nbr ON aerodemo.po_unplanned_rcpt USING btree (bin_nbr);


--
-- Name: pos_dtl_box_cd; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX pos_dtl_box_cd ON aerodemo.pos_dtl USING btree (box_cd);


--
-- Name: pos_dtl_pos_hdr_nbr; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX pos_dtl_pos_hdr_nbr ON aerodemo.pos_dtl USING btree (pos_hdr_nbr);


--
-- Name: qa_cust_rtrn_item_nbr_mfr_lot_cd; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX qa_cust_rtrn_item_nbr_mfr_lot_cd ON aerodemo.qa_cust_rtrn USING btree (item_nbr, mfr_lot_cd);


--
-- Name: sq_qte_dtl_item_cd_qte; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX sq_qte_dtl_item_cd_qte ON aerodemo.sq_qte_dtl USING btree (item_cd_qte);


--
-- Name: sq_qte_dtl_item_nbr_qte; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX sq_qte_dtl_item_nbr_qte ON aerodemo.sq_qte_dtl USING btree (item_nbr_qte);


--
-- Name: sq_qte_dtl_oe_ord_dtl_nbr; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX sq_qte_dtl_oe_ord_dtl_nbr ON aerodemo.sq_qte_dtl USING btree (oe_ord_dtl_nbr);


--
-- Name: sq_qte_dtl_sq_qte_hdr_nbr; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX sq_qte_dtl_sq_qte_hdr_nbr ON aerodemo.sq_qte_dtl USING btree (sq_qte_hdr_nbr);


--
-- Name: sq_qte_hdr_org_nbr_cust; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX sq_qte_hdr_org_nbr_cust ON aerodemo.sq_qte_hdr USING btree (org_nbr_cust);


--
-- Name: sq_qte_hdr_org_nm_cust; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX sq_qte_hdr_org_nm_cust ON aerodemo.sq_qte_hdr USING btree (org_nm_cust);


--
-- Name: sq_qte_hdr_sq_qte_dt; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX sq_qte_hdr_sq_qte_dt ON aerodemo.sq_qte_hdr USING btree (sq_qte_dt);


--
-- Name: ss_adj_fc_item_mast_nbr; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX ss_adj_fc_item_mast_nbr ON aerodemo.ss_adj USING btree (fc_item_mast_nbr);


--
-- Name: tmp_fim_fc_item_mast_nbr; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE UNIQUE INDEX tmp_fim_fc_item_mast_nbr ON aerodemo.tmp_fim USING btree (fc_item_mast_nbr);


--
-- Name: ut_process_status_process_nm_thread_nm_process_run_nbr; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE UNIQUE INDEX ut_process_status_process_nm_thread_nm_process_run_nbr ON aerodemo.ut_process_status USING btree (process_nm, thread_nm, process_run_nbr);


--
-- Name: ut_table_row_msg_table_id_primary_key; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX ut_table_row_msg_table_id_primary_key ON aerodemo.ut_table_row_msg USING btree (table_id, primary_key);


--
-- Name: vq_qte_dtl_item_cd_qte; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX vq_qte_dtl_item_cd_qte ON aerodemo.vq_qte_dtl USING btree (translate(upper((item_cd_qte)::text), '~!@#$%^&*()_+|\=-+/?><., %%ESCAPED_STRING%%'::text, ' '::text));


--
-- Name: vq_qte_dtl_item_nbr_qte; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX vq_qte_dtl_item_nbr_qte ON aerodemo.vq_qte_dtl USING btree (item_nbr_qte);


--
-- Name: vq_qte_dtl_vq_qte_hdr_nbr; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX vq_qte_dtl_vq_qte_hdr_nbr ON aerodemo.vq_qte_dtl USING btree (vq_qte_hdr_nbr);


--
-- Name: vq_qte_hdr_org_nbr_vnd; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX vq_qte_hdr_org_nbr_vnd ON aerodemo.vq_qte_hdr USING btree (org_nbr_vnd);


--
-- Name: wh_facility_trans_onhand_lot_nbr_facility_src_aps_sply_sub_pool; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX wh_facility_trans_onhand_lot_nbr_facility_src_aps_sply_sub_pool ON aerodemo.wh_facility_trans_onhand USING btree (lot_nbr, facility_src, aps_sply_sub_pool_nbr_src);


--
-- Name: wh_pick_dtl_cop_rqst_aps_alloc_onhand_oo_nbr; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX wh_pick_dtl_cop_rqst_aps_alloc_onhand_oo_nbr ON aerodemo.wh_pick_dtl_cop_rqst USING btree (aps_alloc_onhand_oo_nbr);


--
-- Name: wh_pick_dtl_cop_rqst_box_cd; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX wh_pick_dtl_cop_rqst_box_cd ON aerodemo.wh_pick_dtl_cop_rqst USING btree (box_cd);


--
-- Name: wh_pick_dtl_cop_rqst_ic_item_loc_nbr; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX wh_pick_dtl_cop_rqst_ic_item_loc_nbr ON aerodemo.wh_pick_dtl_cop_rqst USING btree (ic_item_loc_nbr);


--
-- Name: wh_pick_dtl_cop_rqst_oe_ord_dtl_nbr; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX wh_pick_dtl_cop_rqst_oe_ord_dtl_nbr ON aerodemo.wh_pick_dtl_cop_rqst USING btree (oe_ord_dtl_nbr);


--
-- Name: wh_pick_dtl_cop_rqst_wh_pick_batch_cop_nbr; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX wh_pick_dtl_cop_rqst_wh_pick_batch_cop_nbr ON aerodemo.wh_pick_dtl_cop_rqst USING btree (wh_pick_batch_cop_nbr);


--
-- Name: wh_pick_dtl_cop_rqst_wh_pick_dtl_cop_rqst_nbr; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE UNIQUE INDEX wh_pick_dtl_cop_rqst_wh_pick_dtl_cop_rqst_nbr ON aerodemo.wh_pick_dtl_cop_rqst USING btree (wh_pick_dtl_cop_rqst_nbr);


--
-- Name: wh_pick_dtl_wo_rqst_aps_alloc_onhand_wo_nbr; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX wh_pick_dtl_wo_rqst_aps_alloc_onhand_wo_nbr ON aerodemo.wh_pick_dtl_wo_rqst USING btree (aps_alloc_onhand_wo_nbr);


--
-- Name: wh_pick_dtl_wo_rqst_box_cd; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX wh_pick_dtl_wo_rqst_box_cd ON aerodemo.wh_pick_dtl_wo_rqst USING btree (box_cd);


--
-- Name: wh_pick_dtl_wo_rqst_ic_item_loc_nbr; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX wh_pick_dtl_wo_rqst_ic_item_loc_nbr ON aerodemo.wh_pick_dtl_wo_rqst USING btree (ic_item_loc_nbr);


--
-- Name: wh_pick_dtl_wo_rqst_wh_pick_batch_wo_nbr; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX wh_pick_dtl_wo_rqst_wh_pick_batch_wo_nbr ON aerodemo.wh_pick_dtl_wo_rqst USING btree (wh_pick_batch_wo_nbr);


--
-- Name: wh_pick_dtl_wo_rqst_wo_dtl_nbr; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX wh_pick_dtl_wo_rqst_wo_dtl_nbr ON aerodemo.wh_pick_dtl_wo_rqst USING btree (wo_dtl_nbr);


--
-- Name: wh_pick_dtl_wo_rqst_wo_release_nbr; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX wh_pick_dtl_wo_rqst_wo_release_nbr ON aerodemo.wh_pick_dtl_wo_rqst USING btree (wo_release_nbr);


--
-- Name: wo_dtl_item_nbr_component; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX wo_dtl_item_nbr_component ON aerodemo.wo_dtl USING btree (item_nbr_component);


--
-- Name: wo_dtl_wo_hdr_nbr; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX wo_dtl_wo_hdr_nbr ON aerodemo.wo_dtl USING btree (wo_hdr_nbr);


--
-- Name: wo_hdr_item_nbr_rqst; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX wo_hdr_item_nbr_rqst ON aerodemo.wo_hdr USING btree (item_nbr_rqst);


--
-- Name: wo_hdr_item_nbr_rqst_wo_stat_id; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX wo_hdr_item_nbr_rqst_wo_stat_id ON aerodemo.wo_hdr USING btree (item_nbr_rqst, wo_stat_id);


--
-- Name: wo_hdr_oe_ord_dtl_nbr; Type: INDEX; Schema: aerodemo; Owner: jjs
--

CREATE INDEX wo_hdr_oe_ord_dtl_nbr ON aerodemo.wo_hdr USING btree (oe_ord_dtl_nbr);


--
-- Name: aps_plan_grp apg_iim_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.aps_plan_grp
    ADD CONSTRAINT apg_iim_fk FOREIGN KEY (item_nbr) REFERENCES aerodemo.ic_item_mast(item_nbr) DEFERRABLE INITIALLY DEFERRED;


--
-- Name: aps_alloc_onhand_fc aps_alloc_onhand_fc_ic_item_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.aps_alloc_onhand_fc
    ADD CONSTRAINT aps_alloc_onhand_fc_ic_item_mast_fk FOREIGN KEY (item_nbr_rqst) REFERENCES aerodemo.ic_item_mast(item_nbr);


--
-- Name: aps_alloc_onhand_oo aps_alloc_onhand_oo_ic_item_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.aps_alloc_onhand_oo
    ADD CONSTRAINT aps_alloc_onhand_oo_ic_item_mast_fk FOREIGN KEY (item_nbr_rqst) REFERENCES aerodemo.ic_item_mast(item_nbr);


--
-- Name: aps_alloc_onhand_oo aps_alloc_onhand_oo_wh_facility_trans_onhand_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.aps_alloc_onhand_oo
    ADD CONSTRAINT aps_alloc_onhand_oo_wh_facility_trans_onhand_fk FOREIGN KEY (wh_facility_trans_onhand_nbr) REFERENCES aerodemo.wh_facility_trans_onhand(wh_facility_trans_onhand_nbr);


--
-- Name: aps_alloc_onhand_ss aps_alloc_onhand_ss_ic_item_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.aps_alloc_onhand_ss
    ADD CONSTRAINT aps_alloc_onhand_ss_ic_item_mast_fk FOREIGN KEY (item_nbr_rqst) REFERENCES aerodemo.ic_item_mast(item_nbr);


--
-- Name: aps_alloc_onhand_ss aps_alloc_onhand_ss_wh_facility_trans_onhand_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.aps_alloc_onhand_ss
    ADD CONSTRAINT aps_alloc_onhand_ss_wh_facility_trans_onhand_fk FOREIGN KEY (wh_facility_trans_onhand_nbr) REFERENCES aerodemo.wh_facility_trans_onhand(wh_facility_trans_onhand_nbr);


--
-- Name: aps_alloc_onhand_wo aps_alloc_onhand_wo_ic_item_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.aps_alloc_onhand_wo
    ADD CONSTRAINT aps_alloc_onhand_wo_ic_item_mast_fk FOREIGN KEY (item_nbr_rqst) REFERENCES aerodemo.ic_item_mast(item_nbr);


--
-- Name: aps_alloc_onhand_wo aps_alloc_onhand_wo_wh_facility_trans_onhand_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.aps_alloc_onhand_wo
    ADD CONSTRAINT aps_alloc_onhand_wo_wh_facility_trans_onhand_fk FOREIGN KEY (wh_facility_trans_onhand_nbr) REFERENCES aerodemo.wh_facility_trans_onhand(wh_facility_trans_onhand_nbr);


--
-- Name: aps_alloc_replen_fc aps_alloc_replen_fc_ic_item_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.aps_alloc_replen_fc
    ADD CONSTRAINT aps_alloc_replen_fc_ic_item_mast_fk FOREIGN KEY (item_nbr_rqst) REFERENCES aerodemo.ic_item_mast(item_nbr);


--
-- Name: aps_alloc_replen_fc aps_alloc_replen_fc_wh_facility_trans_replen_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.aps_alloc_replen_fc
    ADD CONSTRAINT aps_alloc_replen_fc_wh_facility_trans_replen_fk FOREIGN KEY (wh_facility_trans_replen_nbr) REFERENCES aerodemo.wh_facility_trans_replen(wh_facility_trans_replen_nbr);


--
-- Name: aps_alloc_replen_oo aps_alloc_replen_oo_ic_item_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.aps_alloc_replen_oo
    ADD CONSTRAINT aps_alloc_replen_oo_ic_item_mast_fk FOREIGN KEY (item_nbr_rqst) REFERENCES aerodemo.ic_item_mast(item_nbr);


--
-- Name: aps_alloc_replen_oo aps_alloc_replen_oo_wh_facility_trans_replen_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.aps_alloc_replen_oo
    ADD CONSTRAINT aps_alloc_replen_oo_wh_facility_trans_replen_fk FOREIGN KEY (wh_facility_trans_replen_nbr) REFERENCES aerodemo.wh_facility_trans_replen(wh_facility_trans_replen_nbr);


--
-- Name: aps_alloc_replen_ss aps_alloc_replen_ss_ic_item_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.aps_alloc_replen_ss
    ADD CONSTRAINT aps_alloc_replen_ss_ic_item_mast_fk FOREIGN KEY (item_nbr_rqst) REFERENCES aerodemo.ic_item_mast(item_nbr);


--
-- Name: aps_alloc_replen_ss aps_alloc_replen_ss_wh_facility_trans_replen_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.aps_alloc_replen_ss
    ADD CONSTRAINT aps_alloc_replen_ss_wh_facility_trans_replen_fk FOREIGN KEY (wh_facility_trans_replen_nbr) REFERENCES aerodemo.wh_facility_trans_replen(wh_facility_trans_replen_nbr);


--
-- Name: aps_alloc_replen_wo aps_alloc_replen_wo_ic_item_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.aps_alloc_replen_wo
    ADD CONSTRAINT aps_alloc_replen_wo_ic_item_mast_fk FOREIGN KEY (item_nbr_rqst) REFERENCES aerodemo.ic_item_mast(item_nbr);


--
-- Name: aps_alloc_replen_wo aps_alloc_replen_wo_wh_facility_trans_replen_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.aps_alloc_replen_wo
    ADD CONSTRAINT aps_alloc_replen_wo_wh_facility_trans_replen_fk FOREIGN KEY (wh_facility_trans_replen_nbr) REFERENCES aerodemo.wh_facility_trans_replen(wh_facility_trans_replen_nbr);


--
-- Name: aps_alloc_wo_fc aps_alloc_wo_fc_fc_fcst_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.aps_alloc_wo_fc
    ADD CONSTRAINT aps_alloc_wo_fc_fc_fcst_fk FOREIGN KEY (fc_fcst_nbr) REFERENCES aerodemo.fc_fcst(fc_fcst_nbr);


--
-- Name: aps_alloc_wo_fc aps_alloc_wo_fc_ic_item_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.aps_alloc_wo_fc
    ADD CONSTRAINT aps_alloc_wo_fc_ic_item_mast_fk FOREIGN KEY (item_nbr_rqst) REFERENCES aerodemo.ic_item_mast(item_nbr);


--
-- Name: aps_alloc_wo_fc aps_alloc_wo_fc_wo_hdr_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.aps_alloc_wo_fc
    ADD CONSTRAINT aps_alloc_wo_fc_wo_hdr_fk FOREIGN KEY (wo_hdr_nbr) REFERENCES aerodemo.wo_hdr(wo_hdr_nbr);


--
-- Name: aps_alloc_wo_oo aps_alloc_wo_oo_ic_item_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.aps_alloc_wo_oo
    ADD CONSTRAINT aps_alloc_wo_oo_ic_item_mast_fk FOREIGN KEY (item_nbr_rqst) REFERENCES aerodemo.ic_item_mast(item_nbr);


--
-- Name: aps_alloc_wo_oo aps_alloc_wo_oo_oe_ord_dtl_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.aps_alloc_wo_oo
    ADD CONSTRAINT aps_alloc_wo_oo_oe_ord_dtl_fk FOREIGN KEY (oe_ord_dtl_nbr) REFERENCES aerodemo.oe_ord_dtl(oe_ord_dtl_nbr);


--
-- Name: aps_alloc_wo_oo aps_alloc_wo_oo_wo_hdr_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.aps_alloc_wo_oo
    ADD CONSTRAINT aps_alloc_wo_oo_wo_hdr_fk FOREIGN KEY (wo_hdr_nbr) REFERENCES aerodemo.wo_hdr(wo_hdr_nbr);


--
-- Name: aps_alloc_wo_ss aps_alloc_wo_ss_fc_item_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.aps_alloc_wo_ss
    ADD CONSTRAINT aps_alloc_wo_ss_fc_item_mast_fk FOREIGN KEY (fc_item_mast_nbr) REFERENCES aerodemo.fc_item_mast(fc_item_mast_nbr);


--
-- Name: aps_alloc_wo_ss aps_alloc_wo_ss_ic_item_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.aps_alloc_wo_ss
    ADD CONSTRAINT aps_alloc_wo_ss_ic_item_mast_fk FOREIGN KEY (item_nbr_rqst) REFERENCES aerodemo.ic_item_mast(item_nbr);


--
-- Name: aps_alloc_wo_ss aps_alloc_wo_ss_wo_hdr_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.aps_alloc_wo_ss
    ADD CONSTRAINT aps_alloc_wo_ss_wo_hdr_fk FOREIGN KEY (wo_hdr_nbr) REFERENCES aerodemo.wo_hdr(wo_hdr_nbr);


--
-- Name: aps_alloc_wo_wo aps_alloc_wo_wo_ic_item_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.aps_alloc_wo_wo
    ADD CONSTRAINT aps_alloc_wo_wo_ic_item_mast_fk FOREIGN KEY (item_nbr_rqst) REFERENCES aerodemo.ic_item_mast(item_nbr);


--
-- Name: aps_alloc_wo_wo aps_alloc_wo_wo_wo_dtl_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.aps_alloc_wo_wo
    ADD CONSTRAINT aps_alloc_wo_wo_wo_dtl_fk FOREIGN KEY (wo_dtl_nbr) REFERENCES aerodemo.wo_dtl(wo_dtl_nbr);


--
-- Name: aps_alloc_wo_wo aps_alloc_wo_wo_wo_hdr_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.aps_alloc_wo_wo
    ADD CONSTRAINT aps_alloc_wo_wo_wo_hdr_fk FOREIGN KEY (wo_hdr_nbr) REFERENCES aerodemo.wo_hdr(wo_hdr_nbr);


--
-- Name: aps_item_global_subst aps_item_global_subst_ic_item_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.aps_item_global_subst
    ADD CONSTRAINT aps_item_global_subst_ic_item_mast_fk FOREIGN KEY (item_nbr) REFERENCES aerodemo.ic_item_mast(item_nbr);


--
-- Name: aps_item_log aps_item_log_ic_item_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.aps_item_log
    ADD CONSTRAINT aps_item_log_ic_item_mast_fk FOREIGN KEY (item_nbr) REFERENCES aerodemo.ic_item_mast(item_nbr);


--
-- Name: aps_plan_grp aps_plan_grp_ic_item_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.aps_plan_grp
    ADD CONSTRAINT aps_plan_grp_ic_item_mast_fk FOREIGN KEY (item_nbr) REFERENCES aerodemo.ic_item_mast(item_nbr);


--
-- Name: aps_rqst_queue aps_rqst_queue_ic_item_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.aps_rqst_queue
    ADD CONSTRAINT aps_rqst_queue_ic_item_mast_fk FOREIGN KEY (item_nbr) REFERENCES aerodemo.ic_item_mast(item_nbr);


--
-- Name: aps_sply_sub_pool aps_sply_sub_pool_aps_sply_pool_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.aps_sply_sub_pool
    ADD CONSTRAINT aps_sply_sub_pool_aps_sply_pool_fk FOREIGN KEY (aps_sply_pool_cd) REFERENCES aerodemo.aps_sply_pool(aps_sply_pool_cd);


--
-- Name: aps_sply_sub_pool aps_sply_sub_pool_po_vnd_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.aps_sply_sub_pool
    ADD CONSTRAINT aps_sply_sub_pool_po_vnd_mast_fk FOREIGN KEY (org_nbr_vnd) REFERENCES aerodemo.po_vnd_mast(org_nbr_vnd);


--
-- Name: aps_src_rule aps_src_rule_aps_sply_sub_pool_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.aps_src_rule
    ADD CONSTRAINT aps_src_rule_aps_sply_sub_pool_fk FOREIGN KEY (aps_sply_sub_pool_nbr) REFERENCES aerodemo.aps_sply_sub_pool(aps_sply_sub_pool_nbr);


--
-- Name: aps_src_rule aps_src_rule_aps_src_rule_set_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.aps_src_rule
    ADD CONSTRAINT aps_src_rule_aps_src_rule_set_fk FOREIGN KEY (aps_src_rule_set_nbr) REFERENCES aerodemo.aps_src_rule_set(aps_src_rule_set_nbr);


--
-- Name: aps_src_rule_primary aps_src_rule_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.aps_src_rule_primary
    ADD CONSTRAINT aps_src_rule_fk FOREIGN KEY (aps_src_rule_nbr) REFERENCES aerodemo.aps_src_rule(aps_src_rule_nbr) DEFERRABLE INITIALLY DEFERRED;


--
-- Name: aps_src_rule_primary aps_src_rule_primary_fk2; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.aps_src_rule_primary
    ADD CONSTRAINT aps_src_rule_primary_fk2 FOREIGN KEY (aps_src_rule_set_nbr) REFERENCES aerodemo.aps_src_rule_set(aps_src_rule_set_nbr) DEFERRABLE INITIALLY DEFERRED;


--
-- Name: aps_src_rule_set aps_src_rule_set_aps_sply_pool_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.aps_src_rule_set
    ADD CONSTRAINT aps_src_rule_set_aps_sply_pool_fk FOREIGN KEY (aps_sply_pool_cd_fcst_consume) REFERENCES aerodemo.aps_sply_pool(aps_sply_pool_cd);


--
-- Name: aps_src_rule_set aps_src_rule_set_ut_facility_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.aps_src_rule_set
    ADD CONSTRAINT aps_src_rule_set_ut_facility_fk FOREIGN KEY (facility_fcst_consume) REFERENCES aerodemo.ut_facility(facility);


--
-- Name: aps_src_rule aps_src_rule_ut_facility_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.aps_src_rule
    ADD CONSTRAINT aps_src_rule_ut_facility_fk FOREIGN KEY (facility) REFERENCES aerodemo.ut_facility(facility);


--
-- Name: ar_inv_dtl ar_inv_dtl_aps_sply_sub_pool_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ar_inv_dtl
    ADD CONSTRAINT ar_inv_dtl_aps_sply_sub_pool_fk FOREIGN KEY (aps_sply_sub_pool_nbr) REFERENCES aerodemo.aps_sply_sub_pool(aps_sply_sub_pool_nbr);


--
-- Name: ar_inv_dtl ar_inv_dtl_ic_item_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ar_inv_dtl
    ADD CONSTRAINT ar_inv_dtl_ic_item_mast_fk FOREIGN KEY (item_nbr) REFERENCES aerodemo.ic_item_mast(item_nbr);


--
-- Name: ar_inv_dtl ar_inv_dtl_ic_um_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ar_inv_dtl
    ADD CONSTRAINT ar_inv_dtl_ic_um_fk FOREIGN KEY (sell_um) REFERENCES aerodemo.ic_um(um_id);


--
-- Name: ar_inv_dtl ar_inv_dtl_po_mfr_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ar_inv_dtl
    ADD CONSTRAINT ar_inv_dtl_po_mfr_mast_fk FOREIGN KEY (org_nbr_mfr) REFERENCES aerodemo.po_mfr_mast(org_nbr_mfr);


--
-- Name: ar_inv_dtl ar_inv_dtl_ut_facility_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ar_inv_dtl
    ADD CONSTRAINT ar_inv_dtl_ut_facility_fk FOREIGN KEY (facility) REFERENCES aerodemo.ut_facility(facility);


--
-- Name: ar_inv_hdr ar_inv_hdr_currency_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ar_inv_hdr
    ADD CONSTRAINT ar_inv_hdr_currency_fk FOREIGN KEY (curr_cd) REFERENCES aerodemo.currency(curr_cd);


--
-- Name: ar_inv_hdr ar_inv_hdr_na_indiv_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ar_inv_hdr
    ADD CONSTRAINT ar_inv_hdr_na_indiv_fk FOREIGN KEY (sell_indiv_nbr) REFERENCES aerodemo.na_indiv(indiv_nbr);


--
-- Name: ar_inv_hdr ar_inv_hdr_na_org_addr_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ar_inv_hdr
    ADD CONSTRAINT ar_inv_hdr_na_org_addr_fk FOREIGN KEY (bill_to_addr_nbr) REFERENCES aerodemo.na_org_addr(addr_nbr);


--
-- Name: ar_inv_hdr ar_inv_hdr_oe_cust_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ar_inv_hdr
    ADD CONSTRAINT ar_inv_hdr_oe_cust_mast_fk FOREIGN KEY (org_nbr_cust) REFERENCES aerodemo.oe_cust_mast(org_nbr_cust);


--
-- Name: ar_inv_hdr ar_inv_hdr_oe_ord_hdr_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ar_inv_hdr
    ADD CONSTRAINT ar_inv_hdr_oe_ord_hdr_fk FOREIGN KEY (oe_ord_hdr_nbr) REFERENCES aerodemo.oe_ord_hdr(oe_ord_hdr_nbr);


--
-- Name: ar_rma_dtl ar_rma_dtl_ar_inv_dtl_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ar_rma_dtl
    ADD CONSTRAINT ar_rma_dtl_ar_inv_dtl_fk FOREIGN KEY (ar_inv_dtl_nbr) REFERENCES aerodemo.ar_inv_dtl(ar_inv_dtl_nbr);


--
-- Name: ar_rma_dtl ar_rma_dtl_ic_item_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ar_rma_dtl
    ADD CONSTRAINT ar_rma_dtl_ic_item_mast_fk FOREIGN KEY (item_nbr) REFERENCES aerodemo.ic_item_mast(item_nbr);


--
-- Name: ar_rma_dtl ar_rma_dtl_ic_um_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ar_rma_dtl
    ADD CONSTRAINT ar_rma_dtl_ic_um_fk FOREIGN KEY (sell_um) REFERENCES aerodemo.ic_um(um_id);


--
-- Name: ar_rma_rcpt ar_rma_rcpt_aps_sply_sub_pool_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ar_rma_rcpt
    ADD CONSTRAINT ar_rma_rcpt_aps_sply_sub_pool_fk FOREIGN KEY (aps_sply_sub_pool_nbr_recv) REFERENCES aerodemo.aps_sply_sub_pool(aps_sply_sub_pool_nbr);


--
-- Name: ar_rma_rcpt ar_rma_rcpt_ar_rma_dtl_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ar_rma_rcpt
    ADD CONSTRAINT ar_rma_rcpt_ar_rma_dtl_fk FOREIGN KEY (ar_rma_dtl_nbr) REFERENCES aerodemo.ar_rma_dtl(ar_rma_dtl_nbr);


--
-- Name: ar_rma_rcpt ar_rma_rcpt_ic_item_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ar_rma_rcpt
    ADD CONSTRAINT ar_rma_rcpt_ic_item_mast_fk FOREIGN KEY (item_nbr) REFERENCES aerodemo.ic_item_mast(item_nbr);


--
-- Name: ar_rma_rcpt ar_rma_rcpt_ic_lot_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ar_rma_rcpt
    ADD CONSTRAINT ar_rma_rcpt_ic_lot_mast_fk FOREIGN KEY (lot_nbr_recv) REFERENCES aerodemo.ic_lot_mast(lot_nbr);


--
-- Name: ar_rma_rcpt ar_rma_rcpt_ic_um_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ar_rma_rcpt
    ADD CONSTRAINT ar_rma_rcpt_ic_um_fk FOREIGN KEY (rma_um) REFERENCES aerodemo.ic_um(um_id);


--
-- Name: ar_rma_rcpt ar_rma_rcpt_ut_user_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ar_rma_rcpt
    ADD CONSTRAINT ar_rma_rcpt_ut_user_fk FOREIGN KEY (ut_user_nbr_inspect) REFERENCES aerodemo.ut_user(ut_user_nbr);


--
-- Name: ar_inv_dtl arid_iim_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ar_inv_dtl
    ADD CONSTRAINT arid_iim_fk FOREIGN KEY (item_nbr) REFERENCES aerodemo.ic_item_mast(item_nbr) DEFERRABLE INITIALLY DEFERRED;


--
-- Name: ar_inv_hdr arih_ocm_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ar_inv_hdr
    ADD CONSTRAINT arih_ocm_fk FOREIGN KEY (org_nbr_cust) REFERENCES aerodemo.oe_cust_mast(org_nbr_cust) DEFERRABLE INITIALLY DEFERRED;


--
-- Name: aps_src_rule asr_asrs_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.aps_src_rule
    ADD CONSTRAINT asr_asrs_fk FOREIGN KEY (aps_src_rule_set_nbr) REFERENCES aerodemo.aps_src_rule_set(aps_src_rule_set_nbr) DEFERRABLE INITIALLY DEFERRED;


--
-- Name: aps_src_rule asr_assp_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.aps_src_rule
    ADD CONSTRAINT asr_assp_fk FOREIGN KEY (aps_sply_sub_pool_nbr) REFERENCES aerodemo.aps_sply_sub_pool(aps_sply_sub_pool_nbr) DEFERRABLE INITIALLY DEFERRED;


--
-- Name: cal_dt cal_dt_cal_calendar_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.cal_dt
    ADD CONSTRAINT cal_dt_cal_calendar_fk FOREIGN KEY (calendar) REFERENCES aerodemo.cal_calendar(calendar);


--
-- Name: cal_dt cd_cc_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.cal_dt
    ADD CONSTRAINT cd_cc_fk FOREIGN KEY (calendar) REFERENCES aerodemo.cal_calendar(calendar) DEFERRABLE INITIALLY DEFERRED;


--
-- Name: fc_adj fa_fim_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.fc_adj
    ADD CONSTRAINT fa_fim_fk FOREIGN KEY (fc_item_mast_nbr) REFERENCES aerodemo.fc_item_mast(fc_item_mast_nbr) DEFERRABLE INITIALLY DEFERRED;


--
-- Name: fc_aggr_mast fam_cc_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.fc_aggr_mast
    ADD CONSTRAINT fam_cc_fk FOREIGN KEY (calendar) REFERENCES aerodemo.cal_calendar(calendar) DEFERRABLE INITIALLY DEFERRED;


--
-- Name: fc_aggr_mast fam_fg_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.fc_aggr_mast
    ADD CONSTRAINT fam_fg_fk FOREIGN KEY (fcst_grp) REFERENCES aerodemo.fcst_grp(fcst_grp) DEFERRABLE INITIALLY DEFERRED;


--
-- Name: fc_aggr_mast_attr fama_fam_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.fc_aggr_mast_attr
    ADD CONSTRAINT fama_fam_fk FOREIGN KEY (fc_aggr_mast_nbr) REFERENCES aerodemo.fc_aggr_mast(fc_aggr_mast_nbr) DEFERRABLE INITIALLY DEFERRED;


--
-- Name: fc_aggr_mast_attr fama_ia_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.fc_aggr_mast_attr
    ADD CONSTRAINT fama_ia_fk FOREIGN KEY (ic_attr_nbr) REFERENCES aerodemo.ic_attr(ic_attr_nbr) DEFERRABLE INITIALLY DEFERRED;


--
-- Name: fc_aggr_mast_dtl famd_fam_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.fc_aggr_mast_dtl
    ADD CONSTRAINT famd_fam_fk FOREIGN KEY (fc_aggr_mast_nbr) REFERENCES aerodemo.fc_aggr_mast(fc_aggr_mast_nbr) DEFERRABLE INITIALLY DEFERRED;


--
-- Name: fc_aggr_mast_dtl famd_fim_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.fc_aggr_mast_dtl
    ADD CONSTRAINT famd_fim_fk FOREIGN KEY (fc_item_mast_nbr) REFERENCES aerodemo.fc_item_mast(fc_item_mast_nbr) DEFERRABLE INITIALLY DEFERRED;


--
-- Name: fc_attr_val fav_fa_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.fc_attr_val
    ADD CONSTRAINT fav_fa_fk FOREIGN KEY (fc_attr_nbr) REFERENCES aerodemo.fc_attr(fc_attr_nbr) DEFERRABLE INITIALLY DEFERRED;


--
-- Name: fc_build_rate fbr_fbrg_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.fc_build_rate
    ADD CONSTRAINT fbr_fbrg_fk FOREIGN KEY (fc_build_rate_grp_cd) REFERENCES aerodemo.fc_build_rate_grp(fc_build_rate_grp_cd) DEFERRABLE INITIALLY DEFERRED;


--
-- Name: fc_adj fc_adj_fc_item_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.fc_adj
    ADD CONSTRAINT fc_adj_fc_item_mast_fk FOREIGN KEY (fc_item_mast_nbr) REFERENCES aerodemo.fc_item_mast(fc_item_mast_nbr);


--
-- Name: fc_attr_val fc_attr_val_fc_attr_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.fc_attr_val
    ADD CONSTRAINT fc_attr_val_fc_attr_fk FOREIGN KEY (fc_attr_nbr) REFERENCES aerodemo.fc_attr(fc_attr_nbr);


--
-- Name: fc_build_rate fc_build_rate_fc_build_rate_grp_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.fc_build_rate
    ADD CONSTRAINT fc_build_rate_fc_build_rate_grp_fk FOREIGN KEY (fc_build_rate_grp_cd) REFERENCES aerodemo.fc_build_rate_grp(fc_build_rate_grp_cd);


--
-- Name: fc_fcst fc_fcst_fc_item_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.fc_fcst
    ADD CONSTRAINT fc_fcst_fc_item_mast_fk FOREIGN KEY (fc_item_mast_nbr) REFERENCES aerodemo.fc_item_mast(fc_item_mast_nbr);


--
-- Name: fc_hist fc_hist_fc_item_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.fc_hist
    ADD CONSTRAINT fc_hist_fc_item_mast_fk FOREIGN KEY (fc_item_mast_nbr) REFERENCES aerodemo.fc_item_mast(fc_item_mast_nbr);


--
-- Name: fc_item_attr fc_item_attr_fc_attr_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.fc_item_attr
    ADD CONSTRAINT fc_item_attr_fc_attr_fk FOREIGN KEY (fc_attr_nbr) REFERENCES aerodemo.fc_attr(fc_attr_nbr);


--
-- Name: fc_item_attr fc_item_attr_fc_item_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.fc_item_attr
    ADD CONSTRAINT fc_item_attr_fc_item_mast_fk FOREIGN KEY (fc_item_mast_nbr) REFERENCES aerodemo.fc_item_mast(fc_item_mast_nbr);


--
-- Name: fc_item_mast fc_item_mast_aps_src_rule_set_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.fc_item_mast
    ADD CONSTRAINT fc_item_mast_aps_src_rule_set_fk FOREIGN KEY (aps_src_rule_set_nbr) REFERENCES aerodemo.aps_src_rule_set(aps_src_rule_set_nbr);


--
-- Name: fc_item_mast fc_item_mast_fc_build_rate_grp_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.fc_item_mast
    ADD CONSTRAINT fc_item_mast_fc_build_rate_grp_fk FOREIGN KEY (fc_build_rate_grp_cd) REFERENCES aerodemo.fc_build_rate_grp(fc_build_rate_grp_cd);


--
-- Name: fc_item_mast fc_item_mast_fcst_grp_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.fc_item_mast
    ADD CONSTRAINT fc_item_mast_fcst_grp_fk FOREIGN KEY (fcst_grp) REFERENCES aerodemo.fcst_grp(fcst_grp);


--
-- Name: fc_item_mast fc_item_mast_ic_item_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.fc_item_mast
    ADD CONSTRAINT fc_item_mast_ic_item_mast_fk FOREIGN KEY (item_nbr) REFERENCES aerodemo.ic_item_mast(item_nbr);


--
-- Name: fc_item_mast fc_item_mast_oe_cust_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.fc_item_mast
    ADD CONSTRAINT fc_item_mast_oe_cust_mast_fk FOREIGN KEY (org_nbr_cust) REFERENCES aerodemo.oe_cust_mast(org_nbr_cust);


--
-- Name: fc_item_mast fc_item_mast_po_mfr_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.fc_item_mast
    ADD CONSTRAINT fc_item_mast_po_mfr_mast_fk FOREIGN KEY (org_nbr_mfr_rqst) REFERENCES aerodemo.po_mfr_mast(org_nbr_mfr);


--
-- Name: fc_queue fc_queue_fc_item_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.fc_queue
    ADD CONSTRAINT fc_queue_fc_item_mast_fk FOREIGN KEY (fc_item_mast_nbr) REFERENCES aerodemo.fc_item_mast(fc_item_mast_nbr);


--
-- Name: fc_fcst ff_fim_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.fc_fcst
    ADD CONSTRAINT ff_fim_fk FOREIGN KEY (fc_item_mast_nbr) REFERENCES aerodemo.fc_item_mast(fc_item_mast_nbr) DEFERRABLE INITIALLY DEFERRED;


--
-- Name: fc_fcst_aggr ffa_fam_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.fc_fcst_aggr
    ADD CONSTRAINT ffa_fam_fk FOREIGN KEY (fc_aggr_mast_nbr) REFERENCES aerodemo.fc_aggr_mast(fc_aggr_mast_nbr) DEFERRABLE INITIALLY DEFERRED;


--
-- Name: fc_item_mast fim_asrs_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.fc_item_mast
    ADD CONSTRAINT fim_asrs_fk FOREIGN KEY (aps_src_rule_set_nbr) REFERENCES aerodemo.aps_src_rule_set(aps_src_rule_set_nbr) DEFERRABLE INITIALLY DEFERRED;


--
-- Name: fc_item_mast fim_fbrg_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.fc_item_mast
    ADD CONSTRAINT fim_fbrg_fk FOREIGN KEY (fc_build_rate_grp_cd) REFERENCES aerodemo.fc_build_rate_grp(fc_build_rate_grp_cd) DEFERRABLE INITIALLY DEFERRED;


--
-- Name: fc_item_mast fim_fg_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.fc_item_mast
    ADD CONSTRAINT fim_fg_fk FOREIGN KEY (fcst_grp) REFERENCES aerodemo.fcst_grp(fcst_grp) DEFERRABLE INITIALLY DEFERRED;


--
-- Name: fc_item_mast fim_iim_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.fc_item_mast
    ADD CONSTRAINT fim_iim_fk FOREIGN KEY (item_nbr) REFERENCES aerodemo.ic_item_mast(item_nbr) DEFERRABLE INITIALLY DEFERRED;


--
-- Name: fc_item_mast fim_ocm_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.fc_item_mast
    ADD CONSTRAINT fim_ocm_fk FOREIGN KEY (org_nbr_cust) REFERENCES aerodemo.oe_cust_mast(org_nbr_cust) DEFERRABLE INITIALLY DEFERRED;


--
-- Name: jhi_user_authority fk_authority_name; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.jhi_user_authority
    ADD CONSTRAINT fk_authority_name FOREIGN KEY (authority_name) REFERENCES aerodemo.jhi_authority(name) DEFERRABLE INITIALLY DEFERRED;


--
-- Name: jhi_user_authority fk_user_id; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.jhi_user_authority
    ADD CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES aerodemo.jhi_user(id) DEFERRABLE INITIALLY DEFERRED;


--
-- Name: fc_queue fq_fim_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.fc_queue
    ADD CONSTRAINT fq_fim_fk FOREIGN KEY (fc_item_mast_nbr) REFERENCES aerodemo.fc_item_mast(fc_item_mast_nbr) DEFERRABLE INITIALLY DEFERRED;


--
-- Name: ic_attr_val iav_ia_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_attr_val
    ADD CONSTRAINT iav_ia_fk FOREIGN KEY (ic_attr_nbr) REFERENCES aerodemo.ic_attr(ic_attr_nbr) DEFERRABLE INITIALLY DEFERRED;


--
-- Name: ic_bom_cert ibc_iim_1_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_bom_cert
    ADD CONSTRAINT ibc_iim_1_fk FOREIGN KEY (item_nbr) REFERENCES aerodemo.ic_item_mast(item_nbr);


--
-- Name: ic_bom_cert ibc_iim_2_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_bom_cert
    ADD CONSTRAINT ibc_iim_2_fk FOREIGN KEY (item_nbr) REFERENCES aerodemo.ic_item_mast(item_nbr);


--
-- Name: ic_attr_val ic_attr_val_ic_attr_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_attr_val
    ADD CONSTRAINT ic_attr_val_ic_attr_fk FOREIGN KEY (ic_attr_nbr) REFERENCES aerodemo.ic_attr(ic_attr_nbr);


--
-- Name: ic_bin ic_bin_ut_facility_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_bin
    ADD CONSTRAINT ic_bin_ut_facility_fk FOREIGN KEY (facility) REFERENCES aerodemo.ut_facility(facility);


--
-- Name: ic_bom_cert ic_bom_cert_ic_cert_cd_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_bom_cert
    ADD CONSTRAINT ic_bom_cert_ic_cert_cd_fk FOREIGN KEY (cert_cd) REFERENCES aerodemo.ic_cert_cd(cert_cd);


--
-- Name: ic_bom_cert ic_bom_cert_ic_item_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_bom_cert
    ADD CONSTRAINT ic_bom_cert_ic_item_mast_fk FOREIGN KEY (item_nbr_parent) REFERENCES aerodemo.ic_item_mast(item_nbr);


--
-- Name: ic_bom ic_bom_ic_item_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_bom
    ADD CONSTRAINT ic_bom_ic_item_mast_fk FOREIGN KEY (item_nbr) REFERENCES aerodemo.ic_item_mast(item_nbr);


--
-- Name: ic_bom ic_bom_po_mfr_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_bom
    ADD CONSTRAINT ic_bom_po_mfr_mast_fk FOREIGN KEY (org_nbr_mfr_rqst) REFERENCES aerodemo.po_mfr_mast(org_nbr_mfr);


--
-- Name: ic_category ic_category_ic_category_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_category
    ADD CONSTRAINT ic_category_ic_category_fk FOREIGN KEY (ic_category_nbr_parent) REFERENCES aerodemo.ic_category(ic_category_nbr);


--
-- Name: ic_category ic_category_po_vnd_set_hdr_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_category
    ADD CONSTRAINT ic_category_po_vnd_set_hdr_fk FOREIGN KEY (po_vnd_set_hdr_nbr) REFERENCES aerodemo.po_vnd_set_hdr(po_vnd_set_hdr_nbr);


--
-- Name: ic_item_attr ic_item_attr_ic_attr_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_item_attr
    ADD CONSTRAINT ic_item_attr_ic_attr_fk FOREIGN KEY (ic_attr_nbr) REFERENCES aerodemo.ic_attr(ic_attr_nbr);


--
-- Name: ic_item_attr ic_item_attr_ic_item_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_item_attr
    ADD CONSTRAINT ic_item_attr_ic_item_mast_fk FOREIGN KEY (item_nbr) REFERENCES aerodemo.ic_item_mast(item_nbr);


--
-- Name: ic_item_cost ic_item_cost_ic_item_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_item_cost
    ADD CONSTRAINT ic_item_cost_ic_item_mast_fk FOREIGN KEY (item_nbr) REFERENCES aerodemo.ic_item_mast(item_nbr);


--
-- Name: ic_item_cust_subst ic_item_cust_subst_ic_item_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_item_cust_subst
    ADD CONSTRAINT ic_item_cust_subst_ic_item_mast_fk FOREIGN KEY (item_nbr_subst) REFERENCES aerodemo.ic_item_mast(item_nbr);


--
-- Name: ic_item_cust_subst ic_item_cust_subst_oe_cust_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_item_cust_subst
    ADD CONSTRAINT ic_item_cust_subst_oe_cust_mast_fk FOREIGN KEY (org_nbr_cust) REFERENCES aerodemo.oe_cust_mast(org_nbr_cust);


--
-- Name: ic_item_loc ic_item_loc_aps_sply_sub_pool_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_item_loc
    ADD CONSTRAINT ic_item_loc_aps_sply_sub_pool_fk FOREIGN KEY (aps_sply_sub_pool_nbr) REFERENCES aerodemo.aps_sply_sub_pool(aps_sply_sub_pool_nbr);


--
-- Name: ic_item_loc_box ic_item_loc_box_ic_item_loc_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_item_loc_box
    ADD CONSTRAINT ic_item_loc_box_ic_item_loc_fk FOREIGN KEY (ic_item_loc_nbr) REFERENCES aerodemo.ic_item_loc(ic_item_loc_nbr);


--
-- Name: ic_item_loc ic_item_loc_ic_bin_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_item_loc
    ADD CONSTRAINT ic_item_loc_ic_bin_fk FOREIGN KEY (bin_nbr) REFERENCES aerodemo.ic_bin(bin_nbr);


--
-- Name: ic_item_loc ic_item_loc_ic_lot_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_item_loc
    ADD CONSTRAINT ic_item_loc_ic_lot_mast_fk FOREIGN KEY (lot_nbr) REFERENCES aerodemo.ic_lot_mast(lot_nbr);


--
-- Name: ic_item_mast_cert ic_item_mast_cert_ic_cert_cd_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_item_mast_cert
    ADD CONSTRAINT ic_item_mast_cert_ic_cert_cd_fk FOREIGN KEY (cert_cd) REFERENCES aerodemo.ic_cert_cd(cert_cd);


--
-- Name: ic_item_mast_cert ic_item_mast_cert_ic_item_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_item_mast_cert
    ADD CONSTRAINT ic_item_mast_cert_ic_item_mast_fk FOREIGN KEY (item_nbr) REFERENCES aerodemo.ic_item_mast(item_nbr);


--
-- Name: ic_item_mast ic_item_mast_currency_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_item_mast
    ADD CONSTRAINT ic_item_mast_currency_fk FOREIGN KEY (curr_cd) REFERENCES aerodemo.currency(curr_cd);


--
-- Name: ic_item_mast_equiv ic_item_mast_equiv_ic_item_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_item_mast_equiv
    ADD CONSTRAINT ic_item_mast_equiv_ic_item_mast_fk FOREIGN KEY (item_nbr_equiv) REFERENCES aerodemo.ic_item_mast(item_nbr);


--
-- Name: ic_item_mast ic_item_mast_ic_category_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_item_mast
    ADD CONSTRAINT ic_item_mast_ic_category_fk FOREIGN KEY (ic_category_nbr) REFERENCES aerodemo.ic_category(ic_category_nbr);


--
-- Name: ic_item_mast ic_item_mast_ic_item_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_item_mast
    ADD CONSTRAINT ic_item_mast_ic_item_mast_fk FOREIGN KEY (item_nbr_primary) REFERENCES aerodemo.ic_item_mast(item_nbr);


--
-- Name: ic_item_mast ic_item_mast_ic_um_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_item_mast
    ADD CONSTRAINT ic_item_mast_ic_um_fk FOREIGN KEY (sell_um) REFERENCES aerodemo.ic_um(um_id);


--
-- Name: ic_item_mast ic_item_mast_img_image_set_hdr_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_item_mast
    ADD CONSTRAINT ic_item_mast_img_image_set_hdr_fk FOREIGN KEY (img_image_set_hdr_nbr) REFERENCES aerodemo.img_image_set_hdr(img_image_set_hdr_nbr);


--
-- Name: ic_item_mast ic_item_mast_na_indiv_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_item_mast
    ADD CONSTRAINT ic_item_mast_na_indiv_fk FOREIGN KEY (indiv_nbr_buyer) REFERENCES aerodemo.na_indiv(indiv_nbr);


--
-- Name: ic_item_mast_nomen ic_item_mast_nomen_ic_item_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_item_mast_nomen
    ADD CONSTRAINT ic_item_mast_nomen_ic_item_mast_fk FOREIGN KEY (item_nbr) REFERENCES aerodemo.ic_item_mast(item_nbr);


--
-- Name: ic_item_mast_nomen ic_item_mast_nomen_na_org_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_item_mast_nomen
    ADD CONSTRAINT ic_item_mast_nomen_na_org_fk FOREIGN KEY (org_nbr_nomen) REFERENCES aerodemo.na_org(org_nbr);


--
-- Name: ic_item_mast_rel ic_item_mast_rel_ic_item_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_item_mast_rel
    ADD CONSTRAINT ic_item_mast_rel_ic_item_mast_fk FOREIGN KEY (item_nbr_rel) REFERENCES aerodemo.ic_item_mast(item_nbr);


--
-- Name: ic_item_mast_upd_queue ic_item_mast_upd_queue_ic_item_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_item_mast_upd_queue
    ADD CONSTRAINT ic_item_mast_upd_queue_ic_item_mast_fk FOREIGN KEY (item_nbr) REFERENCES aerodemo.ic_item_mast(item_nbr);


--
-- Name: ic_item_mast_upd_queue ic_item_mast_upd_queue_ut_user_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_item_mast_upd_queue
    ADD CONSTRAINT ic_item_mast_upd_queue_ut_user_fk FOREIGN KEY (ut_user_nbr_upd) REFERENCES aerodemo.ut_user(ut_user_nbr);


--
-- Name: ic_item_mfg_path ic_item_mfg_path_ic_item_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_item_mfg_path
    ADD CONSTRAINT ic_item_mfg_path_ic_item_mast_fk FOREIGN KEY (item_nbr) REFERENCES aerodemo.ic_item_mast(item_nbr);


--
-- Name: ic_item_narr ic_item_narr_ic_item_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_item_narr
    ADD CONSTRAINT ic_item_narr_ic_item_mast_fk FOREIGN KEY (item_nbr) REFERENCES aerodemo.ic_item_mast(item_nbr);


--
-- Name: ic_item_operation_yield ic_item_operation_yield_ic_item_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_item_operation_yield
    ADD CONSTRAINT ic_item_operation_yield_ic_item_mast_fk FOREIGN KEY (item_nbr) REFERENCES aerodemo.ic_item_mast(item_nbr);


--
-- Name: ic_item_price_matrix ic_item_price_matrix_currency_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_item_price_matrix
    ADD CONSTRAINT ic_item_price_matrix_currency_fk FOREIGN KEY (curr_cd) REFERENCES aerodemo.currency(curr_cd);


--
-- Name: ic_item_price_matrix ic_item_price_matrix_ic_item_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_item_price_matrix
    ADD CONSTRAINT ic_item_price_matrix_ic_item_mast_fk FOREIGN KEY (item_nbr) REFERENCES aerodemo.ic_item_mast(item_nbr);


--
-- Name: ic_item_restrict_cust ic_item_restrict_cust_ic_item_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_item_restrict_cust
    ADD CONSTRAINT ic_item_restrict_cust_ic_item_mast_fk FOREIGN KEY (item_nbr) REFERENCES aerodemo.ic_item_mast(item_nbr);


--
-- Name: ic_item_restrict_cust ic_item_restrict_cust_oe_cust_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_item_restrict_cust
    ADD CONSTRAINT ic_item_restrict_cust_oe_cust_mast_fk FOREIGN KEY (org_nbr_cust) REFERENCES aerodemo.oe_cust_mast(org_nbr_cust);


--
-- Name: ic_item_rev_lvl ic_item_rev_lvl_ic_item_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_item_rev_lvl
    ADD CONSTRAINT ic_item_rev_lvl_ic_item_mast_fk FOREIGN KEY (item_nbr) REFERENCES aerodemo.ic_item_mast(item_nbr);


--
-- Name: ic_item_stat ic_item_stat_ic_item_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_item_stat
    ADD CONSTRAINT ic_item_stat_ic_item_mast_fk FOREIGN KEY (item_nbr) REFERENCES aerodemo.ic_item_mast(item_nbr);


--
-- Name: ic_item_stat ic_item_stat_item_nbr_fkey; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_item_stat
    ADD CONSTRAINT ic_item_stat_item_nbr_fkey FOREIGN KEY (item_nbr) REFERENCES aerodemo.ic_item_mast(item_nbr);


--
-- Name: ic_item_vnd_cost_matrix ic_item_vnd_cost_matrix_currency_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_item_vnd_cost_matrix
    ADD CONSTRAINT ic_item_vnd_cost_matrix_currency_fk FOREIGN KEY (unit_cost_curr_cd) REFERENCES aerodemo.currency(curr_cd);


--
-- Name: ic_item_vnd_cost_matrix ic_item_vnd_cost_matrix_ic_item_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_item_vnd_cost_matrix
    ADD CONSTRAINT ic_item_vnd_cost_matrix_ic_item_mast_fk FOREIGN KEY (item_nbr) REFERENCES aerodemo.ic_item_mast(item_nbr);


--
-- Name: ic_item_vnd_cost_matrix ic_item_vnd_cost_matrix_po_vnd_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_item_vnd_cost_matrix
    ADD CONSTRAINT ic_item_vnd_cost_matrix_po_vnd_mast_fk FOREIGN KEY (org_nbr_vnd) REFERENCES aerodemo.po_vnd_mast(org_nbr_vnd);


--
-- Name: ic_kit_mast ic_kit_mast_aps_sply_sub_pool_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_kit_mast
    ADD CONSTRAINT ic_kit_mast_aps_sply_sub_pool_fk FOREIGN KEY (aps_sply_sub_pool_nbr_dflt) REFERENCES aerodemo.aps_sply_sub_pool(aps_sply_sub_pool_nbr);


--
-- Name: ic_kit_mast ic_kit_mast_aps_src_rule_set_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_kit_mast
    ADD CONSTRAINT ic_kit_mast_aps_src_rule_set_fk FOREIGN KEY (aps_src_rule_set_nbr_dflt) REFERENCES aerodemo.aps_src_rule_set(aps_src_rule_set_nbr);


--
-- Name: ic_kit_mast ic_kit_mast_ic_item_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_kit_mast
    ADD CONSTRAINT ic_kit_mast_ic_item_mast_fk FOREIGN KEY (item_nbr) REFERENCES aerodemo.ic_item_mast(item_nbr);


--
-- Name: ic_kit_mast ic_kit_mast_oe_cust_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_kit_mast
    ADD CONSTRAINT ic_kit_mast_oe_cust_mast_fk FOREIGN KEY (org_nbr_cust) REFERENCES aerodemo.oe_cust_mast(org_nbr_cust);


--
-- Name: ic_kit_mast ic_kit_mast_ut_facility_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_kit_mast
    ADD CONSTRAINT ic_kit_mast_ut_facility_fk FOREIGN KEY (facility_dflt) REFERENCES aerodemo.ut_facility(facility);


--
-- Name: ic_lot_image ic_lot_image_cert_cd_fkey; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_lot_image
    ADD CONSTRAINT ic_lot_image_cert_cd_fkey FOREIGN KEY (cert_cd) REFERENCES aerodemo.ic_cert_cd(cert_cd);


--
-- Name: ic_lot_image ic_lot_image_ic_lot_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_lot_image
    ADD CONSTRAINT ic_lot_image_ic_lot_mast_fk FOREIGN KEY (lot_nbr) REFERENCES aerodemo.ic_lot_mast(lot_nbr);


--
-- Name: ic_lot_image ic_lot_image_img_image_set_hdr_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_lot_image
    ADD CONSTRAINT ic_lot_image_img_image_set_hdr_fk FOREIGN KEY (img_image_set_hdr_nbr) REFERENCES aerodemo.img_image_set_hdr(img_image_set_hdr_nbr);


--
-- Name: ic_lot_image ic_lot_image_img_image_set_hdr_nbr_fkey; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_lot_image
    ADD CONSTRAINT ic_lot_image_img_image_set_hdr_nbr_fkey FOREIGN KEY (img_image_set_hdr_nbr) REFERENCES aerodemo.img_image_set_hdr(img_image_set_hdr_nbr);


--
-- Name: ic_lot_image ic_lot_image_lot_nbr_fkey; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_lot_image
    ADD CONSTRAINT ic_lot_image_lot_nbr_fkey FOREIGN KEY (lot_nbr) REFERENCES aerodemo.ic_lot_mast(lot_nbr);


--
-- Name: ic_lot_mast_cert ic_lot_mast_cert_ic_cert_cd_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_lot_mast_cert
    ADD CONSTRAINT ic_lot_mast_cert_ic_cert_cd_fk FOREIGN KEY (cert_cd) REFERENCES aerodemo.ic_cert_cd(cert_cd);


--
-- Name: ic_lot_mast_cert ic_lot_mast_cert_ic_lot_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_lot_mast_cert
    ADD CONSTRAINT ic_lot_mast_cert_ic_lot_mast_fk FOREIGN KEY (lot_nbr) REFERENCES aerodemo.ic_lot_mast(lot_nbr);


--
-- Name: ic_lot_mast ic_lot_mast_currency_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_lot_mast
    ADD CONSTRAINT ic_lot_mast_currency_fk FOREIGN KEY (lot_cost_curr_cd) REFERENCES aerodemo.currency(curr_cd);


--
-- Name: ic_lot_mast ic_lot_mast_ic_item_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_lot_mast
    ADD CONSTRAINT ic_lot_mast_ic_item_mast_fk FOREIGN KEY (item_nbr) REFERENCES aerodemo.ic_item_mast(item_nbr);


--
-- Name: ic_lot_mast ic_lot_mast_ic_lot_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_lot_mast
    ADD CONSTRAINT ic_lot_mast_ic_lot_mast_fk FOREIGN KEY (lot_nbr_orig) REFERENCES aerodemo.ic_lot_mast(lot_nbr);


--
-- Name: ic_lot_mast ic_lot_mast_ic_um_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_lot_mast
    ADD CONSTRAINT ic_lot_mast_ic_um_fk FOREIGN KEY (lot_cost_um) REFERENCES aerodemo.ic_um(um_id);


--
-- Name: ic_lot_mast ic_lot_mast_po_line_hdr_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_lot_mast
    ADD CONSTRAINT ic_lot_mast_po_line_hdr_fk FOREIGN KEY (po_line_hdr_nbr) REFERENCES aerodemo.po_line_hdr(po_line_hdr_nbr);


--
-- Name: ic_lot_mast ic_lot_mast_po_mfr_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_lot_mast
    ADD CONSTRAINT ic_lot_mast_po_mfr_mast_fk FOREIGN KEY (org_nbr_mfr) REFERENCES aerodemo.po_mfr_mast(org_nbr_mfr);


--
-- Name: ic_lot_mast ic_lot_mast_po_ord_hdr_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_lot_mast
    ADD CONSTRAINT ic_lot_mast_po_ord_hdr_fk FOREIGN KEY (po_ord_hdr_nbr) REFERENCES aerodemo.po_ord_hdr(po_ord_hdr_nbr);


--
-- Name: ic_lot_mast ic_lot_mast_po_vnd_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_lot_mast
    ADD CONSTRAINT ic_lot_mast_po_vnd_mast_fk FOREIGN KEY (org_nbr_vnd) REFERENCES aerodemo.po_vnd_mast(org_nbr_vnd);


--
-- Name: ic_lot_mast ic_lot_mast_ut_user_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_lot_mast
    ADD CONSTRAINT ic_lot_mast_ut_user_fk FOREIGN KEY (ut_user_nbr_inspect) REFERENCES aerodemo.ut_user(ut_user_nbr);


--
-- Name: ic_multiple_cert ic_multiple_cert_ic_item_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_multiple_cert
    ADD CONSTRAINT ic_multiple_cert_ic_item_mast_fk FOREIGN KEY (item_nbr) REFERENCES aerodemo.ic_item_mast(item_nbr);


--
-- Name: ic_multiple_cert ic_multiple_cert_ic_lot_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_multiple_cert
    ADD CONSTRAINT ic_multiple_cert_ic_lot_mast_fk FOREIGN KEY (lot_nbr) REFERENCES aerodemo.ic_lot_mast(lot_nbr);


--
-- Name: ic_um_cnvt ic_um_cnvt_ic_um_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_um_cnvt
    ADD CONSTRAINT ic_um_cnvt_ic_um_fk FOREIGN KEY (um_id_from) REFERENCES aerodemo.ic_um(um_id);


--
-- Name: ic_um_cnvt_item ic_um_cnvt_item_ic_item_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_um_cnvt_item
    ADD CONSTRAINT ic_um_cnvt_item_ic_item_mast_fk FOREIGN KEY (item_nbr) REFERENCES aerodemo.ic_item_mast(item_nbr);


--
-- Name: ic_um_cnvt_item ic_um_cnvt_item_ic_um_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_um_cnvt_item
    ADD CONSTRAINT ic_um_cnvt_item_ic_um_fk FOREIGN KEY (um_id_to) REFERENCES aerodemo.ic_um(um_id);


--
-- Name: ic_vnd_onhand ic_vnd_onhand_ic_item_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_vnd_onhand
    ADD CONSTRAINT ic_vnd_onhand_ic_item_mast_fk FOREIGN KEY (item_nbr) REFERENCES aerodemo.ic_item_mast(item_nbr);


--
-- Name: ic_vnd_onhand ic_vnd_onhand_ic_um_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_vnd_onhand
    ADD CONSTRAINT ic_vnd_onhand_ic_um_fk FOREIGN KEY (stk_um) REFERENCES aerodemo.ic_um(um_id);


--
-- Name: ic_vnd_onhand ic_vnd_onhand_po_vnd_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_vnd_onhand
    ADD CONSTRAINT ic_vnd_onhand_po_vnd_mast_fk FOREIGN KEY (org_nbr_vnd) REFERENCES aerodemo.po_vnd_mast(org_nbr_vnd);


--
-- Name: ic_bom icb_iim_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_bom
    ADD CONSTRAINT icb_iim_fk FOREIGN KEY (item_nbr) REFERENCES aerodemo.ic_item_mast(item_nbr);


--
-- Name: idl_fc_fcst iff_fim_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.idl_fc_fcst
    ADD CONSTRAINT iff_fim_fk FOREIGN KEY (fc_item_mast_nbr) REFERENCES aerodemo.fc_item_mast(fc_item_mast_nbr) DEFERRABLE INITIALLY DEFERRED NOT VALID;


--
-- Name: ic_item_attr iia_iim_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_item_attr
    ADD CONSTRAINT iia_iim_fk FOREIGN KEY (item_nbr) REFERENCES aerodemo.ic_item_mast(item_nbr) DEFERRABLE INITIALLY DEFERRED;


--
-- Name: ic_item_cost iic_iim_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_item_cost
    ADD CONSTRAINT iic_iim_fk FOREIGN KEY (item_nbr) REFERENCES aerodemo.ic_item_mast(item_nbr);


--
-- Name: ic_item_loc iil_assp_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_item_loc
    ADD CONSTRAINT iil_assp_fk FOREIGN KEY (aps_sply_sub_pool_nbr) REFERENCES aerodemo.aps_sply_sub_pool(aps_sply_sub_pool_nbr) DEFERRABLE INITIALLY DEFERRED;


--
-- Name: ic_item_loc iil_ib_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_item_loc
    ADD CONSTRAINT iil_ib_fk FOREIGN KEY (bin_nbr) REFERENCES aerodemo.ic_bin(bin_nbr) DEFERRABLE INITIALLY DEFERRED;


--
-- Name: ic_item_loc iil_ilm_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_item_loc
    ADD CONSTRAINT iil_ilm_fk FOREIGN KEY (lot_nbr) REFERENCES aerodemo.ic_lot_mast(lot_nbr) DEFERRABLE INITIALLY DEFERRED;


--
-- Name: ic_item_mast iim_iim_primary_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_item_mast
    ADD CONSTRAINT iim_iim_primary_fk FOREIGN KEY (item_nbr_primary) REFERENCES aerodemo.ic_item_mast(item_nbr) DEFERRABLE INITIALLY DEFERRED;


--
-- Name: ic_kit_mast ikm_asrs_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_kit_mast
    ADD CONSTRAINT ikm_asrs_fk FOREIGN KEY (aps_src_rule_set_nbr_dflt) REFERENCES aerodemo.aps_src_rule_set(aps_src_rule_set_nbr) DEFERRABLE INITIALLY DEFERRED;


--
-- Name: ic_lot_mast ilm_ilm_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_lot_mast
    ADD CONSTRAINT ilm_ilm_fk FOREIGN KEY (lot_nbr_orig) REFERENCES aerodemo.ic_lot_mast(lot_nbr) DEFERRABLE INITIALLY DEFERRED;


--
-- Name: ic_lot_mast ilm_plh_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_lot_mast
    ADD CONSTRAINT ilm_plh_fk FOREIGN KEY (po_line_hdr_nbr) REFERENCES aerodemo.po_line_hdr(po_line_hdr_nbr) DEFERRABLE INITIALLY DEFERRED;


--
-- Name: ic_lot_mast_cert ilmc_ilm_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_lot_mast_cert
    ADD CONSTRAINT ilmc_ilm_fk FOREIGN KEY (lot_nbr) REFERENCES aerodemo.ic_lot_mast(lot_nbr) DEFERRABLE INITIALLY DEFERRED;


--
-- Name: ic_multiple_cert imc_ilm_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ic_multiple_cert
    ADD CONSTRAINT imc_ilm_fk FOREIGN KEY (lot_nbr) REFERENCES aerodemo.ic_lot_mast(lot_nbr) DEFERRABLE INITIALLY DEFERRED;


--
-- Name: img_image_set_dtl img_image_set_dtl_img_image_nbr_fkey; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.img_image_set_dtl
    ADD CONSTRAINT img_image_set_dtl_img_image_nbr_fkey FOREIGN KEY (img_image_nbr) REFERENCES aerodemo.img_image(img_image_nbr);


--
-- Name: img_image_set_dtl img_image_set_dtl_img_image_set_hdr_nbr_fkey; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.img_image_set_dtl
    ADD CONSTRAINT img_image_set_dtl_img_image_set_hdr_nbr_fkey FOREIGN KEY (img_image_set_hdr_nbr) REFERENCES aerodemo.img_image_set_hdr(img_image_set_hdr_nbr);


--
-- Name: img_scan_batch img_scan_batch_img_image_set_hdr_nbr_fkey; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.img_scan_batch
    ADD CONSTRAINT img_scan_batch_img_image_set_hdr_nbr_fkey FOREIGN KEY (img_image_set_hdr_nbr) REFERENCES aerodemo.img_image_set_hdr(img_image_set_hdr_nbr);


--
-- Name: job_msg job_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.job_msg
    ADD CONSTRAINT job_fk FOREIGN KEY (job_step_id) REFERENCES aerodemo.job_step(job_step_id);


--
-- Name: job_msg job_msg_job_log_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.job_msg
    ADD CONSTRAINT job_msg_job_log_fk FOREIGN KEY (job_log_id) REFERENCES aerodemo.job_log(job_log_id);


--
-- Name: job_step_tracefile jst_js_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.job_step_tracefile
    ADD CONSTRAINT jst_js_fk FOREIGN KEY (job_step_id) REFERENCES aerodemo.job_step(job_step_id);


--
-- Name: job_step_tracefile_json jstj_js_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.job_step_tracefile_json
    ADD CONSTRAINT jstj_js_fk FOREIGN KEY (job_step_id) REFERENCES aerodemo.job_step(job_step_id);


--
-- Name: na_org_addr na_org_addr_cal_calendar_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.na_org_addr
    ADD CONSTRAINT na_org_addr_cal_calendar_fk FOREIGN KEY (calendar) REFERENCES aerodemo.cal_calendar(calendar);


--
-- Name: na_org_addr na_org_addr_na_org_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.na_org_addr
    ADD CONSTRAINT na_org_addr_na_org_fk FOREIGN KEY (org_nbr) REFERENCES aerodemo.na_org(org_nbr);


--
-- Name: na_org na_org_currency_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.na_org
    ADD CONSTRAINT na_org_currency_fk FOREIGN KEY (curr_cd_dflt) REFERENCES aerodemo.currency(curr_cd);


--
-- Name: na_org_indiv na_org_indiv_na_indiv_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.na_org_indiv
    ADD CONSTRAINT na_org_indiv_na_indiv_fk FOREIGN KEY (indiv_nbr) REFERENCES aerodemo.na_indiv(indiv_nbr);


--
-- Name: na_org_indiv na_org_indiv_na_org_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.na_org_indiv
    ADD CONSTRAINT na_org_indiv_na_org_fk FOREIGN KEY (org_nbr) REFERENCES aerodemo.na_org(org_nbr);


--
-- Name: oe_cust_contract occ_ocm_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.oe_cust_contract
    ADD CONSTRAINT occ_ocm_fk FOREIGN KEY (org_nbr_cust) REFERENCES aerodemo.oe_cust_mast(org_nbr_cust) DEFERRABLE INITIALLY DEFERRED;


--
-- Name: oe_cust_mast ocm_ocm_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.oe_cust_mast
    ADD CONSTRAINT ocm_ocm_fk FOREIGN KEY (org_nbr_cust_parent) REFERENCES aerodemo.oe_cust_mast(org_nbr_cust) DEFERRABLE INITIALLY DEFERRED;


--
-- Name: oe_cust_mfr ocmfr_iim_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.oe_cust_mfr
    ADD CONSTRAINT ocmfr_iim_fk FOREIGN KEY (item_nbr) REFERENCES aerodemo.ic_item_mast(item_nbr) DEFERRABLE INITIALLY DEFERRED;


--
-- Name: oe_cust_mfr ocmfr_ocm_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.oe_cust_mfr
    ADD CONSTRAINT ocmfr_ocm_fk FOREIGN KEY (org_nbr_cust) REFERENCES aerodemo.oe_cust_mast(org_nbr_cust) DEFERRABLE INITIALLY DEFERRED;


--
-- Name: oe_contract_item oe_contract_item_ic_item_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.oe_contract_item
    ADD CONSTRAINT oe_contract_item_ic_item_mast_fk FOREIGN KEY (item_nbr_supersede) REFERENCES aerodemo.ic_item_mast(item_nbr);


--
-- Name: oe_cust_contract oe_cust_contract_fcst_grp_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.oe_cust_contract
    ADD CONSTRAINT oe_cust_contract_fcst_grp_fk FOREIGN KEY (fcst_grp) REFERENCES aerodemo.fcst_grp(fcst_grp);


--
-- Name: oe_cust_contract oe_cust_contract_oe_cust_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.oe_cust_contract
    ADD CONSTRAINT oe_cust_contract_oe_cust_mast_fk FOREIGN KEY (org_nbr_cust) REFERENCES aerodemo.oe_cust_mast(org_nbr_cust);


--
-- Name: oe_cust_mast_cert oe_cust_mast_cert_ic_cert_cd_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.oe_cust_mast_cert
    ADD CONSTRAINT oe_cust_mast_cert_ic_cert_cd_fk FOREIGN KEY (cert_cd) REFERENCES aerodemo.ic_cert_cd(cert_cd);


--
-- Name: oe_cust_mast_cert oe_cust_mast_cert_oe_cust_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.oe_cust_mast_cert
    ADD CONSTRAINT oe_cust_mast_cert_oe_cust_mast_fk FOREIGN KEY (org_nbr_cust) REFERENCES aerodemo.oe_cust_mast(org_nbr_cust);


--
-- Name: oe_cust_mast oe_cust_mast_currency_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.oe_cust_mast
    ADD CONSTRAINT oe_cust_mast_currency_fk FOREIGN KEY (curr_cd_dflt) REFERENCES aerodemo.currency(curr_cd);


--
-- Name: oe_cust_mast oe_cust_mast_na_org_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.oe_cust_mast
    ADD CONSTRAINT oe_cust_mast_na_org_fk FOREIGN KEY (org_nbr_cust) REFERENCES aerodemo.na_org(org_nbr);


--
-- Name: oe_cust_mast oe_cust_mast_oe_cust_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.oe_cust_mast
    ADD CONSTRAINT oe_cust_mast_oe_cust_mast_fk FOREIGN KEY (org_nbr_cust_parent) REFERENCES aerodemo.oe_cust_mast(org_nbr_cust);


--
-- Name: oe_cust_mfr oe_cust_mfr_ic_item_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.oe_cust_mfr
    ADD CONSTRAINT oe_cust_mfr_ic_item_mast_fk FOREIGN KEY (item_nbr) REFERENCES aerodemo.ic_item_mast(item_nbr);


--
-- Name: oe_cust_mfr oe_cust_mfr_oe_cust_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.oe_cust_mfr
    ADD CONSTRAINT oe_cust_mfr_oe_cust_mast_fk FOREIGN KEY (org_nbr_cust) REFERENCES aerodemo.oe_cust_mast(org_nbr_cust);


--
-- Name: oe_ord_dtl oe_ord_dtl_aps_src_rule_set_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.oe_ord_dtl
    ADD CONSTRAINT oe_ord_dtl_aps_src_rule_set_fk FOREIGN KEY (aps_src_rule_set_nbr) REFERENCES aerodemo.aps_src_rule_set(aps_src_rule_set_nbr);


--
-- Name: oe_ord_dtl_cert oe_ord_dtl_cert_ic_cert_cd_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.oe_ord_dtl_cert
    ADD CONSTRAINT oe_ord_dtl_cert_ic_cert_cd_fk FOREIGN KEY (cert_cd) REFERENCES aerodemo.ic_cert_cd(cert_cd);


--
-- Name: oe_ord_dtl_cert oe_ord_dtl_cert_oe_ord_dtl_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.oe_ord_dtl_cert
    ADD CONSTRAINT oe_ord_dtl_cert_oe_ord_dtl_fk FOREIGN KEY (oe_ord_dtl_nbr) REFERENCES aerodemo.oe_ord_dtl(oe_ord_dtl_nbr);


--
-- Name: oe_ord_dtl oe_ord_dtl_ic_item_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.oe_ord_dtl
    ADD CONSTRAINT oe_ord_dtl_ic_item_mast_fk FOREIGN KEY (item_nbr_ord) REFERENCES aerodemo.ic_item_mast(item_nbr);


--
-- Name: oe_ord_dtl oe_ord_dtl_ic_um_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.oe_ord_dtl
    ADD CONSTRAINT oe_ord_dtl_ic_um_fk FOREIGN KEY (sell_um) REFERENCES aerodemo.ic_um(um_id);


--
-- Name: oe_ord_dtl oe_ord_dtl_na_org_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.oe_ord_dtl
    ADD CONSTRAINT oe_ord_dtl_na_org_fk FOREIGN KEY (org_nbr_mfr_rqst) REFERENCES aerodemo.na_org(org_nbr);


--
-- Name: oe_ord_dtl oe_ord_dtl_oe_cust_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.oe_ord_dtl
    ADD CONSTRAINT oe_ord_dtl_oe_cust_mast_fk FOREIGN KEY (org_nbr_cust) REFERENCES aerodemo.oe_cust_mast(org_nbr_cust);


--
-- Name: oe_ord_dtl oe_ord_dtl_oe_ord_hdr_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.oe_ord_dtl
    ADD CONSTRAINT oe_ord_dtl_oe_ord_hdr_fk FOREIGN KEY (oe_ord_hdr_nbr) REFERENCES aerodemo.oe_ord_hdr(oe_ord_hdr_nbr);


--
-- Name: oe_ord_dtl oe_ord_dtl_ut_user_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.oe_ord_dtl
    ADD CONSTRAINT oe_ord_dtl_ut_user_fk FOREIGN KEY (ut_user_nbr_cancel) REFERENCES aerodemo.ut_user(ut_user_nbr);


--
-- Name: oe_ord_hdr oe_ord_hdr_oe_cust_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.oe_ord_hdr
    ADD CONSTRAINT oe_ord_hdr_oe_cust_mast_fk FOREIGN KEY (org_nbr_cust) REFERENCES aerodemo.oe_cust_mast(org_nbr_cust);


--
-- Name: oe_ord_hdr oe_ord_hdr_ut_user_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.oe_ord_hdr
    ADD CONSTRAINT oe_ord_hdr_ut_user_fk FOREIGN KEY (ut_user_nbr_cancel) REFERENCES aerodemo.ut_user(ut_user_nbr);


--
-- Name: oe_ord_dtl ood_asrs_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.oe_ord_dtl
    ADD CONSTRAINT ood_asrs_fk FOREIGN KEY (aps_src_rule_set_nbr) REFERENCES aerodemo.aps_src_rule_set(aps_src_rule_set_nbr) DEFERRABLE INITIALLY DEFERRED;


--
-- Name: oe_ord_dtl ood_iim_rqst_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.oe_ord_dtl
    ADD CONSTRAINT ood_iim_rqst_fk FOREIGN KEY (item_nbr_rqst) REFERENCES aerodemo.ic_item_mast(item_nbr) DEFERRABLE INITIALLY DEFERRED;


--
-- Name: po_line_dtl pld_assp_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.po_line_dtl
    ADD CONSTRAINT pld_assp_fk FOREIGN KEY (aps_sply_sub_pool_nbr) REFERENCES aerodemo.aps_sply_sub_pool(aps_sply_sub_pool_nbr) DEFERRABLE INITIALLY DEFERRED;


--
-- Name: po_line_dtl pld_plh_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.po_line_dtl
    ADD CONSTRAINT pld_plh_fk FOREIGN KEY (po_line_hdr_nbr) REFERENCES aerodemo.po_line_hdr(po_line_hdr_nbr) DEFERRABLE INITIALLY DEFERRED;


--
-- Name: po_line_hdr plh_poh_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.po_line_hdr
    ADD CONSTRAINT plh_poh_fk FOREIGN KEY (po_ord_hdr_nbr) REFERENCES aerodemo.po_ord_hdr(po_ord_hdr_nbr) DEFERRABLE INITIALLY DEFERRED;


--
-- Name: po_line_dtl po_line_dtl_aps_sply_sub_pool_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.po_line_dtl
    ADD CONSTRAINT po_line_dtl_aps_sply_sub_pool_fk FOREIGN KEY (aps_sply_sub_pool_nbr) REFERENCES aerodemo.aps_sply_sub_pool(aps_sply_sub_pool_nbr);


--
-- Name: po_line_dtl po_line_dtl_po_line_hdr_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.po_line_dtl
    ADD CONSTRAINT po_line_dtl_po_line_hdr_fk FOREIGN KEY (po_line_hdr_nbr) REFERENCES aerodemo.po_line_hdr(po_line_hdr_nbr);


--
-- Name: po_line_dtl po_line_dtl_ut_facility_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.po_line_dtl
    ADD CONSTRAINT po_line_dtl_ut_facility_fk FOREIGN KEY (facility) REFERENCES aerodemo.ut_facility(facility);


--
-- Name: po_line_dtl po_line_dtl_ut_user_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.po_line_dtl
    ADD CONSTRAINT po_line_dtl_ut_user_fk FOREIGN KEY (ut_user_nbr_cancel) REFERENCES aerodemo.ut_user(ut_user_nbr);


--
-- Name: po_line_hdr_cert po_line_hdr_cert_ic_cert_cd_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.po_line_hdr_cert
    ADD CONSTRAINT po_line_hdr_cert_ic_cert_cd_fk FOREIGN KEY (cert_cd) REFERENCES aerodemo.ic_cert_cd(cert_cd);


--
-- Name: po_line_hdr_cert po_line_hdr_cert_po_line_hdr_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.po_line_hdr_cert
    ADD CONSTRAINT po_line_hdr_cert_po_line_hdr_fk FOREIGN KEY (po_line_hdr_nbr) REFERENCES aerodemo.po_line_hdr(po_line_hdr_nbr);


--
-- Name: po_line_hdr po_line_hdr_ic_item_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.po_line_hdr
    ADD CONSTRAINT po_line_hdr_ic_item_mast_fk FOREIGN KEY (item_nbr) REFERENCES aerodemo.ic_item_mast(item_nbr);


--
-- Name: po_line_hdr po_line_hdr_ic_um_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.po_line_hdr
    ADD CONSTRAINT po_line_hdr_ic_um_fk FOREIGN KEY (replen_um) REFERENCES aerodemo.ic_um(um_id);


--
-- Name: po_line_hdr po_line_hdr_po_ord_hdr_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.po_line_hdr
    ADD CONSTRAINT po_line_hdr_po_ord_hdr_fk FOREIGN KEY (po_ord_hdr_nbr) REFERENCES aerodemo.po_ord_hdr(po_ord_hdr_nbr);


--
-- Name: po_line_hdr po_line_hdr_ut_user_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.po_line_hdr
    ADD CONSTRAINT po_line_hdr_ut_user_fk FOREIGN KEY (ut_user_nbr_cancel) REFERENCES aerodemo.ut_user(ut_user_nbr);


--
-- Name: po_line_multiple_cert po_line_multiple_cert_ic_item_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.po_line_multiple_cert
    ADD CONSTRAINT po_line_multiple_cert_ic_item_mast_fk FOREIGN KEY (item_nbr) REFERENCES aerodemo.ic_item_mast(item_nbr);


--
-- Name: po_line_multiple_cert po_line_multiple_cert_po_line_hdr_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.po_line_multiple_cert
    ADD CONSTRAINT po_line_multiple_cert_po_line_hdr_fk FOREIGN KEY (po_line_hdr_nbr) REFERENCES aerodemo.po_line_hdr(po_line_hdr_nbr);


--
-- Name: po_mfr_mast po_mfr_mast_na_org_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.po_mfr_mast
    ADD CONSTRAINT po_mfr_mast_na_org_fk FOREIGN KEY (org_nbr_mfr) REFERENCES aerodemo.na_org(org_nbr);


--
-- Name: po_ord_hdr po_ord_hdr_ut_user_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.po_ord_hdr
    ADD CONSTRAINT po_ord_hdr_ut_user_fk FOREIGN KEY (ut_user_nbr_cancel) REFERENCES aerodemo.ut_user(ut_user_nbr);


--
-- Name: po_resched po_resched_po_line_dtl_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.po_resched
    ADD CONSTRAINT po_resched_po_line_dtl_fk FOREIGN KEY (po_line_dtl_nbr) REFERENCES aerodemo.po_line_dtl(po_line_dtl_nbr);


--
-- Name: po_resched po_resched_po_vnd_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.po_resched
    ADD CONSTRAINT po_resched_po_vnd_mast_fk FOREIGN KEY (org_nbr_vnd) REFERENCES aerodemo.po_vnd_mast(org_nbr_vnd);


--
-- Name: po_unplanned_rcpt po_unplanned_rcpt_aps_sply_sub_pool_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.po_unplanned_rcpt
    ADD CONSTRAINT po_unplanned_rcpt_aps_sply_sub_pool_fk FOREIGN KEY (aps_sply_sub_pool_nbr) REFERENCES aerodemo.aps_sply_sub_pool(aps_sply_sub_pool_nbr);


--
-- Name: po_unplanned_rcpt po_unplanned_rcpt_ic_item_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.po_unplanned_rcpt
    ADD CONSTRAINT po_unplanned_rcpt_ic_item_mast_fk FOREIGN KEY (item_nbr) REFERENCES aerodemo.ic_item_mast(item_nbr);


--
-- Name: po_unplanned_rcpt po_unplanned_rcpt_ic_lot_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.po_unplanned_rcpt
    ADD CONSTRAINT po_unplanned_rcpt_ic_lot_mast_fk FOREIGN KEY (lot_nbr) REFERENCES aerodemo.ic_lot_mast(lot_nbr);


--
-- Name: po_unplanned_rcpt po_unplanned_rcpt_po_line_hdr_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.po_unplanned_rcpt
    ADD CONSTRAINT po_unplanned_rcpt_po_line_hdr_fk FOREIGN KEY (po_line_hdr_nbr) REFERENCES aerodemo.po_line_hdr(po_line_hdr_nbr);


--
-- Name: po_unplanned_rcpt po_unplanned_rcpt_po_ord_hdr_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.po_unplanned_rcpt
    ADD CONSTRAINT po_unplanned_rcpt_po_ord_hdr_fk FOREIGN KEY (po_ord_hdr_nbr) REFERENCES aerodemo.po_ord_hdr(po_ord_hdr_nbr);


--
-- Name: po_unplanned_rcpt po_unplanned_rcpt_po_vnd_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.po_unplanned_rcpt
    ADD CONSTRAINT po_unplanned_rcpt_po_vnd_mast_fk FOREIGN KEY (org_nbr_vnd) REFERENCES aerodemo.po_vnd_mast(org_nbr_vnd);


--
-- Name: po_unplanned_rcpt po_unplanned_rcpt_ut_facility_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.po_unplanned_rcpt
    ADD CONSTRAINT po_unplanned_rcpt_ut_facility_fk FOREIGN KEY (facility) REFERENCES aerodemo.ut_facility(facility);


--
-- Name: po_vnd_mast po_vnd_mast_currency_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.po_vnd_mast
    ADD CONSTRAINT po_vnd_mast_currency_fk FOREIGN KEY (curr_cd_dflt) REFERENCES aerodemo.currency(curr_cd);


--
-- Name: po_vnd_mast po_vnd_mast_na_org_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.po_vnd_mast
    ADD CONSTRAINT po_vnd_mast_na_org_fk FOREIGN KEY (org_nbr_vnd) REFERENCES aerodemo.na_org(org_nbr);


--
-- Name: po_vnd_set_dtl po_vnd_set_dtl_po_vnd_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.po_vnd_set_dtl
    ADD CONSTRAINT po_vnd_set_dtl_po_vnd_mast_fk FOREIGN KEY (org_nbr_vnd) REFERENCES aerodemo.po_vnd_mast(org_nbr_vnd);


--
-- Name: po_vnd_set_dtl po_vnd_set_dtl_po_vnd_set_hdr_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.po_vnd_set_dtl
    ADD CONSTRAINT po_vnd_set_dtl_po_vnd_set_hdr_fk FOREIGN KEY (po_vnd_set_hdr_nbr) REFERENCES aerodemo.po_vnd_set_hdr(po_vnd_set_hdr_nbr);


--
-- Name: pos_dtl pos_dtl_ic_item_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.pos_dtl
    ADD CONSTRAINT pos_dtl_ic_item_mast_fk FOREIGN KEY (item_nbr_ship) REFERENCES aerodemo.ic_item_mast(item_nbr);


--
-- Name: pos_dtl pos_dtl_ic_lot_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.pos_dtl
    ADD CONSTRAINT pos_dtl_ic_lot_mast_fk FOREIGN KEY (lot_nbr) REFERENCES aerodemo.ic_lot_mast(lot_nbr);


--
-- Name: qa_mfr_apprv qa_mfr_apprv_ic_item_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.qa_mfr_apprv
    ADD CONSTRAINT qa_mfr_apprv_ic_item_mast_fk FOREIGN KEY (item_nbr) REFERENCES aerodemo.ic_item_mast(item_nbr);


--
-- Name: qa_mfr_apprv qa_mfr_apprv_po_mfr_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.qa_mfr_apprv
    ADD CONSTRAINT qa_mfr_apprv_po_mfr_mast_fk FOREIGN KEY (org_nbr_mfr) REFERENCES aerodemo.po_mfr_mast(org_nbr_mfr);


--
-- Name: qa_tst_rslt qa_tst_rslt_po_vnd_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.qa_tst_rslt
    ADD CONSTRAINT qa_tst_rslt_po_vnd_mast_fk FOREIGN KEY (org_nbr_vnd) REFERENCES aerodemo.po_vnd_mast(org_nbr_vnd);


--
-- Name: service_rqst_parms service_rqst_parms_service_rqst_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.service_rqst_parms
    ADD CONSTRAINT service_rqst_parms_service_rqst_fk FOREIGN KEY (service_rqst_cd) REFERENCES aerodemo.service_rqst(service_rqst_cd);


--
-- Name: sq_qte_dtl sq_qte_dtl_ic_item_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.sq_qte_dtl
    ADD CONSTRAINT sq_qte_dtl_ic_item_mast_fk FOREIGN KEY (item_nbr_qte) REFERENCES aerodemo.ic_item_mast(item_nbr);


--
-- Name: sq_qte_hdr sq_qte_hdr_oe_cust_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.sq_qte_hdr
    ADD CONSTRAINT sq_qte_hdr_oe_cust_mast_fk FOREIGN KEY (org_nbr_cust) REFERENCES aerodemo.oe_cust_mast(org_nbr_cust);


--
-- Name: sq_qte_dtl sqd_iim_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.sq_qte_dtl
    ADD CONSTRAINT sqd_iim_fk FOREIGN KEY (item_nbr_qte) REFERENCES aerodemo.ic_item_mast(item_nbr) DEFERRABLE INITIALLY DEFERRED;


--
-- Name: sq_qte_hdr sqh_ocm_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.sq_qte_hdr
    ADD CONSTRAINT sqh_ocm_fk FOREIGN KEY (org_nbr_cust) REFERENCES aerodemo.oe_cust_mast(org_nbr_cust) DEFERRABLE INITIALLY DEFERRED;


--
-- Name: job_step step_status_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.job_step
    ADD CONSTRAINT step_status_fk FOREIGN KEY (job_log_id) REFERENCES aerodemo.job_log(job_log_id);


--
-- Name: ut_etl uetl_uds_dest_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ut_etl
    ADD CONSTRAINT uetl_uds_dest_fk FOREIGN KEY (data_src_nm_dest) REFERENCES aerodemo.ut_data_src(data_src_nm) DEFERRABLE INITIALLY DEFERRED;


--
-- Name: ut_etl uetl_uds_src_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ut_etl
    ADD CONSTRAINT uetl_uds_src_fk FOREIGN KEY (data_src_nm_src) REFERENCES aerodemo.ut_data_src(data_src_nm) DEFERRABLE INITIALLY DEFERRED;


--
-- Name: ut_etl_grp_dtl uetlgd_uetl_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ut_etl_grp_dtl
    ADD CONSTRAINT uetlgd_uetl_fk FOREIGN KEY (ut_etl_grp_cd) REFERENCES aerodemo.ut_etl_grp(ut_etl_grp_cd) DEFERRABLE INITIALLY DEFERRED;


--
-- Name: ut_etl_grp_dtl uetlgd_ut_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ut_etl_grp_dtl
    ADD CONSTRAINT uetlgd_ut_fk FOREIGN KEY (ut_etl_nbr) REFERENCES aerodemo.ut_etl(ut_etl_nbr) DEFERRABLE INITIALLY DEFERRED;


--
-- Name: ut_user ut_user_na_org_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ut_user
    ADD CONSTRAINT ut_user_na_org_fk FOREIGN KEY (org_nbr) REFERENCES aerodemo.na_org(org_nbr);


--
-- Name: ut_user_role ut_user_role_ut_user_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.ut_user_role
    ADD CONSTRAINT ut_user_role_ut_user_fk FOREIGN KEY (ut_user_nbr) REFERENCES aerodemo.ut_user(ut_user_nbr);


--
-- Name: vq_qte_dtl vq_qte_dtl_ic_item_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.vq_qte_dtl
    ADD CONSTRAINT vq_qte_dtl_ic_item_mast_fk FOREIGN KEY (item_nbr_qte) REFERENCES aerodemo.ic_item_mast(item_nbr);


--
-- Name: vq_qte_dtl vq_qte_dtl_vq_qte_hdr_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.vq_qte_dtl
    ADD CONSTRAINT vq_qte_dtl_vq_qte_hdr_fk FOREIGN KEY (vq_qte_hdr_nbr) REFERENCES aerodemo.vq_qte_hdr(vq_qte_hdr_nbr);


--
-- Name: vq_qte_multiple_cert vq_qte_multiple_cert_ic_item_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.vq_qte_multiple_cert
    ADD CONSTRAINT vq_qte_multiple_cert_ic_item_mast_fk FOREIGN KEY (item_nbr) REFERENCES aerodemo.ic_item_mast(item_nbr);


--
-- Name: vq_qte_multiple_cert vq_qte_multiple_cert_vq_qte_dtl_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.vq_qte_multiple_cert
    ADD CONSTRAINT vq_qte_multiple_cert_vq_qte_dtl_fk FOREIGN KEY (vq_qte_dtl_nbr) REFERENCES aerodemo.vq_qte_dtl(vq_qte_dtl_nbr);


--
-- Name: vq_qte_dtl vqd_iim_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.vq_qte_dtl
    ADD CONSTRAINT vqd_iim_fk FOREIGN KEY (item_nbr_qte) REFERENCES aerodemo.ic_item_mast(item_nbr) DEFERRABLE INITIALLY DEFERRED;


--
-- Name: vq_qte_multiple_cert vqmc_iim_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.vq_qte_multiple_cert
    ADD CONSTRAINT vqmc_iim_fk FOREIGN KEY (item_nbr) REFERENCES aerodemo.ic_item_mast(item_nbr) DEFERRABLE INITIALLY DEFERRED;


--
-- Name: vq_qte_multiple_cert vqmc_vqd_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.vq_qte_multiple_cert
    ADD CONSTRAINT vqmc_vqd_fk FOREIGN KEY (vq_qte_dtl_nbr) REFERENCES aerodemo.vq_qte_dtl(vq_qte_dtl_nbr) DEFERRABLE INITIALLY DEFERRED;


--
-- Name: wh_facility_trans_onhand wh_facility_trans_onhand_aps_sply_sub_pool_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.wh_facility_trans_onhand
    ADD CONSTRAINT wh_facility_trans_onhand_aps_sply_sub_pool_fk FOREIGN KEY (aps_sply_sub_pool_nbr_src) REFERENCES aerodemo.aps_sply_sub_pool(aps_sply_sub_pool_nbr);


--
-- Name: wh_facility_trans_onhand wh_facility_trans_onhand_ic_item_loc_box_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.wh_facility_trans_onhand
    ADD CONSTRAINT wh_facility_trans_onhand_ic_item_loc_box_fk FOREIGN KEY (box_cd) REFERENCES aerodemo.ic_item_loc_box(box_cd);


--
-- Name: wh_facility_trans_onhand wh_facility_trans_onhand_ic_lot_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.wh_facility_trans_onhand
    ADD CONSTRAINT wh_facility_trans_onhand_ic_lot_mast_fk FOREIGN KEY (lot_nbr) REFERENCES aerodemo.ic_lot_mast(lot_nbr);


--
-- Name: wh_facility_trans_onhand wh_facility_trans_onhand_ut_facility_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.wh_facility_trans_onhand
    ADD CONSTRAINT wh_facility_trans_onhand_ut_facility_fk FOREIGN KEY (facility_src) REFERENCES aerodemo.ut_facility(facility);


--
-- Name: wh_facility_trans_onhand wh_facility_trans_onhand_ut_user_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.wh_facility_trans_onhand
    ADD CONSTRAINT wh_facility_trans_onhand_ut_user_fk FOREIGN KEY (ut_user_nbr_rqst) REFERENCES aerodemo.ut_user(ut_user_nbr);


--
-- Name: wh_facility_trans_replen wh_facility_trans_replen_aps_sply_sub_pool_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.wh_facility_trans_replen
    ADD CONSTRAINT wh_facility_trans_replen_aps_sply_sub_pool_fk FOREIGN KEY (aps_sply_sub_pool_nbr_dest) REFERENCES aerodemo.aps_sply_sub_pool(aps_sply_sub_pool_nbr);


--
-- Name: wh_facility_trans_replen wh_facility_trans_replen_po_line_dtl_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.wh_facility_trans_replen
    ADD CONSTRAINT wh_facility_trans_replen_po_line_dtl_fk FOREIGN KEY (po_line_dtl_nbr) REFERENCES aerodemo.po_line_dtl(po_line_dtl_nbr);


--
-- Name: wh_facility_trans_replen wh_facility_trans_replen_ut_facility_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.wh_facility_trans_replen
    ADD CONSTRAINT wh_facility_trans_replen_ut_facility_fk FOREIGN KEY (facility_dest) REFERENCES aerodemo.ut_facility(facility);


--
-- Name: wh_facility_trans_replen wh_facility_trans_replen_ut_user_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.wh_facility_trans_replen
    ADD CONSTRAINT wh_facility_trans_replen_ut_user_fk FOREIGN KEY (ut_user_nbr_confirm) REFERENCES aerodemo.ut_user(ut_user_nbr);


--
-- Name: wh_pick_dtl_cop_rqst wh_pick_dtl_cop_rqst_ic_item_loc_box_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.wh_pick_dtl_cop_rqst
    ADD CONSTRAINT wh_pick_dtl_cop_rqst_ic_item_loc_box_fk FOREIGN KEY (box_cd) REFERENCES aerodemo.ic_item_loc_box(box_cd);


--
-- Name: wh_pick_dtl_cop_rqst wh_pick_dtl_cop_rqst_ic_item_loc_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.wh_pick_dtl_cop_rqst
    ADD CONSTRAINT wh_pick_dtl_cop_rqst_ic_item_loc_fk FOREIGN KEY (ic_item_loc_nbr) REFERENCES aerodemo.ic_item_loc(ic_item_loc_nbr);


--
-- Name: wh_pick_dtl_cop_rqst wh_pick_dtl_cop_rqst_oe_ord_dtl_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.wh_pick_dtl_cop_rqst
    ADD CONSTRAINT wh_pick_dtl_cop_rqst_oe_ord_dtl_fk FOREIGN KEY (oe_ord_dtl_nbr) REFERENCES aerodemo.oe_ord_dtl(oe_ord_dtl_nbr);


--
-- Name: wh_pick_dtl_trans_rqst wh_pick_dtl_trans_rqst_ic_item_loc_box_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.wh_pick_dtl_trans_rqst
    ADD CONSTRAINT wh_pick_dtl_trans_rqst_ic_item_loc_box_fk FOREIGN KEY (box_cd) REFERENCES aerodemo.ic_item_loc_box(box_cd);


--
-- Name: wh_pick_dtl_trans_rqst wh_pick_dtl_trans_rqst_ic_item_loc_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.wh_pick_dtl_trans_rqst
    ADD CONSTRAINT wh_pick_dtl_trans_rqst_ic_item_loc_fk FOREIGN KEY (ic_item_loc_nbr) REFERENCES aerodemo.ic_item_loc(ic_item_loc_nbr);


--
-- Name: wh_pick_dtl_trans_rqst wh_pick_dtl_trans_rqst_wh_facility_trans_onhand_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.wh_pick_dtl_trans_rqst
    ADD CONSTRAINT wh_pick_dtl_trans_rqst_wh_facility_trans_onhand_fk FOREIGN KEY (wh_facility_trans_onhand_nbr) REFERENCES aerodemo.wh_facility_trans_onhand(wh_facility_trans_onhand_nbr);


--
-- Name: wh_pick_dtl_wo_rqst wh_pick_dtl_wo_rqst_ic_item_loc_box_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.wh_pick_dtl_wo_rqst
    ADD CONSTRAINT wh_pick_dtl_wo_rqst_ic_item_loc_box_fk FOREIGN KEY (box_cd) REFERENCES aerodemo.ic_item_loc_box(box_cd);


--
-- Name: wh_pick_dtl_wo_rqst wh_pick_dtl_wo_rqst_ic_item_loc_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.wh_pick_dtl_wo_rqst
    ADD CONSTRAINT wh_pick_dtl_wo_rqst_ic_item_loc_fk FOREIGN KEY (ic_item_loc_nbr) REFERENCES aerodemo.ic_item_loc(ic_item_loc_nbr);


--
-- Name: wh_pick_dtl_wo_rqst wh_pick_dtl_wo_rqst_wo_dtl_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.wh_pick_dtl_wo_rqst
    ADD CONSTRAINT wh_pick_dtl_wo_rqst_wo_dtl_fk FOREIGN KEY (wo_dtl_nbr) REFERENCES aerodemo.wo_dtl(wo_dtl_nbr);


--
-- Name: wo_dtl_cert wo_dtl_cert_ic_cert_cd_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.wo_dtl_cert
    ADD CONSTRAINT wo_dtl_cert_ic_cert_cd_fk FOREIGN KEY (cert_cd) REFERENCES aerodemo.ic_cert_cd(cert_cd);


--
-- Name: wo_dtl_cert wo_dtl_cert_wo_dtl_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.wo_dtl_cert
    ADD CONSTRAINT wo_dtl_cert_wo_dtl_fk FOREIGN KEY (wo_dtl_nbr) REFERENCES aerodemo.wo_dtl(wo_dtl_nbr);


--
-- Name: wo_dtl wo_dtl_ic_item_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.wo_dtl
    ADD CONSTRAINT wo_dtl_ic_item_mast_fk FOREIGN KEY (item_nbr_component) REFERENCES aerodemo.ic_item_mast(item_nbr);


--
-- Name: wo_dtl wo_dtl_ic_um_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.wo_dtl
    ADD CONSTRAINT wo_dtl_ic_um_fk FOREIGN KEY (component_um) REFERENCES aerodemo.ic_um(um_id);


--
-- Name: wo_dtl wo_dtl_po_mfr_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.wo_dtl
    ADD CONSTRAINT wo_dtl_po_mfr_mast_fk FOREIGN KEY (org_nbr_mfr_rqst) REFERENCES aerodemo.po_mfr_mast(org_nbr_mfr);


--
-- Name: wo_hdr wo_hdr_aps_sply_sub_pool_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.wo_hdr
    ADD CONSTRAINT wo_hdr_aps_sply_sub_pool_fk FOREIGN KEY (aps_sply_sub_pool_nbr) REFERENCES aerodemo.aps_sply_sub_pool(aps_sply_sub_pool_nbr);


--
-- Name: wo_hdr wo_hdr_aps_src_rule_set_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.wo_hdr
    ADD CONSTRAINT wo_hdr_aps_src_rule_set_fk FOREIGN KEY (aps_src_rule_set_nbr) REFERENCES aerodemo.aps_src_rule_set(aps_src_rule_set_nbr);


--
-- Name: wo_hdr_cert wo_hdr_cert_ic_cert_cd_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.wo_hdr_cert
    ADD CONSTRAINT wo_hdr_cert_ic_cert_cd_fk FOREIGN KEY (cert_cd) REFERENCES aerodemo.ic_cert_cd(cert_cd);


--
-- Name: wo_hdr_cert wo_hdr_cert_wo_hdr_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.wo_hdr_cert
    ADD CONSTRAINT wo_hdr_cert_wo_hdr_fk FOREIGN KEY (wo_hdr_nbr) REFERENCES aerodemo.wo_hdr(wo_hdr_nbr);


--
-- Name: wo_hdr wo_hdr_ic_item_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.wo_hdr
    ADD CONSTRAINT wo_hdr_ic_item_mast_fk FOREIGN KEY (item_nbr_rqst) REFERENCES aerodemo.ic_item_mast(item_nbr);


--
-- Name: wo_hdr wo_hdr_ic_um_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.wo_hdr
    ADD CONSTRAINT wo_hdr_ic_um_fk FOREIGN KEY (wo_um) REFERENCES aerodemo.ic_um(um_id);


--
-- Name: wo_hdr wo_hdr_oe_cust_mast_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.wo_hdr
    ADD CONSTRAINT wo_hdr_oe_cust_mast_fk FOREIGN KEY (org_nbr_cust) REFERENCES aerodemo.oe_cust_mast(org_nbr_cust);


--
-- Name: wo_hdr wo_hdr_ut_facility_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.wo_hdr
    ADD CONSTRAINT wo_hdr_ut_facility_fk FOREIGN KEY (facility) REFERENCES aerodemo.ut_facility(facility);


--
-- Name: wo_hdr wo_hdr_ut_user_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.wo_hdr
    ADD CONSTRAINT wo_hdr_ut_user_fk FOREIGN KEY (ut_user_nbr_rqst) REFERENCES aerodemo.ut_user(ut_user_nbr);


--
-- Name: wo_release wo_release_wo_hdr_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.wo_release
    ADD CONSTRAINT wo_release_wo_hdr_fk FOREIGN KEY (wo_hdr_nbr) REFERENCES aerodemo.wo_hdr(wo_hdr_nbr);


--
-- Name: wo_dtl_cert wodc_wod_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.wo_dtl_cert
    ADD CONSTRAINT wodc_wod_fk FOREIGN KEY (wo_dtl_nbr) REFERENCES aerodemo.wo_dtl(wo_dtl_nbr) DEFERRABLE INITIALLY DEFERRED;


--
-- Name: wo_hdr woh_asrs_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.wo_hdr
    ADD CONSTRAINT woh_asrs_fk FOREIGN KEY (aps_src_rule_set_nbr) REFERENCES aerodemo.aps_src_rule_set(aps_src_rule_set_nbr) DEFERRABLE INITIALLY DEFERRED;


--
-- Name: wo_hdr_cert wohc_woh_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.wo_hdr_cert
    ADD CONSTRAINT wohc_woh_fk FOREIGN KEY (wo_hdr_nbr) REFERENCES aerodemo.wo_hdr(wo_hdr_nbr) DEFERRABLE INITIALLY DEFERRED;


--
-- Name: wh_pick_dtl_wo_rqst wpdwr_wd_fk; Type: FK CONSTRAINT; Schema: aerodemo; Owner: jjs
--

ALTER TABLE ONLY aerodemo.wh_pick_dtl_wo_rqst
    ADD CONSTRAINT wpdwr_wd_fk FOREIGN KEY (wo_dtl_nbr) REFERENCES aerodemo.wo_dtl(wo_dtl_nbr) DEFERRABLE INITIALLY DEFERRED;


--
-- PostgreSQL database dump complete
--

