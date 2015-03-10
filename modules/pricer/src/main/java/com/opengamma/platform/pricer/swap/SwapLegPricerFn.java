/**
 * Copyright (C) 2014 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.platform.pricer.swap;

import com.opengamma.collect.tuple.Pair;
import com.opengamma.platform.finance.swap.SwapLeg;
import com.opengamma.platform.pricer.PricingEnvironment;
import com.opengamma.platform.pricer.sensitivity.multicurve.MulticurveSensitivity3LD;

/**
 * Pricer for swap legs.
 * <p>
 * This function provides the ability to price a {@link SwapLeg}.
 * <p>
 * Implementations must be immutable and thread-safe functions.
 * 
 * @param <T>  the type of leg
 */
public interface SwapLegPricerFn<T extends SwapLeg> {

  /**
   * Calculates the present value of the swap leg.
   * <p>
   * The amount is expressed in the currency of the leg.
   * This returns the value of the leg with discounting.
   * 
   * @param env  the pricing environment
   * @param swapLeg  the swap leg to price
   * @return the present value of the swap leg
   */
  public abstract double presentValue(PricingEnvironment env, T swapLeg);

  /**
   * Calculates the future value of the swap leg.
   * <p>
   * The amount is expressed in the currency of the leg.
   * This returns the value of the leg without discounting.
   * 
   * @param env  the pricing environment
   * @param swapLeg  the swap leg to price
   * @return the future value of the swap leg
   */
  public abstract double futureValue(PricingEnvironment env, T swapLeg);

  public abstract Pair<Double, MulticurveSensitivity3LD> presentValueCurveSensitivity3LD(
      PricingEnvironment env, T swapLeg);
}
